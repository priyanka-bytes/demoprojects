package com.bytesedge.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytesedge.demo.dao.StateDao;
import com.bytesedge.demo.model.State;

@Service
public class StateServiceImpl implements StateService {
	@Autowired
	private StateDao stateDao;
	
	@Override
	public List<State> getAllStates() {
		return stateDao.getAllStates();
	}

}
