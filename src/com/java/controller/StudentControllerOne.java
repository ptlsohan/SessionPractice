package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.Student;
import com.java.exception.DatabaseException;
import com.java.service.StudentService;
import com.java.util.DateConverter;

@Controller
@SessionAttributes("student")
public class StudentControllerOne {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping("/add")
	protected ModelAndView addStudent(HttpServletRequest request) {
		Student st = new Student();
		ModelAndView mv = new ModelAndView("addStudent");
		// If a field with this name does not exist on view page: null
		// If a user does not enter a value for it, it will come to be empty
		String name = request.getParameter("staticEmail2");
		String password = request.getParameter("inputPassword2");
		if (name != null && name.trim().length() != 0 && password != null && password.trim().length() != 0) {
			mv.setViewName("displayStudent");
			st.setName(name);
			st.setPassword(password);
			mv.addObject("student", st);
		} else {
			mv.addObject("errorMsg", "Name and password cannot be empty");
			mv.setViewName("addStudent");
			return mv;
		}

		return mv;
	}

	// Data binding: values are coming from form: it to automatically set in the
	// model
	// @RequestParam
	@RequestMapping("/add1")
	protected ModelAndView add1Student(@RequestParam("name") String name,
			@RequestParam("password") String password) {
		Student st = new Student();
		ModelAndView mv = new ModelAndView("addStudent");
		/*
		 * We don't have to manually do this binding String
		 * name=request.getParameter("staticEmail2"); String
		 * password=request.getParameter("inputPassword2");
		 */
		if (name != null && name.trim().length() != 0 && password != null && password.trim().length() != 0) {
			mv.setViewName("displayStudent");
			st.setName(name);
			st.setPassword(password);
			mv.addObject("student", st);
		} else {
			mv.addObject("errorMsg", "Name and password cannot be empty");
			mv.setViewName("addStudent");
			return mv;
		}

		return mv;
	}

	// Data binding: values are coming from form: it to automatically set in the
	// model
	// @ModelAttribute: to directly map form fields to your bean
	@RequestMapping(path="/addStudent", method=RequestMethod.POST)
	protected ModelAndView add1Student(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		List<Student> list = new ArrayList<>();
		if (result.hasErrors()) {
			System.out.println(" validation error!"+ result.getAllErrors());
			mv.addObject("errorMsg", "Error setting the values from the form:\n"
					+ result.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining("\n")));
			mv.setViewName("addStudent");
			return mv;
		}
		System.out.println("No validation error!");
		try {
			service.addStudent(student);
			list=service.getStudents();
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		mv.addObject("list",list);
		mv.setViewName("displayStudent");
		return mv;
	}
	
	
	
	@InitBinder
	public  void init(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, "doj", new DateConverter());
		//binder.
	}
	
	@ModelAttribute("student")
	public Student init() {
		return new Student();
	}
	@RequestMapping(path="/add2")
	protected String add1Student() {
		return "addStudent";
	}
	
	@RequestMapping("/deleteStudent")
	protected ModelAndView deleteStudent(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		List<Student> list = new ArrayList<>();

		
		try {
			service.deleteStudent(id);
			list=service.getStudents();
			
		} catch (DatabaseException e) {
			
			System.out.println(e.getMessage());
		}
		mv.addObject("list",list);
		mv.setViewName("displayStudent");
		return mv;
	}
	@RequestMapping("/updateStudent")
	protected ModelAndView updateStudent(@RequestParam("student") Student student) {
		ModelAndView mv = new ModelAndView();
		List<Student> list = new ArrayList<>();
		
		
		try {
			service.updateStudent(student);
			list=service.getStudents();
			
		} catch (DatabaseException e) {
			
			System.out.println(e.getMessage());
		}
		mv.addObject("list",list);
		mv.setViewName("displayStudent");
		return mv;
	}
}

