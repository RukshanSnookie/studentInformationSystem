import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DataHandle implements Serializable{


	private static final int SAVE_STUDENTS = 1;
	private static final int SAVE_COURSES = 2;
	private static final int SAVE_ENROLLMENTS = 3;
	private static final int BACK_TO_MENU = 4;
	private static final int EXIT = 5;
	private static final String STUDENT_FILE = "students.ser";
	private static final String COURSE_FILE = "courses.ser";
	private static final String ENROLLMENT_FILE = "enrollments.ser";
	private static boolean isDataMenuOpen = true;
	private static Scanner scan = new Scanner(System.in);

	
	
	public static void dataHandleMenu(List<StudentData> studentsList, List<CourseData> coursesList, List<EnrollmentData> enrollmentList) {
		while(isDataMenuOpen) {
			try {
				System.out.println("\n1: Save Students to a file");
				System.out.println("\n2: Save Courses to a filee");
				System.out.println("\n3: Save Enrollments to a file");
				System.out.println("\n4: Back to Home");
				System.out.println("\n5: Exit");
				System.out.println("");
				System.out.println("\n#############################################");
				System.out.println("\nWhich action you want to perfome? (1,2,3,4,5)");
				
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
				case SAVE_STUDENTS:
					saveStudents(studentsList);
					break;
				case SAVE_COURSES:
					saveCourses(coursesList);
					break;
				case SAVE_ENROLLMENTS:
					saveEnrollments(enrollmentList);
					break;
				case BACK_TO_MENU:
					backToHome();
					break;
				case EXIT:
					System.out.println("\nSee You Later!");
					System.exit(0);
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
	private static void saveStudents(List<StudentData> studentsList) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE))) { //with resources
			oos.writeObject(studentsList);
			System.out.println("\nStudents List Successfully Saved!");
			backToMenu();
		}
		catch(Exception e) {
			System.out.println("Error saving students: " + e.getMessage());
			backToMenu();
		}
	}
	
	private static void saveCourses(List<CourseData> coursesList) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(COURSE_FILE))) { //with resources
			oos.writeObject(coursesList);
			System.out.println("\nCourses List Successfully Saved!");
			backToMenu();
		}
		catch(Exception e) {
			System.out.println("Error saving courses: " + e.getMessage());
			backToMenu();
		}
	}
	
	private static void saveEnrollments(List<EnrollmentData> enrollmentList) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ENROLLMENT_FILE))) { //with resources
			oos.writeObject(enrollmentList);
			System.out.println("\nEnrollements List Successfully Saved!");
			backToMenu();
		}
		catch(Exception e) {
			System.out.println("Error saving Enrollments: " + e.getMessage());
			backToMenu();
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
}
