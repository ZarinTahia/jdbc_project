package main.java.jdbc.controller;

import main.java.jdbc.service.TraineeService;

import java.sql.SQLException;

/**
 * @author zarin
 * @since 1/4/22
 */
public class TraineeController {

    private final TraineeService traineeService;

    TraineeController() {
        traineeService = new TraineeService();
    }

    public void addTrainee() throws SQLException {
        traineeService .addTrainee();
    }

    public void removeTrainee() throws SQLException {
        traineeService .removeTrainee();
    }

    public void updateTrainee() throws SQLException {
        traineeService .updateTrainee();
    }
}