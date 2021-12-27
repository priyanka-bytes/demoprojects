package com.bytesedge.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bytesedge.demo.model.LoginCommand;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	String login(@ModelAttribute("loginForm") LoginCommand loginCommand, HttpSession session) {
		session.setAttribute("username", loginCommand.getUsername());
		
		return "userDashboard";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "index";
	}
}
