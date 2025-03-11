package main.java.jdbc.controller;

import main.java.jdbc.utils.DbConnection;
import main.java.jdbc.view.ViewInputMessage;
import main.java.jdbc.view.ViewOutput;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zarin
 * @since 1/2/2022
 */
public class ControllerMain {

    public static void main(String[] args) throws SQLException {
        CourseController courseController = new CourseController();
        EnrolledController enrolledController = new EnrolledController();
        TraineeController traineeController = new TraineeController();
        ViewInputMessage inputMessage = new ViewInputMessage();
        ViewOutput viewOutput=new ViewOutput();
        inputMessage.inputMessage();
        ControllerUserInput input = new ControllerUserInput();
        String userInput = input.userInput();
        switch (userInput) {
            case "add course":
                courseController.addCourse();
                break;
            case "drop course":
                courseController.removeCourse();
                break;
            case "update course":
                courseController.updateCourse();
                break;
            case "add trainee":
                traineeController.addTrainee();
                break;
            case "drop trainee":
                traineeController.removeTrainee();
                break;
            case "update trainee":
                traineeController.updateTrainee();
                break;
            case "add enrollment":
                enrolledController.addEnrollment();
                break;
            case "drop enrollment":
                enrolledController.removeEnrollment();
                break;
            default:
                viewOutput.errorInput();
        }
    }
}