package com.example.portfolio.dao;

import java.util.Collection;
import java.util.List;

import com.example.portfolio.model.Projects;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsDao extends BaseDao<Projects> {

	@Override
	Projects get(String id);

	@Override
	List<Projects> get(Collection<String> id);

	@Override
	Projects createOrUpdate(Projects newEntry);

	@Override
	Projects delete(String id);

	@Override
	List<Projects> getAll();
}
