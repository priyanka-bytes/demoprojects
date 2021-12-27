package com.bytesedge.demo.service;

import java.util.List;

import com.bytesedge.demo.model.User;
import com.bytesedge.demo.model.UserCounsellorMap;

public interface UserService {
	
	public List<User> getallusers();
	public List<User> list();

	public String hello();
	
	public void saveUser(User user);
	
	public User findById(Long id);
	
	//public User updateUser(long id);
	
	public User get(Long id);
	
	public Long findrole(Long id);
	
	public List<UserCounsellorMap> findByCounsellorId(Long userId);
	
}
