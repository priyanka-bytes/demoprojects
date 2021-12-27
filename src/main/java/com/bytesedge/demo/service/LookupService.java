package com.bytesedge.demo.service;

import java.util.List;

import com.bytesedge.demo.model.Dropdown;
import com.bytesedge.demo.model.Lookup;

public interface LookupService {
	public List<Lookup> getLookupsByCode(String lookupCode);
	
	public List<Dropdown> getDropdownLookupsByCode(String lookupCode);
	
	public List<Object> getDropdownsByCode(String lookupCode);
	
	public Lookup findById(Long id);
	
}
