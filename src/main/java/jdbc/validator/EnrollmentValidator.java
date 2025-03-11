package main.java.jdbc.validator;

import main.java.jdbc.dao.CourseDao;
import main.java.jdbc.dao.EnrollmentDao;
import main.java.jdbc.dao.TraineeDao;
import main.java.jdbc.model.Enrollment;

import java.sql.SQLException;

/**
 * @author zarin
 * @since 1/10/2022
 */
public class EnrollmentValidator {

    private final EnrollmentDao enrollmentDao;
    private final CourseDao courseDao;
    private final TraineeDao traineeDao;

    public EnrollmentValidator(){
        enrollmentDao=new EnrollmentDao();
        courseDao=new CourseDao();
        traineeDao=new TraineeDao();
    }

    public boolean traineeIdExists(int traineeId)throws SQLException {
        if(traineeDao.traineeIdExists(traineeId)){
            return true;
        }
        return false;
    }

    public boolean courseIdExists(int courseId)throws SQLException{
        if(courseDao.courseIdExists(courseId)){
            return true;
        }
        else
            return false;
    }

    public boolean enrollmentExist(Enrollment enrollment)throws SQLException{
        if(enrollmentDao.enrollmentExist(enrollment)){
            return true;
        }
        else {
            return false;
        }
    }
}
