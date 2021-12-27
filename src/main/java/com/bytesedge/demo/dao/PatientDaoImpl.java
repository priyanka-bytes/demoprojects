package com.bytesedge.demo.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bytesedge.demo.model.IllnessDetails;


@Repository
@Transactional
public class PatientDaoImpl extends AbstractDao implements PatientDao {

	@Override
	public void saveIllnessDetails(IllnessDetails illnessDetails) {
		Session session = getSession();
		
		session.saveOrUpdate(illnessDetails);
		
	}

}
