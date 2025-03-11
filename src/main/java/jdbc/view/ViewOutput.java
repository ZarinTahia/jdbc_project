package main.java.jdbc.view;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zarin
 * @since 1/2/2022
 */
public class ViewOutput {

    public void errorInput() {
        System.out.println("Unknown Input Value");
    }

    public void printTraineeAndCourseInfo(ResultSet result)throws SQLException {
        System.out.println("Course_ID " + "Course_name " + "Trainee_ID " + "Trainee_name");
        System.out.println("---------------------------------------------");
        while (result.next()) {
            System.out.printf("%5s %15s %10s %5s", result.getString("course.CourseID"), result.getString("course.Coursename"), result.getString("trainee.TraineeID"), result.getString("trainee.Traineename"));
            System.out.println();
        }
    }

    public void traineeIdError(){
        System.out.println("Trainee ID Error");
    }

    public void courseIdError(){
        System.out.println("Course ID Error");
    }
}