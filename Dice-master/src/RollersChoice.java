import java.util.Scanner;

public class RollersChoice {
    
    int numSides = -1;
    int numDice = -1;
    Scanner userInput = new Scanner(System.in);
    Dice dice = new Dice();
    
    public void play() {
        dice.getNumDice();
        dice.getNumSides();
        dice.roll(numDice, numSides);
        dice.askToReroll();
        
        switch(userInput.nextLine().toUpperCase()) {
            case "Y":
                dice.reroll();
            case "N":
                return;
        }
    }
}