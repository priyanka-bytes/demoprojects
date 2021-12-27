package com.bytesedge.demo.dao;

import java.util.List;

import com.bytesedge.demo.model.Dropdown;
import com.bytesedge.demo.model.Lookup;

public interface LookupDao {
	
	public List<Lookup> getLookupsByCode(String lookupCode);
	
	public List<Dropdown> getDropdownLookupsByCode(String lookupCode);
	
	public List<Object> getDropdownsByCode(String lookupCode);
	
	public Lookup findById(Long id);
}
