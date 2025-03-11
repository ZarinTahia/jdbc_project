package main.java.jdbc.controller;

import main.java.jdbc.service.CourseService;

import java.sql.SQLException;

/**
 * @author zarin
 * @since 1/4/22
 */
public class CourseController {

    private final CourseService courseService;

    CourseController() {
        courseService = new CourseService();
    }

    public void addCourse() throws SQLException {
        courseService.addCourse();
    }

    public void removeCourse() throws SQLException {
        courseService.removeCourse();
    }

    public void updateCourse() throws SQLException {
        courseService.updateCourse();
    }
}