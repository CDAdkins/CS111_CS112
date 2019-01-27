/* 
 * Chris Adkins, 3/4/2018
 * CS111, Les Russell
 * Week 5, Project 1
 *
 * This program takes 10 int values between 0-100 and converts them to grades(A,B,C,D,F)
 * If an input is invalid (not between 0-100) the value will be thrown out and not counted.
 * Then the grades are averaged into a GPA
 */

import java.util.Scanner;

/*
 * First the program accepts 10 inputs in a row and allocates the values to the grade variables in the order they are entered
 * As the program accepts inputs, it checks to see if the value is valid, if not the program ignores the value and prints an error message
 * If the value is valid, the program assigns the value to the proper grade variable, adds the grade value to addedGrades, and increases the gradeCount by one.
 * The program then finds the GPA by dividing the addedGrades by the gradeCount
 * The GPA is printed to two spaces by using printf()
 */

public class GPACalculator {
    
    public final static int GRADE_A = 4;
    public final static int GRADE_B = 3;
    public final static int GRADE_C = 2;
    public final static int GRADE_D = 1;
    public final static int GRADE_F = 0;
    
    public static void main(String args[]) {
        
        int    grade1      = -1;
        int    grade2      = -1;
        int    grade3      = -1;
        int    grade4      = -1;
        int    grade5      = -1;
        int    grade6      = -1;
        int    grade7      = -1;
        int    grade8      = -1;
        int    grade9      = -1;
        int    grade10     = -1;
        double gpa         = -1;
        int    gradeCount  =  0; // How many total grades were added
        int    addedGrades =  0; // Sum of all grades
        
        grade1 = getNextGrade(); // I think this should be a switch statement, but I wasn't able to think of a way to implement it properly.
        if (grade1 != -1) {
            gradeCount++;
            addedGrades += grade1;
        } else {
            System.out.println("Invalid score, it will not be counted.");
        }
        
        grade2 = getNextGrade();
        if (grade2 != -1) {
            gradeCount++;
            addedGrades += grade2;
        } else {
            System.out.println("Invalid score, it will not be counted.");
        }
        
        grade3 = getNextGrade();
        if (grade3 != -1) {
            gradeCount++;
            addedGrades += grade3;
        } else {
            System.out.println("Invalid score, it will not be counted.");
        }
        
        grade4 = getNextGrade();
        if (grade4 != -1) {
            gradeCount++;
            addedGrades += grade4;
        } else {
            System.out.println("Invalid score, it will not be counted.");
        }
        
        grade5 = getNextGrade();
        if (grade5 != -1) {
            gradeCount++;
            addedGrades += grade5;
        } else {
            System.out.println("Invalid score, it will not be counted.");
        }
        
        grade6 = getNextGrade();
        if (grade6 != -1) {
            gradeCount++;
            addedGrades += grade6;
        } else {
            System.out.println("Invalid score, it will not be counted.");
        }
        
        grade7 = getNextGrade();
        if (grade7 != -1) {
            gradeCount++;
            addedGrades += grade7;
        } else {
            System.out.println("Invalid score, it will not be counted.");
        }
        
        grade8 = getNextGrade();
        if (grade8 != -1) {
            gradeCount++;
            addedGrades += grade8;
        } else {
            System.out.println("Invalid score, it will not be counted.");
        }
        
        grade9 = getNextGrade();
        if (grade9 != -1) {
            gradeCount++;
            addedGrades += grade9;
        } else {
            System.out.println("Invalid score, it will not be counted.");
        }
        
        grade10 = getNextGrade();
        if (grade10 != -1) {
            gradeCount++;
            addedGrades += grade10;
        } else {
            System.out.println("Invalid score, it will not be counted.");
        }
        
        gpa = (double)addedGrades/gradeCount;
        
        System.out.print("Your GPA, based on ");
        System.out.print(gradeCount);
        System.out.println(" scores, is ");
        System.out.printf("%.2f", gpa);
    }
          
    public static int getNextGrade() { // Takes an entered grade (0-100) and gives it a letter grade(A-F) based on the value 
        int nextGrade = -1;
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Enter a Grade");
        nextGrade = userInput.nextInt();
        
        if (nextGrade <= 100 && nextGrade >= 90) {
        nextGrade = GRADE_A;
        } else if (nextGrade < 90 && nextGrade >= 80) {
            nextGrade = GRADE_B;
        } else if (nextGrade < 80 && nextGrade >= 70) {
            nextGrade = GRADE_C;
        } else if (nextGrade < 70 && nextGrade >= 60) {
            nextGrade = GRADE_D;
        } else if (nextGrade < 60 && nextGrade >= 0) {
            nextGrade = GRADE_F;
        } else {
            nextGrade = -1;
        }
            
        return nextGrade; 

    }
}