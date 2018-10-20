package com.java.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
	
	private int id;
	@NotEmpty
	@Size(min=3, max=50, message="Name should be between 3 and 50 characters")
	private String name;
	@Pattern(regexp="[a-zA-Z]+[0-9]+", message="Password should have atleast 1 numeric and 1 special character")
	@Size(min=7, max=20, message="Length of password should be between 7 and 20")
	private String password;
	
	
	private LocalDate doj;  /*15/07*/
	private Boolean status;
	private List<String> subjects;
	private Gender gender;
	public Student() {
		
	}
	
	public Student(int id,
			@NotEmpty @Size(min = 3, max = 50, message = "Name should be between 3 and 50 characters") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
enum Gender{
	MALE, FEMALE
}
