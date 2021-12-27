package com.bytesedge.demo.dao;

import java.util.List;
import java.util.Optional;

import com.bytesedge.demo.model.User;
import com.bytesedge.demo.model.UserCounsellorMap;

public interface UserDao {

	public List<User> getAllUsers();
	
	public void saveUser(User user);
	
	public User findById(Long id);
	
	public Optional<User> findId(Long id);
	//public User updateUser(Long id);
	public Long findrole(Long id);
	
	public List<UserCounsellorMap>findByCounsellorId(Long userId);
}
