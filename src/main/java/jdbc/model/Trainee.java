package main.java.jdbc.model;

/**
 * @author zarin
 * @since 1/2/2022
 */
public class Trainee {

    private int ID;
    private String name;

    public Trainee(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }
}