
public class StudentData {
	private int studentId;
	private String studentName;
	private int studentContact;
	
	//Constructor
	public StudentData(int studentId, String studentName, int studentContact) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentContact = studentContact;
	}
	
	//getters
	public int getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public int getStudentContact() {
		return studentContact;
	}
	
}
