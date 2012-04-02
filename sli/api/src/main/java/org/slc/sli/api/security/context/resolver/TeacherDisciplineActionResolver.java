package org.slc.sli.api.security.context.resolver;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slc.sli.api.config.EntityNames;
import org.slc.sli.api.config.ResourceNames;
import org.slc.sli.api.security.context.AssociativeContextHelper;
import org.slc.sli.domain.Repository;
import org.slc.sli.domain.Entity;

/**
 * Resolves which DisciplineAction a given teacher is allowed to see
 * 
 * @author syau
 * 
 */
@Component
public class TeacherDisciplineActionResolver implements EntityContextResolver {
    
    @Autowired
    private Repository<Entity> repository;
    @Autowired
    private AssociativeContextHelper helper;
    
    @Override
    public boolean canResolve(String fromEntityType, String toEntityType) {
        return EntityNames.TEACHER.equals(fromEntityType) && EntityNames.DISCIPLINE_ACTION.equals(toEntityType);
    }
    
    @Override
    public List<String> findAccessible(Entity principal) {
        List<String> accessibleStudents = helper.findAccessible(principal, Arrays.asList(ResourceNames.TEACHER_SECTION_ASSOCIATIONS, 
                                                                                         ResourceNames.STUDENT_SECTION_ASSOCIATIONS));
        return helper.findEntitiesContainingReference(EntityNames.DISCIPLINE_ACTION, "studentId", accessibleStudents);
    }
}
