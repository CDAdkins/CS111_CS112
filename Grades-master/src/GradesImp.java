import java.util.Scanner;
public class GradesImp {
    
    Scanner userInput = new Scanner(System.in);
    public int[] userGrades = new int[10];
    
    double gpa            = 0;
    double addedGrades    = 0;
    int    numberOfGrades = 0;
    
    public enum LetterGrades {
        A(4),
        B(3),
        C(2),
        D(1),
        F(0);
    
        private final int VALUE;
        LetterGrades(int VALUE) {
            this.VALUE = VALUE;
        }
    }
    
    public void getGrades() {
        System.out.println("Enter up to ten grades (A-F), to stop entering grades enter \"X\"");
        for (int ndx = 0; ndx < 10; ndx++) {
            switch (userInput.nextLine()) {
                case "a" :
                case "A" : userGrades[ndx] = LetterGrades.A.VALUE;
                numberOfGrades++;
                break;
                
                case "b" :
                case "B" : userGrades[ndx] = LetterGrades.B.VALUE;
                numberOfGrades++;
                break;
                
                case "c" :
                case "C" : userGrades[ndx] = LetterGrades.C.VALUE;
                numberOfGrades++;
                break;
                
                case "d" :
                case "D" : userGrades[ndx] = LetterGrades.D.VALUE;
                numberOfGrades++;
                break;
                
                case "f" :
                case "F" : userGrades[ndx] = LetterGrades.F.VALUE;
                numberOfGrades++;
                break;
                
                case "x" :
                case "X" : return;
                
                default : System.out.println("Invalid Grade.");
            }
        }
    }
    
    public void printAddedGrades() {
        System.out.println(addedGrades);
    }
    
    public void addGrades() {
        for (int ndx = 0; ndx < userGrades.length; ndx++) {
            
            addedGrades += userGrades[ndx];
        }
    }
    
    public void calculateGpa() {
        gpa = addedGrades / numberOfGrades;
    }
    
    public void printGpa() {
        System.out.print("Your GPA, based on ");
        System.out.print(numberOfGrades);
        System.out.print(" letter grades, is ");
        System.out.printf("%.2f", gpa);
        System.out.println();
    }
}