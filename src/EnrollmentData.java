
public class EnrollmentData {

	private StudentData studentInfo ;
	private CourseData courseInfo;
	
	
	public EnrollmentData(StudentData studentInfo, CourseData courseCode) {
		this.studentInfo = studentInfo;
		this.courseInfo = courseCode;
	}
	
	
	//getters
	public String getStudentInfo() {
		return studentInfo.getStudentName();
	}
	public String getCourseInfo() {
		return courseInfo.getCourseName();
	}
	public int getStudentId() {
		return studentInfo.getStudentId();
	}
	public String getCourseCode() {
		return courseInfo.getCourseCode();
	}
}
