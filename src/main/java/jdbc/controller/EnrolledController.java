package main.java.jdbc.controller;

import main.java.jdbc.service.EnrollmentService;

import java.sql.SQLException;

/**
 * @author zarin
 * @since 1/4/22
 */
public class EnrolledController {

    private final EnrollmentService enrollmentService;

    public EnrolledController(){
        enrollmentService=new EnrollmentService();
    }
    public void addEnrollment() throws SQLException {
        enrollmentService.addEnrollment();
    }

    public void removeEnrollment() throws SQLException {
        enrollmentService.removeEnrollment();
    }
}