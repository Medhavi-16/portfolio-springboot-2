package com.example.portfolio.service.impl;

import java.util.List;

import com.example.portfolio.dao.SocialMediaDao;
import com.example.portfolio.model.SocialMedia;
import com.example.portfolio.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaServiceImpl implements SocialMediaService {

	@Autowired
	SocialMediaDao dao;

	@Override
	public List<SocialMedia> get() {
		return dao.getAll();
	}

	@Override
	public List<SocialMedia> get(List<String> id) {
		return dao.get(id);
	}

	@Override
	public SocialMedia get(String id) {
		return dao.get(id);
	}

	@Override
	public SocialMedia create(SocialMedia socialMedia) {
		return dao.createOrUpdate(socialMedia);
	}
}
