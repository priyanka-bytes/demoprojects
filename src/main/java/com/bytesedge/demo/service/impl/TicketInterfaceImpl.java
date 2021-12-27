package com.bytesedge.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytesedge.demo.dao.TicketDao;
import com.bytesedge.demo.model.LanguagesKnown;
import com.bytesedge.demo.model.PatientTicketDetails;
import com.bytesedge.demo.model.TicketComments;
import com.bytesedge.demo.model.User;
import com.bytesedge.demo.service.TicketService;

@Service
public class TicketInterfaceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;
	@Override
	public void saveTicket(PatientTicketDetails patientTicketDetails) {
		
		patientTicketDetails.setCreatedDate(new Date());
		//patientTicketDetails.setPatientId((long) 1);
		patientTicketDetails.setReviewerId((long) 191);
		patientTicketDetails.setCreatedUserId((long) 3);
		ticketDao.saveTicket(patientTicketDetails);
	}
	
	
	@Override
	public void saveComment(TicketComments ticketcomment) {
		
		ticketDao.saveComment(ticketcomment);
	}
	@Override
	public List<PatientTicketDetails> getAllUserTickets(Long userId) {
		
		return ticketDao.getAllUserTickets(userId);
	}
	
	@Override
	public List<TicketComments> getAllComments(Long id, Long userid) {
		
		return ticketDao.getAllComments(id,userid);
	}
	
	@Override
	public List<PatientTicketDetails>getdocpatientTickets(Long reviewerId,Long patientId){
		return ticketDao.getdocpatientTickets(reviewerId,patientId);
	}


	@Override
	public List<PatientTicketDetails> getAllDoctorTickets(Long userId) {
		// TODO Auto-generated method stub
		return ticketDao.getAllDoctorTickets(userId);
	}
}
