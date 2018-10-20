package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.Student;
import com.java.exception.DatabaseException;
import com.java.service.StudentService;

@Controller
public class StudentController  {

	
	private StudentService service;
	
	public StudentController(StudentService service){
		this.service=service;
	}
	
//	@RequestMapping(path= {"/addStudent","/updateStudent"})
//	public ModelAndView doWork(HttpServletRequest request, HttpServletResponse response) {
//		String servletPath = request.getServletPath();
//		ModelAndView mv = new ModelAndView();
//		if (servletPath.contains("addStudent")) {
//			Student st= new Student();
//			st.setName(request.getParameter("staticEmail2"));
//			st.setPassword(request.getParameter("inputPassword2"));
//			try {
//				service.addStudent(st);
//			
//			mv.setViewName("displayStudent");
//			request.setAttribute("message", "Student added to db!");
//			request.setAttribute("student", st);
//			} catch (DatabaseException e) {
//				mv.setViewName("error");
//				request.setAttribute("message", e.getMessage());
//			}
//		} else if (servletPath.contains("updateStudent")) {
//			mv.setViewName("displayStudent");
//			request.setAttribute("message", "Student updated in db!");
//		}
//		return mv;
//	}

}
