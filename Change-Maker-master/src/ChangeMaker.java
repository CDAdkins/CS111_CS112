/*
 * Chris Adkins, 2/15/2018
 * CS111, Les Russell
 * Assignment 1, Project 2
 *
 * Change Maker
 * This program takes an item priced between $0.25-$4.95 (only in 5 cent increments) and tells you the most effective way to get your change.
 */

import java.util.Scanner;

/*
 * The user inputs the price of the item, as well as the amount paid
 * These inputs are set to the variables costAmount and amountPaid, respectively. Both of these values are multiplied by 100 to make sure nothing is truncated when we calculate the changeAmount.
 * The variable changeAmount is an int set equal to the amountPaid - costAmount, this value will be changed multiple times as we calculate the amount of each coin.
 * dollarAmount, quarterAmount, dimeAmount, and nickelAmount are all given a value dependant on how many times they go into changeAmount.
 * The values of these variables are set in order from largest to smallest, then the number of that coin, multiplied by the coin's value is subtracted from the changeAmount before calculating 
 * how many of the next coin we need.
 * The program then outputs the type of change (Dollar, Nickel, etc.) followed by how many are included in the change.
 * NOTE: The only thing stopping this program from calculating penny amounts is the lack of a pennyAmount variable, the value would be calculated after nickelAmount, pennyAmount would be equal to
 * changeAmount by the end of the program.
 */

public class ChangeMaker {
    
    /*
     * Everything this program does is inside of this class.
     */
    
    public static void main(String[] args) {
        
        double  costAmount    = 0;
        int     amountPaid    = 0;
        int     changeAmount  = 0;    // Total amount of change left, changes as the program runs, presented as an int. (Ex. $4.35 = 435).
        int     dollarAmount  = 0;
        int     quarterAmount = 0;
        int     dimeAmount    = 0;
        int     nickelAmount  = 0;
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Please enter the price of the item ($0.25-$4.95):");
        costAmount = userInput.nextDouble() * 100;
        
        System.out.println("Please enter the amount paid in whole dollars ($1-$5):"); 
        amountPaid = userInput.nextInt() * 100;
        
        changeAmount  = (int)(amountPaid - costAmount);    
        dollarAmount  = changeAmount / 100;
        changeAmount -= (dollarAmount * 100);
        quarterAmount = changeAmount / 25;
        changeAmount -= (quarterAmount * 25);
        dimeAmount    = changeAmount / 10;
        changeAmount -= (dimeAmount * 10);
        nickelAmount  = changeAmount / 5;
        changeAmount -= (nickelAmount * 5);
        
        System.out.println("Your change is:");
        
        if (dollarAmount == 1) {
            System.out.println(dollarAmount + " dollar");
        } else {
            System.out.println(dollarAmount + " dollars");
        }
        
        if (quarterAmount == 1) {
            System.out.println(quarterAmount + " quarter");
        } else {
            System.out.println(quarterAmount + " quarters");
        }
        
        if (dimeAmount == 1) {
            System.out.println(dimeAmount + " dime");
        } else {
            System.out.println(dimeAmount + " dimes");
        }
        
        if (nickelAmount == 1) {
            System.out.println(nickelAmount + " nickel");
        } else {
            System.out.println(nickelAmount + " nickels");
        }
    }
    
}