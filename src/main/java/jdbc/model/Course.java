package main.java.jdbc.model;

/**
 * @author dhrub
 * @since 1/10/2022
 */
public class Course {

    private int courseId;
    private String courseName;

    public Course(int courseId,String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}
