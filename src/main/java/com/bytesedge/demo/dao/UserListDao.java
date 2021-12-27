package com.bytesedge.demo.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bytesedge.demo.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
//import com.bytesedge.model.Customer;
//import com.bytesedge.util.HibernateUtil;
@Repository
@Transactional
@EnableTransactionManagement
public class UserListDao {
	@PersistenceContext
	private EntityManager manager;
	
	
	public List<User> getAllUsers() {
		List<User> users = manager.createQuery("Select u from User u").getResultList();
		for(User resultlist: users) {
			
			System.out.println(resultlist);
		}
		//List<User> users = manager.createQuery(" from User").getResultList();
		
		return users;
	}

		
	
	
	

}
