package main.java.jdbc.view;

import java.util.*;

/**
 * @author zarin
 * @since 12/21/2021
 */
public class ViewInputMessage {

    public void inputMessage() {
        System.out.println("If you need course and trainee information, type: course and trainee");
        System.out.println("If you want to add new trainee, type add trainee ");
        System.out.println("If you want to drop a trainee, type drop trainee");
        System.out.println("If you want to update a trainee information, type: update trainee");
        System.out.println("If you want to add new course, type add course");
        System.out.println("If you want to drop a course, type drop course");
        System.out.println("If you want to update a course information, type: update course");
        System.out.println("If you want to enrol new trainee, type add enrollment");
        System.out.println("If you want to drop an enrollment, type drop enrollment");
        System.out.print("Your Input:");
    }
}