package main.java.jdbc.service;


import main.java.jdbc.dao.TraineeDao;
import main.java.jdbc.model.Trainee;
import main.java.jdbc.validator.TraineeValidator;
import main.java.jdbc.view.ViewOutput;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author zarin
 * @since 1/10/2022
 */
public class TraineeService {

    private final TraineeDao traineeDao;
    private final TraineeValidator traineeValidator;
    private final ViewOutput viewOutput;
    private final Scanner scanner;

    public TraineeService(){
        traineeDao=new TraineeDao();
        traineeValidator=new TraineeValidator();
        viewOutput=new ViewOutput();
        scanner = new Scanner(System.in);
    }

    public void addTrainee() throws SQLException {
        Trainee trainee=getUserTraineeInput();
        if(!traineeValidator.addTraineeValidator(trainee)){
            traineeDao.addTrainee(trainee);
        }
        else{
            viewOutput.errorInput();
        }
    }

    public void removeTrainee() throws SQLException{
        Trainee trainee=getUserTraineeInput();
        if(traineeValidator.removeTraineeValidator(trainee)){
            traineeDao.removeTrainee(trainee);
        }
        else {
            viewOutput.errorInput();
        }
    }

    public void updateTrainee()throws SQLException{
        Trainee trainee=getUserTraineeInput();
        if(traineeValidator.addTraineeValidator(trainee)){
            traineeDao.updateTrainee(trainee);
        }
        else {
            viewOutput.errorInput();
        }
    }

    public Trainee getUserTraineeInput() {
        int traineeID = scanner.nextInt();
        String traineeName = scanner.nextLine();
        Trainee trainee=new Trainee(traineeID,traineeName);
        return trainee;
    }
}