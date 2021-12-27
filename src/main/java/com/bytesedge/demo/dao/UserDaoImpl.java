package com.bytesedge.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.bytesedge.demo.model.Lookup;
import com.bytesedge.demo.model.User;
import com.bytesedge.demo.model.UserCounsellorMap;
import com.bytesedge.demo.model.UserRoles;


@Repository
@Transactional
@EnableTransactionManagement
public class UserDaoImpl extends AbstractDao implements UserDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//@PersistenceUnit(unitName = "readwrite.config")
	//private EntityManagerFactory entityManagerFactory;


	// SessionFactory gives us a factory of sessions
	  // Usually SessionFactory is been configured by the 
	  // configuration file named as hibernate.cfg.xml
	  // buildSessionFactory() builds the sessionFactory for us
	  //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	  
	// Session is created by calling openSession()
	  // method on SessionFactory object
	  //Session session = sessionFactory.openSession();
	
	//SessionFactory sessionFactory;
	
	//Use below code on create/update
	//EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = manager.createQuery("Select u from User u", User.class).getResultList();
		
		return users;
	}

	@Override
	public void saveUser(User user) {
		Session session = getSession();
		System.out.println("Session---");
		System.out.println(session);
		System.out.println(user.getId());
		session.saveOrUpdate(user);
		//session.persist(user);
	}

	@Override
	public User findById(Long id) {
		List<User> user =  manager.createQuery("Select u from User u where u.id=:userId", User.class)
						.setParameter("userId", id).getResultList();
		
		return user.size() > 0 ? user.get(0) : null;
		
		
	}
	
	@Override
	public Optional<User> findId(Long id) {
		List<User> user =  manager.createQuery("Select u from User u where u.id=:userId", User.class)
						.setParameter("userId", id).getResultList();
		
		return Optional.of(user.size() > 0 ? user.get(0) : null);
		
		
	}
	
	@Override
	public Long findrole(Long id) {
		UserRoles userrole = manager.createQuery("Select u from UserRoles u where u.userid=:userId",UserRoles.class).setParameter("userId",id).getSingleResult();
		Long userroleid = userrole.getRoleid();
		return userroleid;
	}
	
	@Override
	public List<UserCounsellorMap>findByCounsellorId(Long userId){
		/*List<UserCounsellorMap> userList = null;
		try {
			userList = (List<UserCounsellorMap>) hibernateTemplate.find("from UserCounsellorMap l where l.userid = ?0 ", new Object[] { userId });
		} catch (Exception e) {
			System.out.println(e);
		}*/
		System.out.println(userId);
		List<UserCounsellorMap> userList =  manager.createQuery("Select u from UserCounsellorMap u where u.counsellorId=:userId",UserCounsellorMap.class).setParameter("userId",userId).getResultList();
	return userList;
	}
//	@Override
//	public User updateUser(Long id) {
//		Session session = getSession();
//		 
//		User user;
//		//Transaction tx=session.beginTransaction();  
//		user=(User)session.createQuery("update User u set where u.id=id");
//		//user = session.get(User.class, id);
//		//session.update(user);
//		return user;
//	}

}
