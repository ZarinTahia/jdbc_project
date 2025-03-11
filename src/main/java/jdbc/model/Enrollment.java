package main.java.jdbc.model;

/**
 * @author dhrub
 * @since 1/10/2022
 */
public class Enrollment {

    private Trainee trainee;
    private Course course;

    public Enrollment(Trainee trainee,Course course){
        this.trainee=trainee;
        this.course=course;
    }

    public Course getCourse() {
        return course;
    }

    public Trainee getTrainee() {
        return trainee;
    }
}
