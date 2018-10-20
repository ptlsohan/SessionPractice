package com.java.service;

import java.util.List;

import com.java.dto.Student;
import com.java.exception.DatabaseException;

//non-business related code
public interface StudentService {
		public void addStudent(Student student) throws DatabaseException;
		
		public void updateStudent(Student student) throws DatabaseException;
		
		public void deleteStudent(int id) throws DatabaseException;
		
		public Student getStudentById(int id) throws DatabaseException;
		
		public List<Student> getStudents() throws DatabaseException;
}
