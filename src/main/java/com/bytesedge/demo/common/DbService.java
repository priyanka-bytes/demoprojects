package com.bytesedge.demo.common;


import org.springframework.beans.factory.annotation.Autowired;

import com.bytesedge.demo.service.UserService;


public class DbService {
	private static DbService _instance = null;

	@Autowired
	private UserService userService = null;



	private DbService() {
	}

	public static DbService getInstance() {
		if (_instance == null) {
			synchronized (DbService.class) {
				if (_instance == null) {
					_instance = new DbService();
				}
			}
		}
		return _instance;
	}


	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
