package com.bytesedge.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bytesedge.demo.model.Dropdown;
import com.bytesedge.demo.model.Lookup;

@Repository
@Transactional
public class LookupDaoImpl implements LookupDao {
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public List<Lookup> getLookupsByCode(String lookupCode) {
		//List<Lookup> lookups = manager.createQuery("Select l from Lookup l where l.lookupCode=:code", Lookup.class)
								//.setParameter("code", lookupCode).getResultList();
		List<Lookup> lookups = null;
		try {
			lookups = (List<Lookup>) hibernateTemplate.find("from Lookup l where l.lookupCode = ?0 ", new Object[] { lookupCode });
		} catch (Exception e) {
			System.out.println(e);
		}

		
		return lookups;
	}

	@Override
	public List<Dropdown> getDropdownLookupsByCode(String lookupCode) {
		List<Dropdown> lookups = manager.createQuery("Select l.id, l.lookupValue from Lookup l where l.lookupCode=:code", Dropdown.class)
				.setParameter("code", lookupCode).getResultList();

		return lookups;
	}

	@Override
	public List<Object> getDropdownsByCode(String lookupCode) {
		List<Object> lookups = manager.createQuery("Select l.id, l.lookupValue from Lookup l where l.lookupCode=:code", Object.class)
				.setParameter("code", lookupCode).getResultList();

		return lookups;

	}

	@Override
	public Lookup findById(Long id) {
		return manager.createQuery("Select l from Lookup l where l.id =:lookupId", Lookup.class)
				.setParameter("lookupId", id).getSingleResult();
	}

}
