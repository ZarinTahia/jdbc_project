package main.java.jdbc.dao;

import main.java.jdbc.model.Trainee;
import main.java.jdbc.utils.DbConnection;

import java.sql.*;

/**
 * @author zarin
 * @since 1/10/2022
 */
public class TraineeDao {

    Connection connection = DbConnection.getConnection();

    public boolean ifTraineeExists(Trainee trainee) throws SQLException {
        String SQL = "SELECT COUNT(*) FROM trainee WHERE traineeID = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, trainee.getID());
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

    public boolean traineeIdExists(int traineeID)throws SQLException{
        String SQL = "SELECT COUNT(*) FROM trainee WHERE traineeID = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, traineeID);
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

    public String getTraineeName(int traineeID) throws SQLException {
        String SQL = "Select * from trainee where traineeID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, traineeID);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("trainee.traineeName");
    }

    public void addTrainee(Trainee trainee) throws SQLException {
        String SQL = "INSERT INTO trainee values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, trainee.getID());
        preparedStatement.setString(2, trainee.getName());
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public void removeTrainee(Trainee trainee) throws SQLException {
        String SQL1 = "DELETE from trainee where traineeID=?";
        String SQL2 = "DELETE from enrollment where traineeID=?";
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(SQL1,
                Statement.RETURN_GENERATED_KEYS);
        PreparedStatement preparedStatement2 = connection.prepareStatement(SQL2,
                Statement.RETURN_GENERATED_KEYS);

        try{
            preparedStatement.setInt(1, trainee.getID());
            preparedStatement2.setInt(1, trainee.getID());
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

    public void updateTrainee(Trainee trainee)throws SQLException{
        String SQL="UPDATE trainee SET traineeName=? where traineeID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, trainee.getName());
        preparedStatement.setInt(2, trainee.getID());
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}