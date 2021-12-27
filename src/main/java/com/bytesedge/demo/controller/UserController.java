package com.bytesedge.demo.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bytesedge.demo.model.UserCounsellorMap;

import com.bytesedge.demo.model.City;
import com.bytesedge.demo.model.IllnessDetails;
import com.bytesedge.demo.model.LanguagesKnown;
import com.bytesedge.demo.model.Lookup;
import com.bytesedge.demo.model.LookupsEnum;
import com.bytesedge.demo.model.PatientTicketDetails;
import com.bytesedge.demo.model.State;
import com.bytesedge.demo.model.TicketComments;
import com.bytesedge.demo.model.User;
import com.bytesedge.demo.model.TicketDetails;
import com.bytesedge.demo.service.CityService;
import com.bytesedge.demo.service.LookupService;
import com.bytesedge.demo.service.StateService;
import com.bytesedge.demo.service.TicketService;
import com.bytesedge.demo.service.UserService;

@Controller
@RequestMapping("/user")

@SessionAttributes({ "uid", "counsellorId" })
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CityService cityService;

	@Autowired
	private StateService stateService;

	@Autowired
	private LookupService lookupService;

	@Autowired
	private TicketService ticketService;

	@RequestMapping("/userlist")
	public String listUsers(Model theModel) {
		System.out.println("i am in users list");
		List<User> theCustomers = userService.getallusers();

		for (User custlist : theCustomers) {

			System.out.println(custlist);
		}
		theModel.addAttribute("userlist", theCustomers);
		return "list-users";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	String dashboard(@RequestParam(value = "action") String action, RedirectAttributes redirectAttributes) {
		/*
		 * List<User> userList = userService.list();
		 * 
		 * System.out.println(userList.size()); System.out.println(userList);
		 * 
		 * System.out.println(action);
		 */
		// String act = (String) (action.isPresent() ? action : "basic");

		String redirectView = "basicInfo?action=basic";

		switch (action) {
		case "illness":
			redirectView = "patient/illnessDetails?action=illness";
			break;
		case "family":
			redirectView = "user/familyDetails?action=family";
			break;
		case "other":
			redirectView = "user/otherDetails?action=other";
			break;
		case "ticket":
			redirectView = "user/ticketDetails?action=ticket";
			break;

		default:
			redirectView = "user/basicInfo?action=basic";
		}

		return "redirect:/" + redirectView;
	}

	@RequestMapping(value = "/familyDetails", method = RequestMethod.GET)
	String familyDetails() {
		System.out.println("Family");
		return "userFamilyDetails";
	}

	@RequestMapping(value = "/otherDetails", method = RequestMethod.GET)
	String otherDetails() {
		System.out.println("Other");
		return "userOtherDetails";
	}

	@RequestMapping(value = "/basicInfo", method = RequestMethod.GET)
	String basicDetails(@RequestParam(value = "userId") String userId, ModelMap model) {

		System.out.println("Basic");
		System.out.println(userId);
		Long uid = Long.parseLong(userId);
		model.put("uid", uid);

		User user = userService.findById(Long.parseLong(userId));

		System.out.println(user);

		Set<String> langList = new HashSet<String>();

		for (LanguagesKnown lk : user.getLanguagesKnown()) {
			String lkId = lk.getLanguageType().getId().toString();
			langList.add(lkId);
		}

		user.setLanguagesList(langList);

		List<Lookup> genderLookups = lookupService.getLookupsByCode("GENDER");
		List<Lookup> languagesLookups = lookupService.getLookupsByCode("LANGUAGES");
		List<Lookup> diseasesLookups = lookupService.getLookupsByCode("DISEASES");
		List<State> states = stateService.getAllStates();
		List<City> cities = cityService.getAllCities();

		model.addAttribute("genders", genderLookups);
		model.addAttribute("languages", languagesLookups);
		model.addAttribute("diseases", diseasesLookups);
		model.addAttribute("states", states);
		model.addAttribute("cities", cities);

		model.addAttribute("user", user);
		return "userBasicInfo";
	}

//	@RequestMapping("/update")
//	public ModelAndView userBasicInfo(@RequestParam long id) {
//		ModelAndView mav = new ModelAndView("userBasicInfo");
//		LinkedHashMap<String, Object> service = null;
//		User user = (User) service.get(id);
//		mav.addObject("user", user);
//		return mav;
//		
//	}

	@RequestMapping(value = "/update")
	String updateDetails(@RequestParam(value = "userId") long userId, ModelMap model) {

		System.out.println(userId);
		model.addAttribute("userId", userId);

		// User user = userService.findById(uid);
		// User user =userService.updateUser(userId);
		// model.addAttribute("user", user);
		return "list-users";
	}

	@RequestMapping(value = "/ticketDetails", method = RequestMethod.GET)
	ModelAndView ticket(ModelMap model, HttpSession session) {

		User user = userService.findById((long) 1);
		String uid = session.getAttribute("uid").toString();
		Long userid = Long.parseLong(uid);

		Long userrole = userService.findrole(userid);

		// Long user_role = (long) 3;
		List<PatientTicketDetails> allTickets = null;
		List<PatientTicketDetails> user_tickets = new ArrayList<>();
		List<User> usernamelist = new ArrayList<>();
		// List<PatientTicketDetails> counsellor_tickets =new ArrayList<>();
		if (userrole == 3) {
			allTickets = ticketService.getAllUserTickets(userid);
			if (allTickets != null) {
				Map<Date, Date> allDates = new HashMap<>();
				for (PatientTicketDetails patientTicketDetails : allTickets) {
					if (patientTicketDetails.getCreatedUserId() == user.getId())
						user_tickets.add(patientTicketDetails);
					allDates.put(patientTicketDetails.getCreatedDate(), patientTicketDetails.getCreatedDate());
				}
				Map<String, Object> model1 = new HashMap<String, Object>();
				model1.put("tickets", user_tickets);
				model1.put("dates", allDates);

				return new ModelAndView("tickets-list", "model", model1);
			} else {
				return new ModelAndView("tickets-list");
			}
		} else if (userrole == 4) {

			//allTickets = ticketService.getAllDoctorTickets(userid);
			model.put("counsellorId", userid);
			System.out.println("i am in jr counsellortab");
			List<UserCounsellorMap> userList = userService.findByCounsellorId(userid);

			Map<Date, Date> allDates1 = new HashMap<>();
//			for (PatientTicketDetails patientTicketDetails : allTickets) {
//				allDates.put(patientTicketDetails.getCreatedDate(), patientTicketDetails.getCreatedDate());
//			}
			if (userList != null) {
				Map<String, Object> model2 = new HashMap<String, Object>();

				// to get users name
				for (UserCounsellorMap userlist : userList) {
					User username = userService.findById(userlist.getUserId());
					allTickets = ticketService.getAllUserTickets(userlist.getUserId());
					usernamelist.add(username);
					for (PatientTicketDetails ptDetails : allTickets) {
					allDates1.put(ptDetails.getCreatedDate(), ptDetails.getCreatedDate());
					}
					// add ticket dates here
				}
				model2.put("userList", userList);
				model2.put("usernamelist", usernamelist);
				model2.put("dates", allDates1);
				return new ModelAndView("doctorTickets", "model", model2);
				// find their comments and map

			} else {
				// show message: No users assigned today
				System.out.println("No users existed for doctor");
			}

		}
		return null;
	}

	@RequestMapping(value = "/ticketinfo")
	String ticketinfo(ModelMap model) {

		// User user = userService.findById(Long.parseLong(userId));
		return "ticketinfo";
	}

	@RequestMapping(value = "/newTicket")
	String newticket(@RequestParam(value = "userId") String userId, ModelMap model) {
		// model.addAttribute("ticketDetails", new ticketDetails());
		return "tickets-list";
	}

}







<c:if test="${listValue.created } = ${date.value}">
							</c:if>>
