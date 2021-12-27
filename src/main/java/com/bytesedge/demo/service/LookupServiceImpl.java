package com.bytesedge.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytesedge.demo.dao.LookupDao;
import com.bytesedge.demo.model.Dropdown;
import com.bytesedge.demo.model.Lookup;

@Service
public class LookupServiceImpl implements LookupService {

	@Autowired
	private LookupDao lookupDao;
	
	@Override
	public List<Lookup> getLookupsByCode(String lookupCode) {
		return lookupDao.getLookupsByCode(lookupCode);
	}

	@Override
	public List<Dropdown> getDropdownLookupsByCode(String lookupCode) {
		return lookupDao.getDropdownLookupsByCode(lookupCode);
	}

	@Override
	public List<Object> getDropdownsByCode(String lookupCode) {
		return lookupDao.getDropdownsByCode(lookupCode);
	}

	@Override
	public Lookup findById(Long id) {
		return lookupDao.findById(id);
	}

}
