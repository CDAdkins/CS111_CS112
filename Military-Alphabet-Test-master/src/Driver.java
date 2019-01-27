import java.util.Scanner;

public class Driver {

    public static void main (String args[]) {

        System.out.println("DFSFDSF");

        String[] names = {"Alfa", "Bravo", "Charlie", "Delta","Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett",
        "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra",
        "Tango", "Uniform", "Victor", "Whiskey", "Xray", "Yankee", "Zulu"};

        Scanner userInput = new Scanner(System.in);
        char firstLetter;

        int numRight = 0;
        int numWrong = 0;

        for (int ndx = 0; ndx < names.length; ndx ++) {
            firstLetter = names[ndx].charAt(0);
            System.out.println("What is the name for the letter " + firstLetter);
            String answer = userInput.nextLine();

            if (answer.toUpperCase().equals(names[ndx].toUpperCase())) {
                System.out.println("Correct!");
                numRight++;
            } else {
                System.out.println("Wrong!, the correct answer is " + names[ndx]);
                numWrong++;
            }
            System.out.println();
        }
        System.out.println("Well done!, you got " + numRight + " out of 26!");
    }
}
