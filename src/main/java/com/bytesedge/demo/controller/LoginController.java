package com.bytesedge.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bytesedge.demo.model.LoginCommand;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.POST)
	String login(@ModelAttribute("loginForm") LoginCommand loginCommand) {
		System.out.println(loginCommand.getUsername());
		System.out.println(loginCommand.getPassword());
		return "userDashboard";
	}
}
