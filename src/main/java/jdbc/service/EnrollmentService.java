package main.java.jdbc.service;


import main.java.jdbc.dao.EnrollmentDao;
import main.java.jdbc.model.Course;
import main.java.jdbc.model.Enrollment;
import main.java.jdbc.model.Trainee;
import main.java.jdbc.validator.EnrollmentValidator;
import main.java.jdbc.view.ViewOutput;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author zarin
 * @since 1/10/2022
 */
public class EnrollmentService {

    private final EnrollmentDao enrollmentDao;
    private final EnrollmentValidator enrollmentValidator;
    private final ViewOutput viewOutput;
    private final Scanner scanner;

    public EnrollmentService(){
        enrollmentDao=new EnrollmentDao();
        enrollmentValidator=new EnrollmentValidator();
        viewOutput=new ViewOutput();
        scanner=new Scanner(System.in);
    }

    public void addEnrollment() throws SQLException {
       Course course=getCourse();
       Trainee trainee=getTrainee();
       if(course==null||trainee==null){
           return;
       }
       else{
           Enrollment enrollment=new Enrollment(trainee,course);
           if(!enrollmentValidator.enrollmentExist(enrollment)){
               enrollmentDao.addEnrollment(enrollment);
           }
           else{
               viewOutput.errorInput();
           }
       }

    }

    public void removeEnrollment() throws SQLException {
        Course course=getCourse();
        Trainee trainee=getTrainee();
        if(course==null||trainee==null){
            return;
        }
        else{
            Enrollment enrollment=new Enrollment(trainee,course);
            if(enrollmentValidator.enrollmentExist(enrollment)){
                enrollmentDao.removeEnrollment(enrollment);
            }
            else{
                viewOutput.errorInput();
            }
        }
    }

    public Trainee getTrainee()throws SQLException {
        Trainee trainee=null;
        int traineeId=scanner.nextInt();
        if(enrollmentValidator.traineeIdExists(traineeId)){
             String traineeName=enrollmentDao.getTraineeName(traineeId);
             trainee=new Trainee(traineeId,traineeName);
        }
        else{
            viewOutput.traineeIdError();
        }
        return trainee;
    }

    public Course getCourse()throws SQLException{
        Course course=null;
        int courseId=scanner.nextInt();
        if(enrollmentValidator.courseIdExists(courseId)){
            String courseName=enrollmentDao.getCourseName(courseId);
            course=new Course(courseId,courseName);
        }
        else{
            viewOutput.courseIdError();
        }
        return course;
    }
}