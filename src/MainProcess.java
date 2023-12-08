import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProcess {
	private static boolean elementPresent = true;
	private static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		//This is the Main Menu/ landing page of the program
		
		System.out.println("\nWelcome To The LearnCode SIS!");
		while(elementPresent) {
			try {
				System.out.println("\n1: Student Management");
				System.out.println("\n2: Course Management");
				System.out.println("\n3: Enrollment");
				System.out.println("\n4: Reports");
				System.out.println("\n5: Data Handle & Exit");
				System.out.println("\nPlease Enter the Page Number");
				
				int menuOption = scan.nextInt(); //taking user input to navigate relevant page
				scan.nextLine(); // consume next input character
				
				switch(menuOption) {
				case 1:
					System.out.println("\nNavigating to Student Management Page");
					break;
				case 2:
					System.out.println("\nNavigating to Course Management Page");
					break;
				case 3:
					System.out.println("\nNavigating to Enrollment Page");
					break;
				case 4:
					System.out.println("\nNavigating to Reports Page");
					break;
				case 5:
					System.out.println("\nNavigating to Data Handling & Exit Page");
					break;
				default:
					System.out.println("\nThe Number You Entered is Invalid!!");
					System.out.println("Please Check YOur Input Again!!");
					continue;
				}
				scan.nextLine(); // consume the next input character
				
			}
			catch(InputMismatchException  e) {
				System.out.println("\nError - Please Enter a valid Input!");
				scan.nextLine(); // consume next input character
				continue;
			}
		}
		
		scan.close(); //closing the scanner , outside the loop
	}

}
