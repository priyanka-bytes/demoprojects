package com.bytesedge.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bytesedge.demo.model.City;

@Repository
@Transactional
public class CityDaoImpl implements CityDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<City> getAllCities() {
		List<City> cities = manager.createQuery("Select u from City u", City.class).getResultList();
		return cities;
	}

}
