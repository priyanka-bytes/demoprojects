package com.bytesedge.demo.convertors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bytesedge.demo.model.LanguagesKnown;
import com.bytesedge.demo.model.Lookup;
import com.bytesedge.demo.service.LookupService;

@Component
public class LanguagesKnownConvertor implements Converter<Object, LanguagesKnown> {

	@Autowired
	private LookupService lookupService;
	
	@Override
	public LanguagesKnown convert(Object source) {
		Long id = Long.parseLong((String) source);
		
		Lookup lang = lookupService.findById(id);
		
		LanguagesKnown langKnown = new LanguagesKnown();
		//langKnown.setUser(user);
		langKnown.setLanguageType(lang);
		System.out.println(langKnown);
		return langKnown;
	}

}
