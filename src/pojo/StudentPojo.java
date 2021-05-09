package pojo;

public class StudentPojo {
	
	private int studentId;
	private String studentName;
	private int studentScore;
	private String contact;
	private static int prevStudentId = 0;
	
	//Constructor for new student objects
	public StudentPojo(String studentName, int studentScore, String contact) {
		super();
		studentId = ++prevStudentId;
		this.studentName = studentName;
		this.studentScore = studentScore;
		this.contact = contact;
	}
	//Constructor for update student objects
	public StudentPojo(int  studentId, String studentName, int studentScore, String contact) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentScore = studentScore;
		this.contact = contact;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(int studentScore) {
		this.studentScore = studentScore;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public  int getStudentId() {
		return studentId;
	}
	
	@Override
	public String toString() {
		return "|studentId=" + studentId + ", studentName=" + studentName + ", studentMark=" + studentScore
				+ ", studentContact=" + contact + "|";
	}
	
	
	
}
