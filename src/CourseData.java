
public class CourseData {
	private String courseCode;
	private String courseName;
	private int courseCredit;
	
	//Constructor
	public CourseData(String courseCode, String courseName, int courseCredit) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseCredit = courseCredit;
	}
	
	//getters
	public String getCourseCode() {
		return courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public int getCourseCredit() {
		return courseCredit;
	}
	
	//Setters
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
}
