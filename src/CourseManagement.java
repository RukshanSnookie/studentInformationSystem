import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CourseManagement extends Actions{
	
	private static final int ADD_COURSE = 1;
	private static final int VIEW_COURSE = 2;
	private static final int UPDATE_COURSE = 3;
	private static final int DELETE_COURSE = 4;
	private static final int BACK_TO_HOME = 5;
	private static Scanner scan = new Scanner(System.in);
	private static boolean isCourseManageMenuOpen = true;
	private static List<CourseData> coursesList = new ArrayList<>();
	private static boolean codeFound = false;
	
	
	
	// Add student method
	public void courseMenu() {
		
		while(isCourseManageMenuOpen) {
			try { 
				System.out.println("\n1: Add New Course");
				System.out.println("\n2: View Course");
				System.out.println("\n3: Update Course");
				System.out.println("\n4: Delete Course");
				System.out.println("\n5: Back TO Home");
				System.out.println("");
				System.out.println("\n#############################################");
				System.out.println("\nWhich action you want to perfome? (1,2,3,4)");
				
				int menuAction ;
				
				while(true) {
					try {
						menuAction = scan.nextInt(); // taking user input for the menu action
						scan.nextLine(); // consume the next input character
						break; // exit the loop if input is valid
					}
					catch(InputMismatchException e) {
						System.out.println("\nError!!! Please ENter a Valid Input : ");
						scan.nextLine();  // consume the invalid input
					}
				}
				
				
				//validating the user input and perform the action
				switch(menuAction) {
				case ADD_COURSE:
					add();
					break;
				case VIEW_COURSE:
					view();
					break;
				case UPDATE_COURSE:
					update();
					break;
				case DELETE_COURSE:
					delete();
					break;
				case BACK_TO_HOME:
					backToHome();
					break;
				default:
					System.out.println("\nThe Number You Entered is Invalid!!");
					System.out.println("Please Check YOur Input Again!!");
					continue;
				}
				scan.nextLine(); // consume the next input
				

			}
			catch(InputMismatchException  e) {
				System.out.println("\nError - Please Enter a valid Input!");
				scan.nextLine(); // consume the next input
				continue;
			}
		}
		
		
	}

	
	
	

	@Override
	void add() {
		System.out.println("\nAdding process>>>>>>>>>>>>>.");
		try {
			System.out.println("\nEnter Course Code: ");
			String courseCode = scan.nextLine();
			
			if(isCourseCodePresent(courseCode)) {
				System.out.println("The CODE " + courseCode + " already exists!!!");
				backToMenu();
				return;
			}
			
			System.out.println("\nEnter Course Name: ");
			String courseName = scan.nextLine();
			
			System.out.println("\nEnter Course Credit: ");
			int courseCredit = scan.nextInt();
			scan.nextLine();
			
			// create new student obj
			CourseData newCourse = new CourseData(courseCode,courseName,courseCredit);
			
			//adding to the list
			System.out.println("\nNew Course Added Successfully!!!!");
			coursesList.add(newCourse);
			backToMenu();
		}
		catch(InputMismatchException e) {
			System.out.println("\nError - Please Enter a valid Input!");
			scan.nextLine(); // consume the next input
			backToMenu();
		}
		
	}

	@Override
	void view() {
		for(CourseData courses : coursesList) {
			System.out.println(courses.getCourseCode()+ " - " + courses.getCourseName() + " - " + courses.getCourseCredit());
		}
		backToMenu();
		
	}

	@Override
	void update() {
		System.out.println("\nUpdating Course Data >>>>>>>>>>>>");
		try {
			System.out.println("\nEnter Course Code you want to update : ");
			String crsCode = scan.nextLine();//Taking user input , the unique course code
			
			for(CourseData courses : coursesList) {
				if(courses.getCourseCode().equalsIgnoreCase(crsCode)) {
					System.out.println("\nYou are going to update : " + courses.getCourseCode() + " - " + courses.getCourseName()+ " - " + courses.getCourseCredit());
					System.out.println("\nWhat you want to update Course Name or Course Credits (name/credits) ? ");
					
					//updating the course
					String updateDecision = scan.nextLine();
					if(updateDecision.trim().toLowerCase().equalsIgnoreCase("name")) {

						System.out.println("\nEnter the Updated Name : ");
						String newCourseName = scan.nextLine();
						courses.setCourseName(newCourseName); //setting new course name
						System.out.println("\nUpdated Successfully!!!!");
					}
					else if(updateDecision.trim().toLowerCase().equalsIgnoreCase("credits")) {
						System.out.println("\nEnter the Updated Course Credits");
						int newCourseCredits = scan.nextInt();
						scan.nextLine();
						courses.setCourseCredit(newCourseCredits); //setting the new course credit
						System.out.println("\nUpdated Successfully!!!!");
					}
					else {
						System.out.println("\nInvalid input! Please enter 'name' or 'contact'.");
					}
					
					codeFound = true;
					break; //stop the loop
				}
			}
			
			if(!codeFound) {
				System.out.println("Code " + crsCode + " Not Found");
			}
			backToMenu();
		}
		catch(InputMismatchException e) {
			System.out.println("\nError - Invalid Input!");
			scan.nextLine(); // consume the next input
			backToMenu();
		}
	}
		

	@Override
	void delete() {
		System.out.println("\nWarning!!! Deleting Course!!");
		
		try {
			System.out.println("\nEnter Course Code you want to Delete : ");
			String crsCode = scan.nextLine();//Taking user input , the unique course code
			
			Iterator<CourseData> iteratorCrs = coursesList.iterator(); // using Iterator
			while(iteratorCrs.hasNext()) {
				CourseData courses = iteratorCrs.next();

				if(courses.getCourseCode().equalsIgnoreCase(crsCode)) {
					System.out.println("\nYou are going to Delete : " + courses.getCourseCode() + " - " + courses.getCourseName()+ " - " + courses.getCourseCredit());
					System.out.println("\nAre you Sure? (y/n)");
					String deleteResponse = scan.nextLine(); // taking delete confirmation
					
					if(deleteResponse.trim().toLowerCase().equalsIgnoreCase("y")) {
						iteratorCrs.remove();
						System.out.println("Deleted : " + courses.getCourseCode() + " - " + courses.getCourseName()+ " - " + courses.getCourseCredit());
					}
					else if(deleteResponse.trim().toLowerCase().equalsIgnoreCase("n")) {
						System.out.println("\nDelete Process Cancelled");
						backToMenu();
					}
					
					codeFound = true;
					break; //stop the loop
				}
			}
			
			if(!codeFound) {
				System.out.println("Code " + crsCode + " Not Found");
			}
			backToMenu();
		}
		catch(InputMismatchException e) {
			System.out.println("\nError - Invalid Input!");
			scan.nextLine(); // consume the next input
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
	
	private boolean isCourseCodePresent(String courseCode) {
		
		for(CourseData course : coursesList) {
			if(course.getCourseCode().equalsIgnoreCase(courseCode) ) {
				return true; // found a duplicate ID
			}
		}	
		return false; // No duplicate ID found
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
	
	public List<CourseData> getCoursesList() {
		return coursesList;
	}

}
