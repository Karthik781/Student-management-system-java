

import java.util.List;
import java.util.Scanner;

import com.sms.exception.InvalidContactException;
import com.sms.pojo.StudentPojo;
import com.sms.service.StudentService;
import com.sms.service.StudentServiceImpl;

public class StudentDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentService studentService = new StudentServiceImpl();
		StudentPojo sObj;
		
char repeat = 'n';
		
		do {
			System.out.println("************************************");
			System.out.println("Student Management System");
			System.out.println("************************************");
			System.out.println("1. Display all students.");
			System.out.println("2. Add a new Student.");
			System.out.println("3. Remove a Student.");
			System.out.println("4. Update Contact Number.");
			System.out.println("5. Update Student Name.");
			System.out.println("6. Exit.");
			System.out.println("************************************");
			System.out.print("Enter your option : ");
			int option = scan.nextInt();
			System.out.println("************************************");
			
			switch(option) {
			case 1:
				List<StudentPojo> myStudents = studentService.getStudents();
				myStudents.forEach((i)-> System.out.println(i));
				System.out.println("************************************");
				System.out.print("Do you want to continue?(y/n)");
				repeat = scan.next().charAt(0);
				System.out.println("************************************");
				break;
				
			case 2:
				System.out.print("Please enter Student Name: ");
				String sName = scan.next();
				System.out.print("Please enter Student Mark: ");
				int sMark = scan.nextInt();
				System.out.println("Please enter Student Contact: ");
				String sContact = scan.next();
				
				StudentPojo studentPojo = new StudentPojo(sName, sMark, sContact);
				try {
					StudentPojo addedStudent = studentService.addStudent(studentPojo);
					System.out.println("Student added Successfully!!");
					System.out.println("New student id is : " + addedStudent.getStudentId());
				} catch(InvalidContactException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("************************************");
				System.out.print("Do you want to continue?(y/n)");
				repeat = scan.next().charAt(0);
				System.out.println("************************************");
				break;
				
			case 3:
				System.out.print("Please enter Student ID to delete: ");
				String sId = scan.next();
				studentService.deleteStudent(Integer.parseInt(sId));
				System.out.println("************************************");
				System.out.print("Do you want to continue?(y/n)");
				repeat = scan.next().charAt(0);
				System.out.println("************************************");
				break;
				
			case 4:
				System.out.println("Enter the Student ID to update contact:");
				int sId1 = scan.nextInt();
				sObj = studentService.getStudentById(sId1);
				if(sObj!=null) {
					System.out.println("Enter the new contact number");
					String newContact = scan.next();
					StudentPojo updatedStudent = new StudentPojo(sObj.getStudentId(), sObj.getStudentName(), sObj.getStudentScore(), newContact);
					StudentPojo s = studentService.updateStudent(updatedStudent);
					System.out.println("Updated contact: " + s.getContact() + " for student id of "+ s.getStudentId()+ ".");					
				}else {
					System.out.println("student doesn't exit with id: "+ sId1 + ".");
				}
				
				sObj = null;
				System.out.println("************************************");
				System.out.print("Do you want to continue?(y/n)");
				repeat = scan.next().charAt(0);
				System.out.println("************************************");
				break;
			
			case 5:
				System.out.println("Enter the Student ID to update name:");
				int sId2 = scan.nextInt();
				sObj = studentService.getStudentById(sId2);
				if(sObj!=null) {
					System.out.println("Enter the new student name: ");
					String newName = scan.next();
					StudentPojo updatedStudent = new StudentPojo(sObj.getStudentId(), newName, sObj.getStudentScore(), sObj.getContact());
					StudentPojo s = studentService.updateStudent(updatedStudent);
					if(s!=null) {
						System.out.println("Updated name: " + s.getStudentName() + " for student id of "+ s.getStudentId()+ ".");					
						} else {
							System.out.println("Update failed! ");
						}
				}else {
					System.out.println("student doesn't exit with id: "+ sId2 + ".");
				}
				
				sObj = null;
				System.out.println("************************************");
				System.out.print("Do you want to continue?(y/n)");
				repeat = scan.next().charAt(0);
				System.out.println("************************************");
				break;
			
			case 6:
				System.exit(0);	
			}
		}while(repeat == 'y');
		scan.close();
	}
	
}
