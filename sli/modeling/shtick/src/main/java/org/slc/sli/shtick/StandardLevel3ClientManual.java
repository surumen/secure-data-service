package org.slc.sli.shtick;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slc.sli.shtick.pojo.Student;

public final class StandardLevel3ClientManual implements Level3ClientManual {

    private final Level2Client inner;

    public StandardLevel3ClientManual(final String baseUrl) {
        this(baseUrl, new StandardLevel2Client(baseUrl));
    }

    public StandardLevel3ClientManual(final String baseUrl, final Level2Client inner) {
        if (baseUrl == null) {
            throw new NullPointerException("baseUrl");
        }
        if (inner == null) {
            throw new NullPointerException("inner");
        }
        this.inner = inner;
    }

    @Override
    public List<Student> getStudents(final String token, final Map<String, Object> queryArgs) throws IOException,
            StatusCodeException {
        final List<Entity> entities = inner.getStudents(token, queryArgs);
        final List<Student> students = new ArrayList<Student>(entities.size());
        for (final Entity entity : entities) {
            students.add(new Student(entity.getData()));
        }
        return students;
    }

    @Override
    public List<Student> getStudentsById(final String token, final List<String> studentIds,
            final Map<String, Object> queryArgs) throws IOException, StatusCodeException {
        final List<Entity> entities = inner.getStudentsById(token, studentIds, queryArgs);
        final List<Student> students = new ArrayList<Student>(entities.size());
        for (final Entity entity : entities) {
            students.add(new Student(entity.getData()));
        }
        return students;
    }

    @Override
    public String postStudent(final String token, final Student student) throws IOException, StatusCodeException {
        return inner.postStudents(token, new Entity("student", student.toMap()));
    }

    @Override
    public void putStudent(final String token, final Student student) throws IOException, StatusCodeException {
        inner.putStudentsById(token, student.getId(), new Entity("student", student.toMap()));
    }

    @Override
    public void deleteStudent(final String token, final Student student) throws IOException, StatusCodeException {
        inner.deleteStudentsById(token, student.getId());
    }

    @Override
    public List<Map<String, Object>> getCustomForStudentsById(String token, List<String> studentIds, Map<String, Object> queryArgs)
            throws IOException, StatusCodeException {
        final List<Entity> entities = inner.getCustomForStudentsById(token, studentIds, queryArgs);
        final List<Map<String, Object>> customs = new ArrayList<Map<String, Object>>();
        for (final Entity entity : entities) {
            customs.add(entity.getData());
        }
        return customs;
    }

    @Override
    public void postCustomForStudentsById(String token, String id, Entity entity) throws IOException, StatusCodeException {
        inner.postCustomForStudentsById(token, id, entity);
    }
}
