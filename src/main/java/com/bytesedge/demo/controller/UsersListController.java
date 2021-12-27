package com.bytesedge.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.bytesedge.model.Customer;
import com.bytesedge.demo.model.User;
import com.bytesedge.demo.service.UserService;


@Controller
@RequestMapping("/userlist")

public class UsersListController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/userlist")
	 public String listUsers(Model theModel) {
		 
	        List <User> theCustomers = userService.getallusers();
	        theModel.addAttribute("userlist", theCustomers);
	        return "list-users";
	    }

}
