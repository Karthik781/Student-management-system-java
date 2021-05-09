package pojo;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
	List<StudentPojo> allStudents;
	
	public StudentDao(){
		allStudents = new ArrayList<StudentPojo>();
		
		StudentPojo s1 = new StudentPojo("mike", 20, "78337434738");
		StudentPojo s2 = new StudentPojo("smith", 25, "8954875485");
		StudentPojo s3 = new StudentPojo("adam", 30, "9847547478");
		
		allStudents.add(s1);
		allStudents.add(s2);
		allStudents.add(s3);
	}
	
	public List<StudentPojo> getStudents() {
		return allStudents;
	}
	
	public StudentPojo addStudent(StudentPojo student) {
		
		allStudents.add(student);	
		return student;
	}
	
	public boolean deleteStudent(int studentId) {
		for(StudentPojo student: allStudents) {
			if(student.getStudentId() == studentId) {
				allStudents.remove(student); 
				return true;
			}
		}
		return false;
	}
	
	public StudentPojo updateStudent(StudentPojo updatedStudent) {
		for(int i = 0; i < allStudents.size(); i++ ) {
			if(allStudents.get(i).getStudentId() == updatedStudent.getStudentId()) {
				allStudents.set(i, updatedStudent);
				return updatedStudent;
			}
		}
			
		return null;
	}
	
	public StudentPojo getObjectById(int studentId) {
		
		for(StudentPojo student: allStudents) {
			if(student.getStudentId() == studentId) {
				return student;
			}
		}
		return null;
	}
		
	
}
