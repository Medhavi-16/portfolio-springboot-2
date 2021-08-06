package com.example.portfolio.service.impl;

import javax.persistence.Entity;

import java.util.List;

import com.example.portfolio.dao.ProjectsDao;
import com.example.portfolio.model.Projects;
import com.example.portfolio.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired
	private ProjectsDao dao;

	@Override
	public List<Projects> getProjects() {
		return dao.getAll();
	}

	@Override
	public Projects getProject(String id) {
		return dao.get(id);
	}

	@Override
	public Projects addProject(Projects project) {
		return dao.createOrUpdate(project);
	}

	@Override
	public Projects updateProject(Projects project) {
		return dao.createOrUpdate(project);
	}

	@Override
	public Projects deleteProject(String id) {
		return dao.delete(id);
	}
}
