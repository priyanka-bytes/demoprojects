package com.bytesedge.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bytesedge.demo.model.State;

@Repository
@Transactional
public class StateDaoImpl implements StateDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<State> getAllStates() {
		List<State> states = manager.createQuery("Select u from State u", State.class).getResultList();
		return states;
	}

}
