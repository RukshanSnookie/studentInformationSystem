import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentManagement extends Actions{
	
	private static final int ADD_STUDENT = 1;
	private static final int VIEW_STUDENT = 2;
	private static final int UPDATE_STUDENT = 3;
	private static final int DELETE_STUDENT = 4;
	private static final int BACK_TO_HOME = 5;
	private static Scanner scan = new Scanner(System.in);
	private static boolean isStudManageMenuOpen = true;
	private static List<StudentData> studentsList = new ArrayList<>();
	
	
	
	// Add student method
	public void studentMenu() {
		
		while(isStudManageMenuOpen) {
			try { // using try with resources
				System.out.println("\n1: Add New Student");
				System.out.println("\n2: View Student");
				System.out.println("\n3: Update Student");
				System.out.println("\n4: Delete Student");
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
				case ADD_STUDENT:
					add();
					break;
				case VIEW_STUDENT:
					view();
					break;
				case UPDATE_STUDENT:
					System.out.println("Update action");
					update();
					break;
				case DELETE_STUDENT:
					System.out.println("Delete action");
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
			System.out.println("\nEnter Student ID: ");
			int studentId = scan.nextInt();
			scan.nextLine();
			
			System.out.println("\nEnter Student Name: ");
			String studentName = scan.nextLine();
			
			System.out.println("\nEnter Student Contact Number: : ");
			int studentContact = scan.nextInt();
			scan.nextLine();
			
			// create new student obj
			StudentData newStudent = new StudentData(studentId,studentName,studentContact);
			
			//adding to the list
			System.out.println("\nNew Student Added Successfully!!!!");
			studentsList.add(newStudent);
			backToMenu();
		}
		catch(InputMismatchException e) {
			System.out.println("\nError - Please Enter a valid Input!");
			scan.nextLine(); // consume the next input
		}
	}



	@Override
	void view() {
		for(StudentData  students : studentsList) {
			System.out.println(students.getStudentId() + " " + students.getStudentName()+ " " + students.getStudentContact());
		}
		backToMenu();
		
	}



	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}



	@Override
	void delete() {
		// TODO Auto-generated method stub
		
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
				System.out.println("\nSomething Wrong!!1");
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
			}
			else{
				System.out.println("\nSomething Wrong!!1");
			}
		}	
	}
	
}


