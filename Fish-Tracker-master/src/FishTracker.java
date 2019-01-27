import java.util.Scanner;


public class FishTracker {
    
    public static void main(String[] args) {
        
        int     lotId;
        int     hatchId;
        int     monthReleased;
        int     yearReleased;
        int     serialNumber;
        boolean quit = false;
        int     answer;
        
        while (quit == false){
        
            Scanner userInput = new Scanner(System.in);
        
            System.out.println("Please enter the serial number");
            serialNumber = userInput.nextInt();
        
            lotId = (serialNumber / 1000000);   
        
            serialNumber = serialNumber % 1000000;
        
            hatchId = (serialNumber / 10000);
        
            serialNumber = serialNumber % 10000;
        
            monthReleased = (serialNumber / 100);
        
            serialNumber = serialNumber % 100;
        
            yearReleased = (serialNumber);
        
        
            System.out.print("Lot ID: ");
            System.out.println(lotId);
        
            System.out.print("Hatchery ID: ");
            System.out.println(hatchId);
        
            System.out.print("Month Released: ");
            System.out.println(monthReleased);
        
            System.out.print("Year Released: 20");
            System.out.println(yearReleased);
        
            System.out.println("Would you like to enter another? 1/0");
            
            answer = userInput.nextInt();
            
            if (answer == 0) {
                quit = true;
            } else {
                
                quit = false;
            }
            
        }
    }
    
}