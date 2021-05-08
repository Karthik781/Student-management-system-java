package studentmain;

import java.util.List;
import java.util.Scanner;

import pojo.StudentDao;
import pojo.StudentPojo;

public class StudentDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentDao studentDao = new StudentDao();
		
char repeat = 'n';
		
		do {
			System.out.println("************************************");
			System.out.println("Student Management System");
			System.out.println("************************************");
			System.out.println("1. Display all students.");
			System.out.println("2. Add a new Student.");
			System.out.println("3. Remove a Student.");
			System.out.println("4. Update Contact Number.");
			System.out.println("5. Exit.");
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
			case 5:
				System.exit(0);	
			}
		}while(repeat == 'y');
		scan.close();
	}
	
}
