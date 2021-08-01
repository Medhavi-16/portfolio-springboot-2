package com.example.portfolio.service;

import java.util.List;

import com.example.portfolio.model.Projects;

public interface ProjectsService {

	public List<Projects> getProjects();

	public Projects getProject(String id);

	public Projects addProject(Projects project);

	public Projects updateProject(Projects project);

	public void deleteProject(String id);

}
