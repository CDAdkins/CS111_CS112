import java.util.Scanner;

public class Grades {
    
    public static void main(String[] args) {
        
        GradesImp MyGradesImp = new GradesImp();
        
        MyGradesImp.getGrades();
        
        MyGradesImp.addGrades();
        
        MyGradesImp.calculateGpa();
        
        MyGradesImp.printGpa();
    }
}
