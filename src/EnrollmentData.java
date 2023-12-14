
public class EnrollmentData {

	private StudentData studentInfo ;
	private CourseData courseInfo;
	
	
	public EnrollmentData(StudentData studentInfo, CourseData courseCode) {
		this.studentInfo = studentInfo;
		this.courseInfo = courseCode;
	}
	
	
	//getters
	public String getStudentInfo() {
		return "\n Name : " + studentInfo.getStudentName();
	}
	public String getCourseInfo() {
		return "\n Name : " + courseInfo.getCourseName();
	}
	
	
	
}
