package com.sms.dao;

import java.util.List;

import com.sms.pojo.StudentPojo;

public interface StudentDao {

	public List<StudentPojo> getStudents();

	public StudentPojo addStudent(StudentPojo student);

	public boolean deleteStudent(int studentId);

	public StudentPojo updateStudent(StudentPojo updatedStudent);

	public StudentPojo getStudentById(int studentId);

}
