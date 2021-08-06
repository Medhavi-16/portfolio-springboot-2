package com.example.portfolio.dao;

import java.util.Collection;
import java.util.List;

import com.example.portfolio.model.Socials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialsDao extends BaseDao<Socials> {

	@Override
	Socials get(String id);

	@Override
	List<Socials> get(Collection<String> id);

	@Override
	Socials createOrUpdate(Socials newEntry);

	@Override
	Socials delete(String id);

	@Override
	List<Socials> getAll();
}
