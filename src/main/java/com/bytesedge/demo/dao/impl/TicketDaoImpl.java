package com.bytesedge.demo.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.bytesedge.demo.dao.TicketDao;
import com.bytesedge.demo.model.City;
import com.bytesedge.demo.model.PatientTicketDetails;
import com.bytesedge.demo.model.TicketComments;
import com.bytesedge.demo.model.User;

@Repository
@Transactional
@EnableTransactionManagement
public class TicketDaoImpl implements TicketDao {

	@Autowired
	private SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager manager;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveTicket(PatientTicketDetails patientTicketDetails) {

		Session session = getSession();
		session.saveOrUpdate(patientTicketDetails);
	}

	@Override
	public void saveComment(TicketComments ticketcomment) {

		Session session = getSession();
		session.saveOrUpdate(ticketcomment);
	}
	@Override
	public List<PatientTicketDetails> getAllUserTickets(Long uId) {
		
		Session session = getSession();
		@SuppressWarnings("unchecked")
		List<PatientTicketDetails> patientTicketDetails = session.createQuery("Select u from PatientTicketDetails u where u.patientId=:userId", PatientTicketDetails.class).setParameter("userId", uId).getResultList();
		return patientTicketDetails;
	}
	
	@Override
	public List<TicketComments> getAllComments(Long id, Long userId) {
		
		Session session = getSession();
		@SuppressWarnings("unchecked")
		//List<TicketComments> ticketcomments = session.createQuery("FROM TicketComments").list();
		List<TicketComments> ticketcomments =  manager.createQuery("Select u from TicketComments u where u.ticketId=:ticketId AND u.userId =:uid ", TicketComments.class)
		.setParameter("ticketId", id)
		.setParameter("uid",userId).getResultList();

		//return ticketcomments.size() > 0 ? ticketcomments.get(0) : null;
		return ticketcomments;
	}
	@Override
	public List<PatientTicketDetails> getdocpatientTickets(Long counsellorId, Long patientId){
		Session session = getSession();
		@SuppressWarnings("unchecked")
		List<PatientTicketDetails> getdocpatientTkts =  manager.createQuery("Select u from PatientTicketDetails u where u.reviewerId=:reviewerId AND u.patientId =:patientId ", PatientTicketDetails.class)
		.setParameter("reviewerId",counsellorId )
		.setParameter("patientId", patientId).getResultList();
	return getdocpatientTkts;
	}

	@Override
	public List<PatientTicketDetails> getAllDoctorTickets(Long userId) {
		
		Session session = getSession();
		List<PatientTicketDetails> patientTicketDetails = session.createQuery("Select u from PatientTicketDetails u where u.reviewerId=:userId", PatientTicketDetails.class).setParameter("userId", userId).getResultList();
		return patientTicketDetails;
	}
}
