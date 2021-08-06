package com.example.portfolio.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.portfolio.dao.ProfileDao;
import com.example.portfolio.model.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ProfileDaoImpl implements ProfileDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Profile get(String id) {
		List<Profile> profiles = getSession().createQuery("from Profile where name=:id").setParameter("id", id).list();
		if(profiles.size() >= 1)
			return profiles.get(0);

		return null;
	}

	@Override
	public List<Profile> get(Collection<String> id) {
		return getSession().createQuery("from Profile").list();
	}

	@Override
	public Profile createOrUpdate(Profile newEntry) {
		getSession().saveOrUpdate(newEntry);
		return newEntry;
	}

	@Override
	public Profile delete(String id) {
		Optional<List<Profile>> optionalProfile = Optional.of(getSession().createQuery("from Profile where name= :id").setParameter("id", id).list());
		if(optionalProfile.isPresent())
		{
			getSession().delete(id);
			return optionalProfile.get().get(0);
		}

		return null;
	}

	@Override
	public List<Profile> getAll() {
		return getSession().createQuery("from Profile ").list();
	}
}
