package org.slc.sli.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import org.slc.sli.entity.GenericEntity;
import org.slc.sli.util.Constants;
import org.slc.sli.util.SecurityUtil;
import org.slc.sli.util.URLBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * API Client class used by the Dashboard to make calls to the API service.
 * 
 * @author svankina
 * 
 */
public class LiveAPIClient implements APIClient {

    private static Logger logger = LoggerFactory.getLogger(LiveAPIClient.class);

    private static final String TARGETS = "/targets";
    private static final String SECTIONS_URL = Constants.API_SERVER_URI + "/sections/";
    private static final String STUDENT_SECTION_ASSOC_URL = Constants.API_SERVER_URI + "/student-section-associations/";
    private static final String SCHOOLS_URL = Constants.API_SERVER_URI + "/schools/";
    private static final String STUDENTS_URL = Constants.API_SERVER_URI + "/students/";
    private static final String COURSES_URL = Constants.API_SERVER_URI + "/courses/";
    private static final String ED_ORG_URL = Constants.API_SERVER_URI + "/educationOrganizations/";
    private static final String ED_ORG_SCHOOL_ASSOC_URL = Constants.API_SERVER_URI
            + "/educationOrganization-school-associations/";
    private static final String ED_ORG_ASSOC_URL = Constants.API_SERVER_URI + "/educationOrganization-associations/";
    private static final String HOME_URL = Constants.API_SERVER_URI + "/home";
    private static final String TEACHER_SECTION_ASSOC_URL = Constants.API_SERVER_URI + "/teacher-section-associations/";
    private static final String TEACHER_SCHOOL_ASSOC_URL = Constants.API_SERVER_URI + "/teacher-school-associations/";
    private static final String COURSE_SECTION_ASSOC_URL = Constants.API_SERVER_URI + "/course-section-associations/";
    private static final String SECTION_SCHOOL_ASSOC_URL = Constants.API_SERVER_URI + "/section-school-associations/";
    private static final String STUDENT_ASSMT_ASSOC_URL = Constants.API_SERVER_URI
            + "/student-assessment-associations/";
    private static final String ASSMT_URL = Constants.API_SERVER_URI + "/assessments/";
    
    private RESTClient restClient;
    private Gson gson;

    // For now, the live client will use the mock client for api calls not yet implemented
    private MockAPIClient mockClient;

    public LiveAPIClient() {
        mockClient = new MockAPIClient();
        gson = new Gson();
    }

    /**
     * Get a list of schools for the user
     */
    @Override
    public List<GenericEntity> getSchools(String token, List<String> schoolIds) {
        
        String teacherId = getId(token);
        List<GenericEntity> sections = getSectionsForTeacher(teacherId, token);
        List<GenericEntity> schools = getSchoolsForSection(sections, token);

        List<GenericEntity> schoolList = new ArrayList<GenericEntity>();
        
        for (GenericEntity school : schools) {
            schoolList.add(school);
        }
        return schoolList;
    }

    /**
     * Get a list of student objects, given the student ids
     */
    @Override
    public List<GenericEntity> getStudents(final String token, List<String> ids) {
        if (ids == null) {
            return null;
        }
        
        List<GenericEntity> students = new ArrayList<GenericEntity>();
        
        for (String id : ids) {
            students.add(getStudent(id, token));
        }

        return students;
    }

    /**
     * Get a list of student assessment results, given a student id
     */
    @Override
    public List<GenericEntity> getStudentAssessments(final String token, String studentId) {

        // make a call to student-assessments, with the student id
        List<GenericEntity> responses = createEntitiesFromAPI(STUDENT_ASSMT_ASSOC_URL + studentId, token);
        
        // for each link in the returned list, make the student-assessment call for the result data
        List<GenericEntity> studentAssmts = new ArrayList<GenericEntity>();
        for (GenericEntity response : responses) {
            studentAssmts.add(getStudentAssessment(parseId(response.getMap(Constants.ATTR_LINK)), token));
        }
        
        return studentAssmts;
    }
    
    /**
     * Get custom data
     */
    @Override
    public List<GenericEntity> getCustomData(final String token, String key) {
        return mockClient.getCustomData(getUsername(), key);
    }

    /**
     * Get assessment info, given a list of assessment ids
     */
    @Override
    public List<GenericEntity> getAssessments(final String token, List<String> assessmentIds) {

        List<GenericEntity> assmts = new ArrayList<GenericEntity>();
        for (String assmtId : assessmentIds) {
            assmts.add(getAssessment(assmtId, token));
        }
        return assmts;
    }
    
