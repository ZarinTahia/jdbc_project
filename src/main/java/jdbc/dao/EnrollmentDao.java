package main.java.jdbc.dao;

import main.java.jdbc.model.Enrollment;
import main.java.jdbc.utils.DbConnection;

import java.sql.*;

/**
 * @author zarin
 * @since 1/10/2022
 */
public class EnrollmentDao {

    Connection connection = DbConnection.getConnection();

    public String getTraineeName(int traineeId) throws SQLException {
        TraineeDao traineeDao = new TraineeDao();
        String traineeName = traineeDao.getTraineeName(traineeId);
        return traineeName;
    }

    public String getCourseName(int courseId) throws SQLException {
        CourseDao courseDao = new CourseDao();
        String courseName = courseDao.getCourseName(courseId);
        return courseName;
    }

    public boolean enrollmentExist(Enrollment enrollment) throws SQLException {
        String SQL = "SELECT COUNT(*) FROM enrollment WHERE traineeID = ? AND courseID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, enrollment.getTrainee().getID());
        preparedStatement.setInt(2, enrollment.getCourse().getCourseId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        if (resultSet.getInt(1) > 0) {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            return true;
        } else {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            return false;
        }

    }

    public void addEnrollment(Enrollment enrollment) throws SQLException {
        String SQL = "INSERT INTO enrollment values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, enrollment.getTrainee().getID());
        preparedStatement.setInt(2, enrollment.getCourse().getCourseId());
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public void removeEnrollment(Enrollment enrollment) throws SQLException {
        String SQL1 = "DELETE from enrollment where traineeID=? AND courseID=?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL1,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, enrollment.getTrainee().getID());
        preparedStatement.setInt(2, enrollment.getCourse().getCourseId());
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}