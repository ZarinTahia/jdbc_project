package main.java.jdbc.validator;

import main.java.jdbc.dao.TraineeDao;
import main.java.jdbc.model.Course;
import main.java.jdbc.model.Trainee;

import java.sql.SQLException;

/**
 * @author zarin
 * @since 1/10/2022
 */
public class TraineeValidator {

    private final TraineeDao traineeDao;

    public TraineeValidator(){
        traineeDao=new TraineeDao();
    }

    public boolean addTraineeValidator(Trainee trainee) throws SQLException {
        if (traineeDao.ifTraineeExists(trainee)) {
            return true;
        }
        return false;
    }

    public boolean removeTraineeValidator(Trainee trainee) throws SQLException {
        if (traineeDao.ifTraineeExists(trainee)) {
            return true;
        }
        return false;
    }
}