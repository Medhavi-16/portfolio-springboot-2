package com.example.portfolio.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.portfolio.dao.SocialsDao;
import com.example.portfolio.model.Projects;
import com.example.portfolio.model.SocialMedia;
import com.example.portfolio.model.Socials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SocialsDaoImpl implements SocialsDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public Socials get(String id) {
		List<Socials> socials = getSession().createQuery("from Socials where socialName=:id").setParameter("id", id).list();

		if(socials.size() >= 1)
			return socials.get(0);

		return null;
	}

	@Override
	public List<Socials> get(Collection<String> id) {
		List<Socials> socials = getSession().createQuery("from Socials where socialName in (:id)").setParameter("id", id).list();

		return socials;
	}

	@Override
	public Socials createOrUpdate(Socials newEntry) {
		getSession().saveOrUpdate(newEntry);
		return newEntry;
	}

	@Override
	public Socials delete(String id) {
		Optional<Socials> socials = Optional.of(get(id));
		if(socials.isPresent()) {
			getSession().delete(id);
		}
		return socials.orElse(null);
	}

	@Override
	public List<Socials> getAll() {
		return getSession().createQuery("from Socials ").list();
	}
}