    /**
     * Get program participation, given a list of student ids
     */
    @Override
    public List<GenericEntity> getPrograms(final String token, List<String> studentIds) {
        return mockClient.getPrograms(getUsername(), studentIds);
    }

    /**
     * Get the associated educational organizations for a school
     */
    @Override
    public List<GenericEntity> getAssociatedEducationalOrganizations(final String token, GenericEntity school) {
        String url = ED_ORG_SCHOOL_ASSOC_URL + school.get(Constants.ATTR_ID) + TARGETS;
        List<GenericEntity> responses = createEntitiesFromAPI(url, token);
        List<GenericEntity> edOrgs = new ArrayList<GenericEntity>();
        for (GenericEntity response : responses) {
            edOrgs.add(getEducationalOrganization(parseId(response.getMap(Constants.ATTR_LINK)), token));
        }
        return edOrgs;
    }
    
    /**
     * Get a list of parent ed-orgs, given an ed-org
     */
    @Override
    public List<GenericEntity> getParentEducationalOrganizations(final String token, GenericEntity edOrg) {
        String url = ED_ORG_ASSOC_URL + edOrg.get(Constants.ATTR_ID);
        List<GenericEntity> responses = createEntitiesFromAPI(url, token);
        List<GenericEntity> edOrgs = new ArrayList<GenericEntity>();
        // For every association, find the ones that this ed org is a child, and get the parent
        for (GenericEntity response : responses) {
            try {
                String assLink = (String) ((response.getMap(Constants.ATTR_LINK)).get(Constants.ATTR_HREF));
                
                GenericEntity assResponse = createEntityFromAPI(assLink, token);
                String childId = (String) (assResponse.get(Constants.ATTR_ED_ORG_CHILD_ID));
                if (childId != null && childId.equals(edOrg.get(Constants.ATTR_ID))) {
                    String parentId = assResponse.getString(Constants.ATTR_ED_ORG_PARENT_ID);
                    if (parentId != null) {
                        edOrgs.add(getEducationalOrganization(parentId, token));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException("malformed json from educationOrganization-associations api call.");
            }
        }
        return edOrgs;
    }

    /**
     * Get a list of student ids belonging to a section
     */
    private List<String> getStudentIdsForSection(String id, String token) {

        List<GenericEntity> responses = createEntitiesFromAPI(STUDENT_SECTION_ASSOC_URL + id + TARGETS, token);
        
        List<String> studentIds = new ArrayList<String>();

        for (GenericEntity response : responses) {
            studentIds.add(response.getString(Constants.ATTR_ID));
        }
        return studentIds;
    }
    
    /**
     * Get one student
     */
    private GenericEntity getStudent(String id, String token) {
        return createEntityFromAPI(STUDENTS_URL + id, token);
    }
    
    /**
     * Get one school
     */
    private GenericEntity getSchool(String id, String token) {
        return createEntityFromAPI(SCHOOLS_URL + id, token);
    }
    
    /**
     * Get one section
     */
    private GenericEntity getSection(String id, String token) {

        GenericEntity section = createEntityFromAPI(SECTIONS_URL + id, token);
        section.put(Constants.ATTR_STUDENT_UIDS, getStudentIdsForSection(id, token));

        // if no section name, fill in with section code
        if (section.get(Constants.ATTR_SECTION_NAME) == null) {
            section.put(Constants.ATTR_SECTION_NAME, section.get(Constants.ATTR_UNIQUE_SECTION_CODE));
        }

        return section;
    }

    /**
     * Get one course
     */
    private GenericEntity getCourse(String id, String token) {
        return createEntityFromAPI(COURSES_URL + id, token);
    }

    /**
     * Get one ed-org
     */
    private GenericEntity getEducationalOrganization(String id, String token) {
        return createEntityFromAPI(ED_ORG_URL + id, token);
    }

    /**
     * Get one student-assessment association
     */
    private GenericEntity getStudentAssessment(String id, String token) {
        return createEntityFromAPI(STUDENT_ASSMT_ASSOC_URL + id, token);
    }
    
    /**
     * Get one assessment
     */
    private GenericEntity getAssessment(String id, String token) {
        return createEntityFromAPI(ASSMT_URL + id, token);
    }
    
    /**
     * Get the user's unique identifier
     * 
     * @param token
     * @return
     */
    private String getId(String token) {
        
        // Make a call to the /home uri and retrieve id from there
        String returnValue = "";
        GenericEntity response = createEntityFromAPI(HOME_URL, token);
        
        for (Map link : (List<Map>) (response.get(Constants.ATTR_LINKS))) {
            if (link.get(Constants.ATTR_REL).equals(Constants.ATTR_SELF)) {
                returnValue = parseId(link);
            }
        }
        
        return returnValue;
    }
    
    /**
     * Given a link in the API response, extract the entity's unique id
     * 
     * @param link
     * @return
     */
    private String parseId(Map link) {
        String returnValue;
        int index = ((String) (link.get(Constants.ATTR_HREF))).lastIndexOf("/");
        returnValue = ((String) (link.get(Constants.ATTR_HREF))).substring(index + 1);
        return returnValue;
    }
    
    /**
     * Get a list of sections, given a teacher id
     */
    private List<GenericEntity> getSectionsForTeacher(String id, String token) {

        List<GenericEntity> responses = createEntitiesFromAPI(TEACHER_SECTION_ASSOC_URL + id + TARGETS, token);
        List<GenericEntity> sections = new ArrayList<GenericEntity>();
        
        for (GenericEntity response : responses) {
            sections.add(getSection(parseId((response.getMap(Constants.ATTR_LINK))), token));
        }

        return sections;
    }

    /**
     * Get a list of schools, given a list of sections
     * 
     * @param sections
     * @param token
     * @return
     */
    private List<GenericEntity> getSchoolsForSection(List<GenericEntity> sections, String token) {
        // collect associated course first.
        HashMap<String, GenericEntity> courseMap = new HashMap<String, GenericEntity>();
        HashMap<String, String> sectionIDToCourseIDMap = new HashMap<String, String>();
        getCourseSectionsMappings(sections, token, courseMap, sectionIDToCourseIDMap);

        // now collect associated schools.
        HashMap<String, GenericEntity> schoolMap = new HashMap<String, GenericEntity>();
        HashMap<String, String> sectionIDToSchoolIDMap = new HashMap<String, String>();
        getSchoolSectionsMappings(sections, token, schoolMap, sectionIDToSchoolIDMap);
        
        // Then create schools and associate the first one to all sections
        String teacherId = getId(token);
        String url = TEACHER_SCHOOL_ASSOC_URL + teacherId + TARGETS;
        List<GenericEntity> responses = createEntitiesFromAPI(url, token);
        for (int i = 0; i < responses.size(); i++) {
            GenericEntity response = responses.get(i);
            String schoolId = parseId(response.getMap(Constants.ATTR_LINK));
            GenericEntity school = getSchool(schoolId, token);
            schoolMap.put(schoolId, school);
            if (i == 0) {
                for (int j = 0; j < sections.size(); j++) {
                    sectionIDToSchoolIDMap.put(sections.get(j).get(Constants.ATTR_ID).toString(), schoolId);
                }
            }
        }
        
        // Now associate course and school.
        // There is no direct course-school association in ed-fi, so in dashboard
        // the "course-school" association is defined as follows:
        // course C is associated with school S if there exists a section X s.t. C is associated
        // with X and S is associated with X.
        HashMap<String, HashSet<String>> schoolIDToCourseIDMap = new HashMap<String, HashSet<String>>();

        for (int i = 0; i < sections.size(); i++) {
            GenericEntity section = sections.get(i);

            if (sectionIDToSchoolIDMap.containsKey(section.get(Constants.ATTR_ID))
                    && sectionIDToCourseIDMap.containsKey(section.get(Constants.ATTR_ID))) {
                String schoolId = sectionIDToSchoolIDMap.get(section.get(Constants.ATTR_ID));
                String courseId = sectionIDToCourseIDMap.get(section.get(Constants.ATTR_ID));
                if (!schoolIDToCourseIDMap.containsKey(schoolId)) {
                    schoolIDToCourseIDMap.put(schoolId, new HashSet<String>());
                }
                schoolIDToCourseIDMap.get(schoolId).add(courseId);
            }
        }

        // now create the generic entity
        for (String schoolId : schoolIDToCourseIDMap.keySet()) {
            for (String courseId : schoolIDToCourseIDMap.get(schoolId)) {
                GenericEntity s = schoolMap.get(schoolId);
                GenericEntity c = courseMap.get(courseId);
                s.appendToList(Constants.ATTR_COURSES, c);
            }
        }
        return new ArrayList<GenericEntity>(schoolMap.values());

    }
    
    /**
     * Get the associations between courses and sections
     */
    private void getCourseSectionsMappings(List<GenericEntity> sections, String token,
            Map<String, GenericEntity> courseMap, Map<String, String> sectionIDToCourseIDMap) {

        for (int i = 0; i < sections.size(); i++) {
            GenericEntity section = sections.get(i);
            
            // Get course using courseId reference in section
            GenericEntity course = getCourse(section.getString(Constants.ATTR_COURSE_ID), token);
            
            // Add course to courseMap, if it doesn't exist already
            if (!courseMap.containsKey(course.get(Constants.ATTR_ID))) {
                courseMap.put(course.getString(Constants.ATTR_ID), course);
            }
            
            // Grab the most up to date course from the map
            // Add the section to it's section list, and update sectionIdToCourseIdMap
            course = courseMap.get(course.get(Constants.ATTR_ID));
            course.appendToList(Constants.ATTR_SECTIONS, section);
            sectionIDToCourseIDMap.put(section.getString(Constants.ATTR_ID), course.getString(Constants.ATTR_ID));
        }
    }
    
    /**
     * Get the associations between schools and sections
     */
    private void getSchoolSectionsMappings(List<GenericEntity> sections, String token,
            Map<String, GenericEntity> schoolMap, Map<String, String> sectionIDToSchoolIDMap) {
        for (int i = 0; i < sections.size(); i++) {
            GenericEntity section = sections.get(i);
            sectionIDToSchoolIDMap.put(section.getString(Constants.ATTR_ID),
                    section.getString(Constants.ATTR_SCHOOL_ID));
            // Add school to map.
            if (!schoolMap.containsKey(section.get(Constants.ATTR_SCHOOL_ID))) {
                Map<String, String> query = new HashMap<String, String>();
                query.put(Constants.ATTR_SCHOOL_ID, (String) section.get(Constants.ATTR_SCHOOL_ID));
                schoolMap.put((String) section.get(Constants.ATTR_SCHOOL_ID),
                        createEntityFromAPI(SCHOOLS_URL + section.get(Constants.ATTR_SCHOOL_ID), token));
            }

        }
    }

    /**
     * Simple method to return a list of attendance data.
     * @return A list of attendance events for a student.
     */
    public List<GenericEntity> getStudentAttendance(final String token, String studentId) {
        String url = Constants.API_SERVER_URI + "v1/students/" + studentId + "/attendances";
        try {
            return createEntitiesFromAPI(url, token);
        } catch (Exception e) {
            logger.error("Couldn't retrieve attendance for id:" + studentId, e.getStackTrace());
            return new ArrayList<GenericEntity>();
        }
    }
    
    private String getUsername() {
        return SecurityUtil.getPrincipal().getUsername().replace(" ", "");
    }
    
    /**
     * Creates a generic entity from an API call
     * 
     * @param url
     * @param token
     * @return the entity
     */
    private GenericEntity createEntityFromAPI(String url, String token) {
        
        GenericEntity e = gson.fromJson(restClient.makeJsonRequestWHeaders(url, token), GenericEntity.class);

        return e;
    }
    
    /**
     * Retrieves an entity list from the specified API url
     * and instantiates from its JSON representation
     * 
     * @param token
     *            - the principle authentication token
     * @param url
     *            - the API url to retrieve the entity list JSON string representation
     * @return entityList
     *         - the generic entity list
     */
    private List<GenericEntity> createEntitiesFromAPI(String url, String token) {
        List<GenericEntity> entityList = new ArrayList<GenericEntity>();

        // Parse JSON
        List<Map> maps = gson.fromJson(restClient.makeJsonRequestWHeaders(url, token), new ArrayList<Map>().getClass());

        for (Map<String, Object> map : maps) {
            entityList.add(new GenericEntity(map));
        }

        return entityList;
    }
    
    private GenericEntity createEntityWithQuery(String baseUrl, Map<String, String> queries, String token) {
        URLBuilder builder = new URLBuilder(baseUrl);
        for (Map.Entry<String, String> entry : queries.entrySet()) {
            builder.addQueryParam(entry.getKey(), entry.getValue());
        }
        return gson.fromJson(restClient.makeJsonRequestWHeaders(builder.toString(), token), GenericEntity.class);
    }

    /**
     * Getter and Setter used by Spring to instantiate the live/test api class
     * 
     * @return
     */
    public RESTClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }
    
}
