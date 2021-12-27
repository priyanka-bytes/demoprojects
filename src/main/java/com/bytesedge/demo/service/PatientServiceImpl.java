package com.bytesedge.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytesedge.demo.dao.PatientDao;
import com.bytesedge.demo.dao.UserDao;
import com.bytesedge.demo.model.IllnessDetails;
import com.bytesedge.demo.model.IllnessDetailsComment;
import com.bytesedge.demo.model.IllnessHistory;
import com.bytesedge.demo.model.IllnessHistoryInvestigationDetails;
import com.bytesedge.demo.model.LanguagesKnown;
import com.bytesedge.demo.model.Lookup;
import com.bytesedge.demo.model.SpiritualPracticeType;
import com.bytesedge.demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private LookupService lookupService;
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private  UserDao userDao;
	
	@Override
	public void saveIllnessDetails(IllnessDetails illnessDetails) {
		System.out.println(illnessDetails);
		
		User patient = userDao.findById(Long.parseLong("2"));
		
		List<IllnessDetailsComment> illnessComments = getStressTreatment(illnessDetails);
		List<SpiritualPracticeType> spiritualPractices = getSpiritualPracticeType(illnessDetails);
		
		List<IllnessHistory> illnessHistory = getIllnessHistory(illnessDetails);
		
		illnessDetails.setPatient(patient);
		illnessDetails.setComments(illnessComments);
		illnessDetails.setSpiritualPracticeType(spiritualPractices);
		illnessDetails.getSpiritualPracticeDuration().setIllnessDetails(illnessDetails);
		illnessDetails.setHistory(illnessHistory);
		
		patientDao.saveIllnessDetails(illnessDetails);
	}
	
	
	private List<IllnessDetailsComment> getStressTreatment(IllnessDetails illnessDetails) {
		List<IllnessDetailsComment> comments = new ArrayList<IllnessDetailsComment>();
		
		Lookup stressType	= illnessDetails.getStressType();
		Lookup treatmentType= illnessDetails.getTreatmentType();
		
		String stressTypeComments	= illnessDetails.getStressComments();
		String treatmentTypeComments= illnessDetails.getTreatmentComments();
		
		IllnessDetailsComment stressComments = new IllnessDetailsComment();
		IllnessDetailsComment treatmentComments = new IllnessDetailsComment();
		
		stressComments.setIllnessDetails(illnessDetails);
		stressComments.setIllnessTypeId(stressType);
		stressComments.setComments(stressTypeComments);
		
		treatmentComments.setIllnessDetails(illnessDetails);
		treatmentComments.setIllnessTypeId(treatmentType);
		treatmentComments.setComments(treatmentTypeComments);
		
		comments.add(treatmentComments);
		comments.add(stressComments);
		
		return comments;
	}
	
	private List<SpiritualPracticeType> getSpiritualPracticeType(IllnessDetails illnessDetails) {
		List<SpiritualPracticeType> spiritualPracticeType = new ArrayList<SpiritualPracticeType>();
		
		String practiceTypesStr = illnessDetails.getSpiritualPracticeTypeStr();
		
		StringTokenizer st = new StringTokenizer(practiceTypesStr, ",");
		
		while(st.hasMoreTokens()) {
			SpiritualPracticeType spiritualPractice = new SpiritualPracticeType();
			
			Long pracTypeId = (Long)Long.parseLong(st.nextToken());
			Lookup practiceType = lookupService.findById(pracTypeId);
			
			spiritualPractice.setIllnessDetails(illnessDetails);
			spiritualPractice.setPracticeType(practiceType);
			
			spiritualPracticeType.add(spiritualPractice);
		}
		
		return spiritualPracticeType;
	}

	private List<IllnessHistory> getIllnessHistory(IllnessDetails illnessDetails) {
		List<IllnessHistory> hisList = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			hisList = mapper.readerForListOf(IllnessHistory.class).readValue(illnessDetails.getIllnessHistoryJson());
			
			 for (IllnessHistory his : hisList) {
				 his.setIllnessDetails(illnessDetails);
				 
				 for(IllnessHistoryInvestigationDetails instDtls : his.getIllnessHistoryInvestigationDetails()) {
					instDtls.setIllnessHistory(his);
				 }
				 
			 }
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return hisList;
	}
}
