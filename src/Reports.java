import java.util.InputMismatchException;
import java.util.Scanner;

public class Reports {

	private static boolean isReportsMenuOpen = true;
	private static Scanner scan = new Scanner(System.in);
	private static final int SHOW_STUDENTS = 1;
	private static final int SHOW_COURSES = 2;
	private static final int SHOW_ENROLLMENTS = 3;
	private static final int BACK_TO_MENU = 4;
	
	
	public void reportMenu() {
		while(isReportsMenuOpen) {
			try{
				System.out.println("\n1: Show Students");
				System.out.println("\n2: Show Courses");
				System.out.println("\n3: Show Enrollments");
				System.out.println("\n4: Back to Home");
				System.out.println("");
				System.out.println("\n#############################################");
				System.out.println("\nWhich action you want to perfome? (1,2,3,4)");
				
				
				int menuAction;
				
				while(true) {
					try {
						menuAction = scan.nextInt(); // taking user input for the menu action
						scan.nextLine(); // consume the next input character
						break; // exit the loop if input is valid
					}
					catch(InputMismatchException e) {
						System.out.println("\nError!!! Please Enter a Valid Input : ");
						scan.nextLine();  // consume the invalid input
					}
				}
				
				//validating the user input and perform the action
				switch(menuAction) {
				case SHOW_STUDENTS:
					viewStudents();
					break;
				case SHOW_COURSES:
					viewCourse();
					break;
				case SHOW_ENROLLMENTS:
					viewEnrollment();
					break;
				case BACK_TO_MENU:
					backToHome();
					break;
				default:
					System.out.println("\nThe Number You Entered is Invalid!!");
					System.out.println("Please Check YOur Input Again!!");
					continue;
				}
				scan.nextLine(); // consume the next input
				
			}
			catch(InputMismatchException e) {
				System.out.println("\nError - Please Enter a valid Input!");
				scan.nextLine(); // consume the next input
				continue;
			}
		}
	}
	
	void viewStudents() {
		for(StudentData  students : StudentManagement.getStudentsList()) {
			System.out.println(students.getStudentId() + " - " + students.getStudentName()+ " - " + students.getStudentContact());
		}
		backToMenu();
		
	}
	
	void viewCourse() {
		for(CourseData courses : CourseManagement.getCoursesList()) {
			System.out.println(courses.getCourseCode()+ " - " + courses.getCourseName() + " - " + courses.getCourseCredit());
		}
		backToMenu();
		
	}
	
	void viewEnrollment() {
		for(EnrollmentData enrollments : StudentEnrollment.getEnrollmentList()) {
			System.out.println(enrollments.getStudentInfo()+ " - " + enrollments.getCourseInfo());
		}
		backToMenu();
		
	}
	
	public static void backToMenu() {
		System.out.println("\nGo back to Menu : (y/n)");

			String response = scan.next().toLowerCase(); // storing the next user input as lower case 
			
			if(response.equalsIgnoreCase("n")) {
				System.out.println("\nSee you again!!");
				System.exit(0);
			}
			else if(response.equalsIgnoreCase("y")) {
				return; // return to menu
			}
			else {
				System.out.println("\nSomething Wrong!!");
			}		
		
	}
	
	public static void backToHome() {
		boolean goBack = true;
		while(goBack) {
			System.out.println("\nWant to go back? (y/n)");
			String backHomeRes = scan.next().toLowerCase();
			
			if(backHomeRes.equalsIgnoreCase("n")) {
				goBack = false;
			}
			else if(backHomeRes.equalsIgnoreCase("y")) {
				MainProcess.displayHome();
				goBack = false;
			}
			else{
				System.out.println("\nSomething Wrong!!1");
			}
		}	
	}
	
	
}
