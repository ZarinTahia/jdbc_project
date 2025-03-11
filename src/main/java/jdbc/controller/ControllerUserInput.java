package main.java.jdbc.controller;

import java.util.Scanner;

/**
 * @author zarin
 * @since 1/2/2022
 */
public class ControllerUserInput {

    public static String userInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}