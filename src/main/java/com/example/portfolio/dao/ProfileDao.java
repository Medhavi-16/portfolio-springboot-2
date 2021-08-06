package com.example.portfolio.dao;

import java.util.Collection;
import java.util.List;

import com.example.portfolio.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDao extends BaseDao<Profile> {

	@Override
	Profile get(String id);

	@Override
	List<Profile> get(Collection<String> id);

	@Override
	Profile createOrUpdate(Profile newEntry);

	@Override
	Profile delete(String id);

	@Override
	List<Profile> getAll();
}
