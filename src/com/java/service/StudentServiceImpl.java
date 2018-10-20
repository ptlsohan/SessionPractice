package com.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.dto.Student;
import com.java.exception.DatabaseException;
import com.java.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository repository;
	
	public StudentServiceImpl(StudentRepository repository){
		this.repository= repository;
	}
	
	@Override
	public void addStudent(Student student) throws DatabaseException {
		
		int id=repository.addStudent(student);
		
	}

	@Override
	public void updateStudent(Student student) throws DatabaseException {
		// TODO Auto-generated method stub
		repository.updateStudent(student);

	}

	@Override
	public void deleteStudent(int id) throws DatabaseException {
		// TODO Auto-generated method stub
		repository.deleteStudent(id);

	}

	@Override
	public Student getStudentById(int id) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudents() throws DatabaseException {
		
		return repository.getStudents();
	}

}
