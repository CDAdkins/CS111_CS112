/*
 * Chris Adkins, 3/4/2018
 * CS111, Les Russell
 * Week 5, Project 2
 *
 * This program displays a fast food menu and reads user input to create an order.
 */

import java.util.Scanner;

/*
 * The program displays a menu consisting of food and the letter to select the items
 * The program then takes an input (A, B, C, D, E, F, or X) from the user
 * The program prints the relevant food items based on the user input
 * As long as the input is not "X", the program will continue to accept input
 * Upon reading "X", the program will end
 */

public class FastFoodMenu {
    
    /*
     * This class contains the methods main(), getInput(), and displayMenu().
     * the main method calls both methods when necessary.
     * getInput recieves the user input and checks to see what the user ordered by using the switch statement.
     * displayMenu just prints a series of lines detailing what the user should type to order the food.
     */
    
    public static String userSelection = "foo";
    
    public static void main(String[] args) {
        
        displayMenu();
        
        // recieve input as long as the user doesn't type "X"
        while(userSelection.toUpperCase() != "X") {
            getInput();
        }
    }
    
    public static void displayMenu() {
        System.out.println("[A] Cheeseburger, Onion Rings, and a Soda");
        System.out.println("[B] Hot Dog, Fries, and a Milk Shake");
        System.out.println("[C] Onion Rings and a Soda");
        System.out.println("[D] Fries and a Milk Shake");
        System.out.println("[E] Soda");
        System.out.println("[F] Milk Shake");
        System.out.println("[X] Exit");
    }
    
    public static void getInput() {
        Scanner userInput = new Scanner(System.in);
        userSelection = userInput.nextLine();
        
        switch(userSelection.toUpperCase()) { // user input is automatically converted to upper case using .toUpperCase().
            case "A": 
            System.out.println("CheeseBurger");
            
            case "C":
            System.out.println("Onion Rings");
            
            case "E":
            System.out.println("Soda");
            break;
            
            case"B":
            System.out.println("Hot Dog");
            
            case "D":
            System.out.println("Fries");
            
            case "F":
            System.out.println("Milk Shake");
            break;
            
            case "X":
            System.out.println("Order Complete");
            userSelection = "X";
            break;
            
            default:
            System.out.println("Please Enter a Valid Choice.");
            break;
        }
    }
}