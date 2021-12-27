package com.bytesedge.demo.service;

import java.util.List;

import com.bytesedge.demo.model.PatientTicketDetails;
import com.bytesedge.demo.model.TicketComments;

public interface TicketService {

	public void saveTicket(PatientTicketDetails patientTicketDetails);
	public List<PatientTicketDetails> getAllUserTickets(Long userId);
	public List<PatientTicketDetails> getAllDoctorTickets(Long userId);
	public List<TicketComments> getAllComments(Long id,Long userid);
	public void saveComment(TicketComments ticketcomment);
	public List<PatientTicketDetails>getdocpatientTickets(Long reviewerId,Long patientId);
}
