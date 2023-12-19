import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProcess {
	private static boolean elementPresent = true;
	private static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		//This is the Main Menu/ landing page of the program
		
		displayHome();
		
		scan.close(); //closing the scanner , outside the loop
	}

	public static void displayHome() {
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
					System.out.println("");
					System.out.println("");
					System.out.println("\n#############################################");
					System.out.println("\n############# STUDENT MANAGEMENT #############");
					System.out.println("\n#############################################");
					StudentManagement std = new StudentManagement();
					std.studentMenu();
					break;
				case 2:
					System.out.println("");
					System.out.println("");
					System.out.println("\n#############################################");
					System.out.println("\n############# COURSE MANAGEMENT #############");
					System.out.println("\n#############################################");
					CourseManagement crs = new CourseManagement();
					crs.courseMenu();
					break;
				case 3:
					System.out.println("");
                    System.out.println("");
                    System.out.println("\n#############################################");
                    System.out.println("\n############# ENROLLMENT #############");
                    System.out.println("\n#############################################");


                    // Display enrollment menu
                    StudentEnrollment.enrollmentMenu(StudentManagement.getStudentsList(), CourseManagement.getCoursesList());
                    break;
				case 4:
					System.out.println("");
					System.out.println("");
					System.out.println("\n#############################################");
					System.out.println("\n################ REPORTS ################");
					System.out.println("\n#############################################");
					Reports reports = new Reports();
					reports.reportMenu();
					break;
				case 5:
					System.out.println("");
					System.out.println("");
					System.out.println("\n#############################################");
					System.out.println("\n############# DATA MANAGEMENT/EXIT #############");
					System.out.println("\n#############################################");

					
					DataHandle.dataHandleMenu(StudentManagement.getStudentsList(), CourseManagement.getCoursesList(), StudentEnrollment.getEnrollmentList());
					break;
				default:
					System.out.println("\nThe Number You Entered is Invalid!!");
					System.out.println("\nPlease Check YOur Input Again!!");
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
	}
}
