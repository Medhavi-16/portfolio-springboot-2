package com.example.portfolio.dao;

import java.util.Collection;
import java.util.List;

import com.example.portfolio.model.SocialMedia;


public interface SocialMediaDao extends BaseDao<SocialMedia> {

	@Override
	SocialMedia get(String id);

	@Override
	List<SocialMedia> get(Collection<String> id);

	@Override
	SocialMedia createOrUpdate(SocialMedia newEntry);

	@Override
	SocialMedia delete(String id);

	@Override
	List<SocialMedia> getAll();
}
