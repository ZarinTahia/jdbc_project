package main.java.jdbc.validator;

import main.java.jdbc.dao.CourseDao;
import main.java.jdbc.model.Course;

import java.sql.SQLException;

/**
 * @author zarin
 * @since 1/10/2022
 */
public class CourseValidator {

    private final CourseDao courseDao;

    public CourseValidator(){
        courseDao=new CourseDao();
    }

    public boolean addCourseValidator(Course course) throws SQLException {
        if (courseDao.ifCourseExists(course)) {
            return true;
        }
        return false;
    }

    public boolean removeCourseValidator(Course course) throws SQLException {
        if (courseDao.ifCourseExists(course)) {
            return true;
        }
        return false;
    }
}