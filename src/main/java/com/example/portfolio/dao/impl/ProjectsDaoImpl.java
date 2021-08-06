package com.example.portfolio.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.portfolio.dao.ProjectsDao;
import com.example.portfolio.model.Profile;
import com.example.portfolio.model.Projects;
import com.example.portfolio.model.SocialMedia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ProjectsDaoImpl implements ProjectsDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Projects get(String id) {
		List<Projects> projects = getSession().createQuery("from Projects where id=:id").setParameter("id", id).list();

		if(projects.size() >= 1)
			return projects.get(0);

		return null;
	}

	@Override
	public List<Projects> get(Collection<String> id) {
		List<Projects> projects = getSession().createQuery("from Projects where id in (:id)").setParameter("id", id).list();

		return projects;
	}

	@Override
	public Projects createOrUpdate(Projects newEntry) {
		getSession().saveOrUpdate(newEntry);
		return newEntry;
	}

	@Override
	public Projects delete(String id) {
		Optional<Projects> optionalProjects = Optional.of(get(id));
		if(optionalProjects.isPresent()) {
			getSession().delete(id);
		}
		return optionalProjects.orElse(null);
	}

	@Override
	public List<Projects> getAll() {
		return getSession().createQuery("from Projects ").list();
	}
}
