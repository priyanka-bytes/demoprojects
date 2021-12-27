package com.bytesedge.demo.service;



import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytesedge.demo.dao.*;
import com.bytesedge.demo.model.LanguagesKnown;
import com.bytesedge.demo.model.Lookup;
import com.bytesedge.demo.model.User;
import com.bytesedge.demo.model.UserAddress;
import com.bytesedge.demo.model.UserCounsellorMap;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserListDao userlistDao;
	
	@Autowired
	private LookupService lookupService;
	
	@Override
	 @Transactional
	public List<User> getallusers(){
		return userlistDao.getAllUsers();
		
	}
	
	@Override
	public List<User> list() {
		
		return userDao.getAllUsers();
	}
	
	@Override
	public String hello() {
		return "Rajaram";
	}

	@Override
	public void saveUser(User user) {
		Set<LanguagesKnown> langSet = getUserLanguages(user);
		System.out.println(user);
		user.setLanguagesKnown(langSet);
		user.getDisease().setUser(user);
		
//		if(user.getAddressess() != null) {
//			for(UserAddress address: user.getAddressess()) {
//				address.setUser(user);
//			}
//		}
		user.setAddressess(null);
		userDao.saveUser(user);
	}
	public User get(long id) {
	Optional<User> result = Optional.of(userDao.findById(id));
	
	return result.get();
	
	}
	private Set<LanguagesKnown> getUserLanguages(User user) {
		Set<LanguagesKnown> langSet = new HashSet<>();
		
		/*String langStr = user.getLanguages();
		StringTokenizer st = new StringTokenizer(langStr, ",");
		
		while(st.hasMoreTokens()) {
			LanguagesKnown langKnown = new LanguagesKnown();
			
			Long langId = (Long)Long.parseLong(st.nextToken());
			Lookup lang = lookupService.findById(langId);
			
			langKnown.setUser(user);
			langKnown.setLanguageType(lang);
			
			langSet.add(langKnown); 
		}*/
		
		for(String lk:user.getLanguagesList()) {
			LanguagesKnown langKnown = new LanguagesKnown();
			
			Long langId = (Long)Long.parseLong(lk);
			Lookup lang = lookupService.findById(langId);
			
			langKnown.setUser(user);
			langKnown.setLanguageType(lang);
			
			langSet.add(langKnown); 
		}
		
		return langSet;
	}


	@Override
	public User findById(Long id) {
		return userDao.findById(id);
	}
	
	@Override
	public User get(Long id) {
		 Optional<User> result = userDao.findId(id);
	        return result.get();
	}
	
	@Override
	public Long findrole(Long id)
	{
		Long userrole = userDao.findrole(id);
		return userrole;
	}
	
	@Override
	public List<UserCounsellorMap> findByCounsellorId(Long userId)
	{
		List<UserCounsellorMap> userList = userDao.findByCounsellorId(userId);
		return userList;
	}
	
	//@Override
	//public User updateUser(long id) {
		
	//	return userDao.updateUser(id);
	//}
	
}
