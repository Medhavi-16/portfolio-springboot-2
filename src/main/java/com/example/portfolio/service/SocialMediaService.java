package com.example.portfolio.service;

import java.util.List;

import com.example.portfolio.model.SocialMedia;

public interface SocialMediaService {

	List<SocialMedia> get();

	List<SocialMedia> get(List<String> id);

	SocialMedia get(String id);

	SocialMedia create(SocialMedia socialMedia);

}
