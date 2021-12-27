package com.bytesedge.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bytesedge.demo.model.City;
import com.bytesedge.demo.model.LanguagesKnown;
import com.bytesedge.demo.model.Lookup;
import com.bytesedge.demo.model.State;
import com.bytesedge.demo.model.User;
import com.bytesedge.demo.service.CityService;
import com.bytesedge.demo.service.LookupService;
import com.bytesedge.demo.service.StateService;
import com.bytesedge.demo.service.UserService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private LookupService lookupService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	String register(ModelMap model) {
		List<Lookup> genderLookups =  lookupService.getLookupsByCode("GENDER");
		List<Lookup> languagesLookups =  lookupService.getLookupsByCode("LANGUAGES");
		List<Lookup> diseasesLookups =  lookupService.getLookupsByCode("DISEASES");
		
		model.addAttribute("genders", genderLookups);
		model.addAttribute("languages", languagesLookups);
		model.addAttribute("diseases", diseasesLookups);
		model.addAttribute("registerUser", new User());
		
		return "register";
	}
	
	

	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	String saveUser(@ModelAttribute("registerUser") User user) {
		userService.saveUser(user);
		
		//return "userDashboard";
		return "redirect:/user/userlist";
	}
	
//	@RequestMapping(value="/edit/save" , method = RequestMethod.POST )
//    public ModelAndView editUser(@PathVariable(value="id") Long id) {
//        ModelAndView mav = new ModelAndView("userBasicInfo");
//        User user = userService.get(id);
//
//        mav.addObject("user", user);
//       return mav;
//    }
	
//	@RequestMapping(value="/basicInfo")
//	String basicDetails(@RequestParam(value="userId") Long uid,  ModelMap model) {
//		List<Lookup> genderLookups =  lookupService.getLookupsByCode("GENDER");
//		List<Lookup> languagesLookups =  lookupService.getLookupsByCode("LANGUAGES");
//		List<Lookup> diseasesLookups =  lookupService.getLookupsByCode("DISEASES");
//		List<State> states = stateService.getAllStates();
//		List<City> cities = cityService.getAllCities();
//		
//		model.addAttribute("genders", genderLookups);
//		model.addAttribute("languages", languagesLookups);
//		model.addAttribute("diseases", diseasesLookups);
//		model.addAttribute("states", states);
//		model.addAttribute("cities", cities);
//		User user = userService.findById(uid);
//		model.addAttribute("user", user);
//		return "userBasicInfo";
//	
//}
//	
}

