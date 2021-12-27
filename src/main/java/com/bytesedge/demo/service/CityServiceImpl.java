package com.bytesedge.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytesedge.demo.dao.CityDao;
import com.bytesedge.demo.model.City;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityDao cityDao;

	@Override
	public List<City> getAllCities() {
		return cityDao.getAllCities();
	}

}
