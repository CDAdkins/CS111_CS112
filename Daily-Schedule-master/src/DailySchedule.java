/*
 * Chris Adkins, 2/25/2018
 * CS 111, Les Russell
 * Week 4, Project 2
 * 
 * Daily Schedule
 * This program takes a value between 1-7 (Sun-Sat) and uses it to display the schedule for the corresponding day.
 */

import java.util.Scanner;

/*
 * The program takes a user input between 1-7
 * Then the program runs a switch statement which holds all the possible days
 * Once the switch finds the right case, the lines containing the schedule are printed
 * If the integer entered is not between 1-7, the default case runs, prompting the user to enter an applicble number
 */

public class DailySchedule {
    
    public static void main(String[] arga) {
        
        int dayValue;
        String dayName;
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Enter a number between 1-7.");
        
        dayValue = userInput.nextInt();
        
        switch (dayValue) {
            
            case 1: dayName = "Sunday";
            System.out.print("Schedule for ");
            System.out.print(dayName);
            System.out.println(":");
            System.out.println("    Relax and Chill");
            break;
            
            case 2: dayName = "Monday";
            System.out.print("Schedule for ");
            System.out.print(dayName);
            System.out.println(":");
            System.out.println("    Go to Work");
            break;
            
            case 3: dayName = "Tuesday";
            System.out.print("Schedule for ");
            System.out.print(dayName);
            System.out.println(":");
            System.out.println("    Chill a Bit");
            System.out.println("    Do Some Homework");
            break;
            
            case 4: dayName = "Wednesday";
            System.out.print("Schedule for ");
            System.out.print(dayName);
            System.out.println(":");
            System.out.println("    Go to Work");
            System.out.println("    Do Some Homework");
            break;
            
            case 5: dayName = "Thursday";
            System.out.print("Schedule for ");
            System.out.print(dayName);
            System.out.println(":");
            System.out.println("    Chill a Bit");
            System.out.println("    Do Some Homework");
            System.out.println("    Have Fun in Class");
            break;
            
            case 6: dayName = "Friday";
            System.out.print("Schedule for ");
            System.out.print(dayName);
            System.out.println(":");
            System.out.println("    Go to Work");
            System.out.println("    Do Some Homework");
            System.out.println("    Blow off Some Steam");
            break;
            
            case 7: dayName = "Saturday";
            System.out.print("Schedule for ");
            System.out.print(dayName);
            System.out.println(":");
            System.out.println("    Relax and Chill");
            System.out.println("    Do Some Homework");
            break;
            
            default: System.out.println("Please only enter numbers between 1-7.");
        }
    }
    
}