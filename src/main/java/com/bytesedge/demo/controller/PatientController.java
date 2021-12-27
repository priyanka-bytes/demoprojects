package com.bytesedge.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bytesedge.demo.model.IllnessDetails;
import com.bytesedge.demo.model.Lookup;
import com.bytesedge.demo.model.LookupsEnum;
import com.bytesedge.demo.service.LookupService;
import com.bytesedge.demo.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	LookupService lookupService;
	
	@Autowired
	PatientService patientService;
	
	@RequestMapping(value="/illnessDetails", method = RequestMethod.GET)
	String illnessDetails(ModelMap model) {
		
		List<Lookup> stressLookups 				=  lookupService.getLookupsByCode(LookupsEnum.STRESS_TYPE.toString());
		List<Lookup> treatmentLookups		 	=  lookupService.getLookupsByCode(LookupsEnum.TREATMENT_TYPE.toString());
		List<Lookup> spiritualPracticeLookups 	=  lookupService.getLookupsByCode(LookupsEnum.SPIRITUAL_PRACTICES.toString());
		List<Lookup> familiyClassLookups 		=  lookupService.getLookupsByCode(LookupsEnum.FAMILY_CLASS.toString());
		List<Lookup> familyTypeLookups 			=  lookupService.getLookupsByCode(LookupsEnum.FAMILY_TYPE.toString());
		List<Lookup> marriedStatusLookups 		=  lookupService.getLookupsByCode(LookupsEnum.MARRIED_STATUS.toString());
		List<Lookup> yesNoLookups 				=  lookupService.getLookupsByCode(LookupsEnum.YES_NO.toString());
		
		model.addAttribute("stressTypes", stressLookups);
		model.addAttribute("treatmentTypes", treatmentLookups);
		model.addAttribute("spiritualPracticeTypes", spiritualPracticeLookups);
		model.addAttribute("familyClassTypes", familiyClassLookups);
		model.addAttribute("familyTypes", familyTypeLookups);
		model.addAttribute("marriedStatusTypes", marriedStatusLookups);
		model.addAttribute("yesNoTypes", yesNoLookups);
		model.addAttribute("illness", new IllnessDetails());
		
		return "userIllnessDetails";
	}
	
	@RequestMapping(value="/saveIllness", method = RequestMethod.POST)
	String saveUser(@ModelAttribute("illness") IllnessDetails illness) {
		
		System.out.println(illness);
		
		patientService.saveIllnessDetails(illness);
		
		return "userDashboard";
	}
}
