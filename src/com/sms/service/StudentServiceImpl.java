package com.sms.service;

import java.util.List;

import com.sms.dao.StudentDao;
import com.sms.dao.StudentDaoImpl;
import com.sms.exception.InvalidContactException;
import com.sms.pojo.StudentPojo;

public class StudentServiceImpl implements StudentService {
	
	StudentDao studentDao;
	 

	public StudentServiceImpl() {
		studentDao = new StudentDaoImpl();
	}

	@Override
	public List<StudentPojo> getStudents() {
		return studentDao.getStudents();
	}

	@Override
	public StudentPojo addStudent(StudentPojo student) {
		
		String regex = "(0/91)?[6-9][0-9]{9}";
		String no = student.getContact();
		boolean flag = false;
		System.out.println(no.matches(regex));
		if(no.matches(regex)) {
			flag = true;
		}else {
			flag = false;
		}
		
		if(student.getContact().length() == 10 && flag == true) {
			return studentDao.addStudent(student);		
		}else {
			throw new InvalidContactException();
		}
		
		
	}

	@Override
	public boolean deleteStudent(int studentId) {
		return studentDao.deleteStudent(studentId);
	}

	@Override
	public StudentPojo updateStudent(StudentPojo updatedStudent) {
		return studentDao.updateStudent(updatedStudent);
	}

	@Override
	public StudentPojo getStudentById(int studentId) {
		return studentDao.getStudentById(studentId);
	}

}
