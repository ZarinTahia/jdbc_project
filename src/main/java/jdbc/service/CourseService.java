package main.java.jdbc.service;

import main.java.jdbc.dao.CourseDao;
import main.java.jdbc.model.*;
import main.java.jdbc.validator.CourseValidator;
import main.java.jdbc.view.ViewOutput;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author zarin
 * @since 1/4/22
 */
public class CourseService {
    private final CourseDao courseDao;
    private final CourseValidator courseValidator;
    private final ViewOutput viewOutput;
    private final Scanner scanner;

    public CourseService() {
        courseDao = new CourseDao();
        courseValidator = new CourseValidator();
        viewOutput=new ViewOutput();
        scanner = new Scanner(System.in);
    }

    public void addCourse() throws SQLException {
        Course course=getUserCourseInput();
        if(!courseValidator.addCourseValidator(course)){
            courseDao.addCourse(course);
        }
        else{
            viewOutput.errorInput();
        }
    }

    public void removeCourse()throws SQLException{
        Course course=getUserCourseInput();
        if(courseValidator.removeCourseValidator(course)){
            courseDao.removeCourse(course);
        }
        else {
            viewOutput.errorInput();
        }
    }

    public void updateCourse()throws SQLException {
        Course course=getUserCourseInput();
        if(courseValidator.addCourseValidator(course)){
            courseDao.updateCourse(course);
        }
        else {
            viewOutput.errorInput();
        }
    }

    public Course getUserCourseIDInput() throws SQLException {
        int courseID = scanner.nextInt();
        String courseName=courseDao.getCourseName(courseID);
        Course course=new Course(courseID,courseName);
        return course;
    }

    public Course getUserCourseInput() {
        int courseID = scanner.nextInt();
        String courseName = scanner.nextLine();
        Course course=new Course(courseID,courseName);
        return course;
    }
}