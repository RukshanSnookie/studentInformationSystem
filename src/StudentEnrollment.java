import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentEnrollment {

	private static Scanner scan = new Scanner(System.in);
	private static List<EnrollmentData> enrollmentList = new ArrayList<>();
	private static boolean isEnrollMenuOpen = true;
	public static final int STUDENT_ENROLL = 1;
	public static final int VIEW_COURSE_STUDENTS = 2;
	public static final int VIEW_STUDENT_COURSES = 3;
	public static final int BACK_TO_HOME_SE = 4;
	
	
	public static void enrollmentMenu(List<StudentData> studentsList, List<CourseData> coursesList) {
		
		while(isEnrollMenuOpen) {
			try {
				System.out.println("\n1: Enroll Students to Course");
				System.out.println("\n2: View Course (Displaying all enrolled Students)");
				System.out.println("\n3: View Student (Displaying all enrolled Courses)");
				System.out.println("\n4: Back To Home Page");
				
				System.out.println("\nPlease Select an Option!");
				int enrolRes = scan.nextInt();
				scan.nextLine();
				
				switch(enrolRes) {
				case STUDENT_ENROLL:
					enrollStudentsToCourse(studentsList, coursesList);// passing lists as arguments
					break;
				case VIEW_COURSE_STUDENTS:
					System.out.println("\nview course with students");
					break;
				case VIEW_STUDENT_COURSES:
					System.out.println("\nview students with courses");
					break;
				case BACK_TO_HOME_SE:
					backToHome();
					break;
				}
				scan.nextLine();
				
				
			}
			catch(InputMismatchException e) {
				System.out.println("\nError - Please Enter a valid Input!");
				scan.nextLine(); // consume the next input
				continue;
			}
		}
	}
	
	
	public static void enrollStudentsToCourse(List<StudentData> studentsList, List<CourseData> coursesList ) {
		System.out.println("\nEnrolling Students to Courses!");
		try {
			
			if(studentsList.isEmpty() || coursesList.isEmpty()) {
				System.out.println("\nPlease Add Students/Courses First!!");
				backToMenu();
			}
			else {
				//view available students
				System.out.println("\nAvailable Students");
				for(StudentData  students : studentsList) {
					System.out.println(students.getStudentId() + " - " + students.getStudentName()+ " - " + students.getStudentContact());
				}
				
				System.out.println("\nPlease Enter the Student ID to select Student : ");
				int enrStudId = scan.nextInt();
				scan.nextLine();
				
				for(StudentData students : studentsList) { // iterating through the students list
					if(students.getStudentId() == enrStudId) { // check if user entered student ID matching the ID in the students list
						System.out.println("\nYou are enrolliing " + students.getStudentName() + " to new course.");
						System.out.println("\nSelect the course code you want to add to this student");
						//view available courses
						System.out.println("\nAvailable Courses");
						for(CourseData courses : coursesList) {
							System.out.println(courses.getCourseCode()+ " - " + courses.getCourseName() + " - " + courses.getCourseCredit());
							System.out.println("\nEnter the Course Code : ");
							String courseRes = scan.nextLine();
							
							//checking if the entered course code is in the list
							if(courses.getCourseCode().equalsIgnoreCase(courseRes)) {
								add(students,courses); // calling the add method and adding new enrollment to the list
								System.out.println("\nNew Enrollment Completed!!");
								
								//testing purpose
								for(EnrollmentData e : enrollmentList) {
									System.out.println(e.getStudentInfo() + "-" + e.getCourseInfo());
								}
							}
							else {
								System.out.println("\nPlease check the Student ID again!!");
								break;
							}
						
						}
					}
					else {
						System.out.println("\nPlease check the Student ID again!!");
						break;
					}
				}
				
				
				
				
			}	
			
		}
		catch(Exception e) {
			System.out.println("\nError,,,Please Enter a valid Input!");
			scan.nextLine();
		}
		
	}
	
	//adding enrolled students name and the course to the list
	private static void add(StudentData studentInfo, CourseData courseInfo) {	
		EnrollmentData enrolledStud = new EnrollmentData(studentInfo, courseInfo);
		enrollmentList.add(enrolledStud);
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
