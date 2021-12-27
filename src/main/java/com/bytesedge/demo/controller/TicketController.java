package com.bytesedge.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bytesedge.demo.model.PatientTicketDetails;
import com.bytesedge.demo.model.TicketComments;
import com.bytesedge.demo.model.User;
import com.bytesedge.demo.model.UserCounsellorMap;
import com.bytesedge.demo.service.TicketService;
import com.bytesedge.demo.service.UserService;

@Controller
@RequestMapping("/ticket")
@SessionAttributes({"ticketId","uid","counsellorId","patientId","doctorName","patientName","tktpatientName","tktdoctorName"})

public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String raiseTicket(Model theModel, HttpSession session) {

		return "newTicket";

	}

	@RequestMapping(value = "/saveTicket", method = RequestMethod.POST)
	public ModelAndView saveTicket(@ModelAttribute("ticketInfoForm") PatientTicketDetails patientTicketDetails,
			HttpSession session) {
		ticketService.saveTicket(patientTicketDetails);
		System.out.println("Save Ticket");
		String uid =session.getAttribute("uid").toString();
		Long userid = Long.parseLong(uid);
		List<PatientTicketDetails> allTickets = ticketService.getAllUserTickets(userid);	
		Map<Date,Date> allDates = new HashMap<>();
		for (PatientTicketDetails patientTicketDetails2 : allTickets) {
			allDates.put(patientTicketDetails2.getCreatedDate(),patientTicketDetails2.getCreatedDate());
		}
		System.out.println("----" + allDates);
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("tickets", allTickets);
        model.put("dates", allDates);

        return new ModelAndView("tickets-list", "model", model);
	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String newTicket(Model theModel) {

		return "tickets-list";

	}

	@RequestMapping(value = "/doctorTicket", method = RequestMethod.GET)
	public String doctorTicket(Model theModel) {

		return "doctorTickets";

	}

//	@RequestMapping(value = "/ticketinfo", method = RequestMethod.GET)
//	public String ticketinfo(Model theModel) {
//		System.out.println("i am in ticket");
//		return "ticketinfo";
//
//	}
	
	//Ticket Comments for both doctor and patient
	@RequestMapping(value = "/ticketcomments", method = RequestMethod.GET)
	public String ticketcomments(@RequestParam("ticketId") String ticketId,Model theModel,ModelMap model,HttpSession session) {
		//HttpSession session;
		System.out.println("i am in ticket");
		System.out.println(ticketId);
		Long tktId = Long.parseLong(ticketId);
		String uid =session.getAttribute("uid").toString();
		Long userid = Long.parseLong(uid);
		User user2 = userService.findById(userid);
		model.put("tktpatientName", user2.getFirstName());
		
		//doctor id static
		String doctorId ="191";
		Long docid = Long.parseLong(doctorId);
		User user1 = userService.findById(docid);
		model.put("tktdoctorName", user1.getFirstName());
		//Future Logic
		//List<UserCounsellorMap> docList = userService.findByCounsellorId(userid);
		
		
		
		model.put("ticketId", tktId);
		List<TicketComments> ticketcomments = ticketService.getAllComments(Long.parseLong(ticketId),userid);
		List<TicketComments> docticketcomments = ticketService.getAllComments(Long.parseLong(ticketId),docid);
		theModel.addAttribute("ticketcomments", ticketcomments);
		theModel.addAttribute("docticketcomments", docticketcomments);
		System.out.println(ticketcomments);
		return "ticketcomments";

	}
	
	@RequestMapping(value = "/doctorComments", method = RequestMethod.GET)
	public String doctorComments(@RequestParam("ticketId") String ticketId,Model theModel,ModelMap model,HttpSession session) {
		//HttpSession session;
		System.out.println("i am in ticket");
		System.out.println(ticketId);
		Long tktId = Long.parseLong(ticketId);
		String counsellorId =session.getAttribute("counsellorId").toString();
		Long conId = Long.parseLong(counsellorId);
		User user1 = userService.findById(conId);
		model.put("doctorName", user1.getFirstName());
		String ptid =session.getAttribute("patientId").toString();
		Long patientid = Long.parseLong(ptid);
		User user2 = userService.findById(patientid);
		model.put("patientName", user2.getFirstName());
		model.put("ticketId", tktId);
		//List<TicketComments> patient_doccomments = new ArrayList<>();
		List<TicketComments> docticketcomments = ticketService.getAllComments(Long.parseLong(ticketId),conId);
		List<TicketComments> patientticketcomments = ticketService.getAllComments(Long.parseLong(ticketId),patientid);
		for (TicketComments tktcomment: docticketcomments) {
	       System.out.println(counsellorId + ptid + tktId);
	       System.out.println(tktcomment.getContent());
	       System.out.println(tktcomment.getCreatedDate());
		}
		for (TicketComments tktcomment: patientticketcomments) {
		       System.out.println(counsellorId + ptid + tktId);
		       System.out.println(tktcomment.getContent());
		       System.out.println(tktcomment.getCreatedDate());
			}
		theModel.addAttribute("docticketcomments", docticketcomments);
		theModel.addAttribute("patientticketcomments", patientticketcomments);
		//System.out.println(ticketcomments);
		return "doctorComments";

	}
	
	@RequestMapping(value = "/addcomment", method = RequestMethod.GET)
	public String addticketcomments() {
		
		
		return "addcomment";

	}
	@RequestMapping(value = "/saveComments", method = RequestMethod.POST)
	public String saveticketcomments(@ModelAttribute("ticketcomments") TicketComments ticketcomment) {
		System.out.println(ticketcomment.getContent());
		ticketService.saveComment(ticketcomment);
		return "redirect:/ticket/ticketcomments";

	}
	
	@RequestMapping(value = "/doctorAddcomment", method = RequestMethod.GET)
	public String docaddticketcomments() {
		
		
		return "doctorAddcomment";

	}
	
	@RequestMapping(value = "/docsaveComments", method = RequestMethod.POST)
	public String docsaveticketcomments(@ModelAttribute("ticketcomments") TicketComments ticketcomment) {
		System.out.println(ticketcomment.getContent());
		ticketService.saveComment(ticketcomment);
		return "redirect:/ticket/doctorComments";

	}
	
	@RequestMapping(value = "/byDate", method = RequestMethod.GET)
	public ModelAndView ticketinfo(@RequestParam("date") String date, HttpSession session) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String uid =session.getAttribute("uid").toString();
		Long userid = Long.parseLong(uid);
		List<PatientTicketDetails> allTickets =  ticketService.getAllUserTickets(userid);
		List<PatientTicketDetails> singleDateTickets =  new ArrayList<>();
		for (PatientTicketDetails patientTicketDetails : allTickets) {
			if (date.equalsIgnoreCase(format.format(patientTicketDetails.getCreatedDate()))) {
				singleDateTickets.add(patientTicketDetails);
			}
		}	
		Map<Date,Date> allDates = new HashMap<>();
		for (PatientTicketDetails patientTicketDetails2 : allTickets) {
			allDates.put(patientTicketDetails2.getCreatedDate(),patientTicketDetails2.getCreatedDate());
		}
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("tickets", singleDateTickets);
        model.put("dates", allDates);

        return new ModelAndView("tickets-list", "model", model);
	}
	@RequestMapping(value = "/patientId", method = RequestMethod.GET)
	public ModelAndView doctorPatientticketdetails(@RequestParam("patientId") String patientId,ModelMap model, HttpSession session) throws ParseException {
		Long ptid = Long.parseLong(patientId);
		model.put("patientId",ptid);
		String reviewerId =session.getAttribute("counsellorId").toString();
		Long rId = Long.parseLong(reviewerId);
		List<PatientTicketDetails> doctpatienttktdetails =  ticketService.getdocpatientTickets(rId,ptid);
		Map<String, Object> model1 = new HashMap<String, Object>();
		model1.put("doctpatienttktdetails",doctpatienttktdetails);
		return new ModelAndView("doctorTickets","model",model1);
	}

}
