package com.example.portfolio.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.portfolio.dao.SocialMediaDao;
import com.example.portfolio.model.SocialMedia;
import com.example.portfolio.model.Socials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SocialMediaDaoImpl implements SocialMediaDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public SocialMedia get(String id) {
		@SuppressWarnings("unchecked")
		List<SocialMedia> socialMedia = getSession().createQuery("from SocialMedia where socialName=:id").setParameter("id", id).list();

		if(socialMedia.size() >= 1)
			return socialMedia.get(0);

		return null;
	}

	@Override
	public List<SocialMedia> get(Collection<String> id) {
		@SuppressWarnings("unchecked")
		List<SocialMedia> socialMedia = getSession().createQuery("from SocialMedia where socialName in (:id)").setParameter("id", id).list();

		return socialMedia;
	}

	@Override
	public SocialMedia createOrUpdate(SocialMedia newEntry) {
		getSession().saveOrUpdate(newEntry);
		return newEntry;
	}

	@Override
	public SocialMedia delete(String id) {
		Optional<SocialMedia> socials = Optional.of(get(id));
		if(socials.isPresent()) {
			getSession().delete(id);
		}
		return socials.orElse(null);
	}

	@Override
	public List<SocialMedia> getAll() {
		return getSession().createQuery("from SocialMedia").list();
	}
}
