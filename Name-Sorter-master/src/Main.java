/* Chapter No. 10 - Excercise No. 1
 * Programmer: Chris Adkins
 * File Name Main.java
 * Date last modified: October 2, 2018
 *
 * Problem Statement: This code should allow the user to search for a male, or female name
 * within a database of male and female names with 1000 entries each.
 * 
 * Overall plan: 
 * 1. Populate two arrays each containing 1000 names for their respective gender.
 * 2. Take input from user and search arrays for the name selected.
 * 3. Output relevant info regarding name if name is in list.
 *
 * This is the main class, it handles all IO and holds almost all of the variables.
 * It utilizes the Name class to fill the arrays and hold the data  relevant to the names.
 *
 */

import java.io.FileInputStream; //Allows us to access external files.
import java.io.FileNotFoundException; //Stops program from crashing if file can't be found.
import java.util.Scanner; //Lets us take input from usre and "read" through external files.

public class Main {
    public static void main(String args[]) {

        Name[]  boyNames         = new Name[1000]; // Array of male names
        Name[]  girlNames        = new Name[1000]; //Array of female names
        Scanner userInput        = new Scanner(System.in);
        Scanner inputStreamBoys  = null; // Reads through boynames.txt
        Scanner inputStreamGirls = null; // Reads through girlnames.txt
        String nameChosen        = null; // The name the user is searching for
        boolean nameInBoyList    = false;
        boolean nameInGirlList   = false;

        try { //Looks for the two files, boynames.txt and girlnames.txt
            inputStreamGirls = new Scanner(new FileInputStream("girlnames.txt"));
            inputStreamBoys = new Scanner(new FileInputStream("boynames.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("That file does not exist.");
        }

        for (int ndx = 0; ndx < boyNames.length; ndx++) { //Populates boyNames array
            boyNames[ndx] = new Name();
            boyNames[ndx].name = inputStreamBoys.next();
            boyNames[ndx].numNamings = inputStreamBoys.nextInt();
            boyNames[ndx].popRank = ndx + 1;
        }


        for (int ndx = 0; ndx < girlNames.length; ndx++) { //Populates girlNames array
            girlNames[ndx] = new Name();
            girlNames[ndx].name = inputStreamGirls.next();
            girlNames[ndx].numNamings = inputStreamGirls.nextInt();
            girlNames[ndx].popRank = ndx + 1;
        }

        System.out.println("[Enter a name]"); //Compares user's name choice with
        nameChosen = userInput.nextLine();    //every boy name until it finds a match.
        for (int ndx = 0; ndx < boyNames.length; ndx ++) {
            if (nameChosen.toUpperCase().equals(boyNames[ndx].name.toUpperCase())) {
                System.out.println(boyNames[ndx].name + " is ranked " + 
                boyNames[ndx].popRank + " in popularity among boys with " + boyNames[ndx].numNamings + " namings.");
                nameInBoyList = true;
                break;
            }
        }
        if (!nameInBoyList) { // If the name is not in the boyNames array
            System.out.println(nameChosen + " is not ranked among the top 1000 boy names.");
        }
        for (int ndx = 0; ndx < girlNames.length; ndx ++) {
            if (nameChosen.toUpperCase().equals(girlNames[ndx].name.toUpperCase())) {
                System.out.println(girlNames[ndx].name + " is ranked " + 
                girlNames[ndx].popRank + " in popularity among girls with " + girlNames[ndx].numNamings + " namings.");
                nameInGirlList = true;
                break;
            }
        }
        if (!nameInGirlList) { // If name is not in the girlNames array
            System.out.println(nameChosen + " is not ranked among the top 1000 girl names.");
        }
    }
}
