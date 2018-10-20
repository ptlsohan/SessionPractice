package com.java.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.Pair;
import com.java.dto.User;


@Controller
@SessionAttributes({"user","map"})
public class SessionDemo {
	
	@ModelAttribute("user")
	public User init() {
		return new User();
	}
	
	
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	protected ModelAndView login( @ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView("display");
		mv.addObject("user",user);
		return mv;
	}
	
	@RequestMapping(path="/logout")
	protected ModelAndView logout( @ModelAttribute("user") User user,SessionStatus status) {
		ModelAndView mv = new ModelAndView("home");
		status.setComplete();
		return mv;
	}
	
	
	@RequestMapping(path="/addMap")
	protected ModelAndView addMap( @ModelAttribute("map") Map<String,String> map,@RequestParam("key") String key,
			@RequestParam("value") String value) {
		ModelAndView mv = new ModelAndView("display");
		map.put(key, value);
		mv.addObject("map",map);
		return mv;
	}
	@RequestMapping(path="/home")
	protected ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");

		return mv;
	}

}
