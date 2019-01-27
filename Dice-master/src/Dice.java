import java.util.Scanner;

public class Dice {
    
    int[] dice = new int[5000];
    int dieChosen = -1;
    int numDice = -1;
    int numSides = -1;

    int randInt;
    
    Scanner userInput = new Scanner(System.in);
    
    public void getNumDice() {
        
        System.out.println("How many dice would you like to roll?");
        numDice = userInput.nextInt();
    }
    
    public void getNumSides() {
        if (numDice > 1) {
            System.out.println("How many sides on the dice?");
        } else if (numDice == 1) {
            System.out.println("How many sides on the die?");
        }
        numSides = userInput.nextInt();
        roll(numDice, numSides);
    }
    
    public void roll(int numDice, int numSides) {
        
        for (int ndx = 0; ndx < numDice; ndx++) {
            randInt = (int) (Math.random() * numSides);
            System.out.print("[");
            System.out.print(randInt + 1);
            System.out.println("]");
            dice[ndx] = randInt + 1;
        }
    }
    
    public void askToReroll() {
        String choice = "?";
        System.out.println("Would you like to reroll a die?");
        switch (userInput.nextLine()) {
            case "y":
            case "Y":
                reroll();
                break;
            case "n":
            case "N":
                return;
        }
    }
    
    public void reroll() {
        System.out.println("Which die would you like to reroll?");
        dieChosen = userInput.nextInt() - 1;
        randInt = (int) (Math.random() * numSides);
        dice[dieChosen] = randInt + 1;
        showDice();
    }
    
    public void showDice() {
        for (int ndx = 0; ndx < dice.length; ndx++) {
            if(dice[ndx] != 0) {
                System.out.print("[");
                System.out.print(dice[ndx]);
                System.out.println("]");
            }
        }
    }
}