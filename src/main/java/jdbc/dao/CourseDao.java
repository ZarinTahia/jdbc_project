package main.java.jdbc.dao;

import main.java.jdbc.model.Course;
import main.java.jdbc.utils.DbConnection;

import java.sql.*;

/**
 * @author zarin
 * @since 1/10/2022
 */
public class CourseDao {

    Connection connection = DbConnection.getConnection();

    public boolean ifCourseExists(Course course) throws SQLException {
        String SQL = "SELECT COUNT(*) FROM course WHERE courseID = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, course.getCourseId());
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

    public boolean courseIdExists(int courseId)throws SQLException{
        String SQL = "SELECT COUNT(*) FROM course WHERE courseID = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, courseId);
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

    public String getCourseName(int courseID) throws SQLException {
        String SQL = "Select * from course where courseID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, courseID);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("course.courseName");
    }

    public void addCourse(Course course) throws SQLException {
        String SQL = "INSERT INTO course values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, course.getCourseId());
        preparedStatement.setString(2, course.getCourseName());
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public void removeCourse(Course course) throws SQLException {
        String SQL1 = "DELETE from course where courseID=?";
        String SQL2 = "DELETE from enrollment where courseID=?";
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(SQL1,
                Statement.RETURN_GENERATED_KEYS);
        PreparedStatement preparedStatement2 = connection.prepareStatement(SQL2,
                Statement.RETURN_GENERATED_KEYS);

        try{
            preparedStatement.setInt(1, course.getCourseId());
            preparedStatement2.setInt(1, course.getCourseId());
            preparedStatement.executeUpdate();
            preparedStatement2.executeUpdate();
            connection.commit();
        }catch (Exception e){
            connection.rollback();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if(preparedStatement2!=null){
            preparedStatement2.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public void updateCourse(Course course)throws SQLException{
        String SQL="UPDATE course SET courseName=? where courseID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, course.getCourseName());
        preparedStatement.setInt(2, course.getCourseId());
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}