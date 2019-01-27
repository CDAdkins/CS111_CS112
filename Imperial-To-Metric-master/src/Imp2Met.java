import java.util.Scanner;

public class Imp2Met {
	
	int feet = 0;
	int choice = 0;
	double inches;
	double meters;
	double totalInches;
	double inchesRemaining;
	Scanner userInput = new Scanner(System.in);
	
	public static void main(String args[]) {
		Imp2Met con = new Imp2Met();
		con.menu();
		
		switch(con.choice) {
			case 1: con.metricToEnglish();
			break;
			
			case 2: con.englishToMetric();
			break;
			
			case 3: 
			break;
		}
	}
	
	public int menu() {
		System.out.println("Choose 1 to convert from English to Metric system");
		System.out.println("Choose 2 to convert from Metric to English system");
		System.out.println("Choose 3 to exit");
		choice  = userInput.nextInt();
		return choice;
	}
	
	public void englishToMetric() {
		System.out.println("Enter the number in feet and then inches");
		feet = userInput.nextInt();
		inches = userInput.nextDouble();
		
		if (inches < 12) {
			totalInches = 12 * feet + inches;
			meters = totalInches / 39.3701;
			System.out.printf("%.2f", meters);
			System.out.println(" meters");
		} else {
			System.out.println("Enter a number below 12");
		}
	}
	
	public void metricToEnglish() {
		System.out.println("Enter the number in meters to the nearest hundredth");
		meters = userInput.nextDouble();
		inches = meters * 39.3701;
		feet = (int)inches/12;
		inchesRemaining = feet%12;
		System.out.println(feet + " feet" + inchesRemaining + " inches");
	}
}