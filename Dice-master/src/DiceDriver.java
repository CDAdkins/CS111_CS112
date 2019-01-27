/*
 * <Student Name>, <Date>
 * CS 111, L Russell
 * Programming Assignment 10, Project 1 (Dice)
 *
 * Program Description
 * This program uses the Craps and RollersChoice classes to allow a user
 *   to play either of the two dice games.
 */
import java.util.Scanner;

public class DiceDriver {

    public static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        Craps         craps   = new Craps();
        RollersChoice rollers = new RollersChoice();
        String        choice  = "?";

        while(!choice.equalsIgnoreCase("Q")) {
            System.out.println("Select a dice game");
            System.out.println("[C]raps");
            System.out.println("[R]oller’s Choice");
            System.out.println("");
            System.out.println("[Q]uit");

            choice = keyboard.nextLine();
            switch(choice.toUpperCase()) {
                case "C":
                    craps.play();
                    break;
                case "R":
                    rollers.play();
                    break;
            }
        }
    }
}