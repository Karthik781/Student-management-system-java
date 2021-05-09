package studentmain;

import java.util.List;
import java.util.Scanner;

import pojo.StudentDao;
import pojo.StudentPojo;

public class StudentDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentDao studentDao = new StudentDao();
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
				List<StudentPojo> myStudents = studentDao.getStudents();
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
				StudentPojo addedStudent = studentDao.addStudent(studentPojo);
				System.out.println("Student added Successfully!!");
				System.out.println("New student id is : " + addedStudent.getStudentId());
				System.out.println("************************************");
				System.out.print("Do you want to continue?(y/n)");
				repeat = scan.next().charAt(0);
				System.out.println("************************************");
				break;
				
			case 3:
				System.out.print("Please enter Student ID to delete: ");
				String sId = scan.next();
				studentDao.deleteStudent(Integer.parseInt(sId));
				System.out.println("************************************");
				System.out.print("Do you want to continue?(y/n)");
				repeat = scan.next().charAt(0);
				System.out.println("************************************");
				break;
				
			case 4:
				System.out.println("Enter the Student ID to update contact:");
				int sId1 = scan.nextInt();
				sObj = studentDao.getObjectById(sId1);
				if(sObj!=null) {
					System.out.println("Enter the new contact number");
					String newContact = scan.next();
					StudentPojo updatedStudent = new StudentPojo(sObj.getStudentId(), sObj.getStudentName(), sObj.getStudentScore(), newContact);
					StudentPojo s = studentDao.updateStudent(updatedStudent);
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
				sObj = studentDao.getObjectById(sId2);
				if(sObj!=null) {
					System.out.println("Enter the new student name: ");
					String newName = scan.next();
					StudentPojo updatedStudent = new StudentPojo(sObj.getStudentId(), newName, sObj.getStudentScore(), sObj.getContact());
					StudentPojo s = studentDao.updateStudent(updatedStudent);
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
