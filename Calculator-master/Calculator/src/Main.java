/* Chapter No. 9 - Exercise No. 6
 * File Name: Main.java
 * Programmer: Chris Adkins
 * Date Last Modified: September 17, 2018
 *
 * Problem Statement: This code should allow the user to add, subtract, multiply
 * or divide a number as many times as they want.
 *
 * Overall Plan: 
 * 1. Create the result, start it at zero.
 * 2. Take input from user.
 * 3. Do what user says.
 * 4. Ask user if they'd like to do it again. If yes, loop. If no, exit.
 *
 * This is the only class, it handles everything from IO to the calculations.
 * It needs java.util.Scanner to handle user input.
 *
 */

import java.util.Scanner; // Scanner allows us to read user input.

public class Main {
    public static void main(String args[]) {

        // Declare our variables.
        double  result    = 0.0;
        Scanner userInput = new Scanner(System.in);
        boolean exit      = false; //When true, the program will end.

        System.out.println("Calculator is on.");

        System.out.println("[Enter an operator, a space, then a number. EG: (+ 5).");
        System.out.println("Type 'q' to exit.");

        do {
            System.out.println("result = " + result); // Prints result to user.

            // Switch statement reads user input and chooses the proper operator.
            switch(userInput.next().charAt(0)) {
                case '+': result += userInput.nextDouble();
                    System.out.println(result);
                    break;

                case '-': result -= userInput.nextDouble();
                    System.out.println(result);
                    break;

                case '*': result *= userInput.nextDouble();
                    System.out.println(result);
                    break;

                case '/': result /= userInput.nextDouble();
                    System.out.println(result);
                    break;

                case 'q': exit = true;
                    break;

                default: System.out.println("Invalid Command");
            }
        } while (!exit); // Basically while the user hasn't typed 'q'.

        System.out.println("Closing calculator");
    } // End of our 'main' method.
} // End of class 'Main'.
