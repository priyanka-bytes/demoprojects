package com.bytesedge.demo.dao;

import java.util.List;

import com.bytesedge.demo.model.PatientTicketDetails;
import com.bytesedge.demo.model.TicketComments;

public interface TicketDao {

	public void saveTicket(PatientTicketDetails patientTicketDetails);
	public List<PatientTicketDetails> getAllUserTickets(Long userId);
	public List<PatientTicketDetails> getAllDoctorTickets(Long userId);
	public List<TicketComments> getAllComments(Long id,Long userid);
	public void saveComment(TicketComments ticketcomment);
	public List<PatientTicketDetails> getdocpatientTickets(Long counsellorId, Long patientId);
}
