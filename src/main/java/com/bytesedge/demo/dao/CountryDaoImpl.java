package com.bytesedge.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bytesedge.demo.model.Country;

@Repository
@Transactional
public class CountryDaoImpl implements CountryDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Country> getAllCountries() {
		List<Country> countries = manager.createQuery("Select u from Country u", Country.class).getResultList();
		return countries;
	}

}
