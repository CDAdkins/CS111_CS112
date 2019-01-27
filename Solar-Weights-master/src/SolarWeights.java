/*
 * Chris Adkins, 3/18/2018
 * Week 7, Project 1
 * 
 * This program takes a weight from the user and gives the same weight on other planets.
 */
import java.util.Scanner;

/*
 * The program creates an enum listing the planets and their corresponding mass modifiers.
 * Then the input is used as the starting weight for the program to use.
 * Then a for each loop is used to walk through the enum and print the new weights along with the corresponding planets.
 */
public class SolarWeights {
    
    enum Planets {
        MERCURY(0.38),
        VENUS(0.91),
        EARTH(1.00),
        MARS(0.38),
        JUPITER(2.34),
        SATURN(1.06),
        URANUS(0.92),
        NEPTUNE(1.19),
        PLUTO(0.06);
        
        private final double mass; // more like a mass modifier, what we multiply the startingWeight with to convert it.
        Planets(double mass) {
            this.mass = mass;
        }
    }
    
    
    public static void main(String[] args) {
        double startingWeight = -1;
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Enter your weight");
        startingWeight = userInput.nextDouble();
        
        getSolarWeights(startingWeight);
    }
    
    public static void getSolarWeights(double startingWeight) {
        for (Planets planet: Planets.values()) {
            System.out.print("Your weight on ");
            System.out.print(planet.name() + " is ");
            System.out.printf("%.1f", startingWeight * (planet.mass));
            System.out.println(" lbs");
        }
    }
    
}