package com.example.portfolio.service.impl;

import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;

import com.example.portfolio.dao.ProfileDao;
import com.example.portfolio.model.Profile;
import com.example.portfolio.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao dao;

	@Override
	public Profile getProfile() {
		List<Profile> profileList = dao.getAll();
		if(!profileList.isEmpty())
			return profileList.get(0);
		return null;
	}

	@Override
	public Profile addProfile(Profile profile) {
		return dao.createOrUpdate(profile);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		return dao.createOrUpdate(profile);
	}

	@Override
	public Profile updateProfile(String param, String value) {

		Optional<Profile> optionalProfile = updateParam(param, value, dao.getAll().get(0));
		optionalProfile.ifPresent(profile -> dao.createOrUpdate(profile));
		return optionalProfile.get();
	}

	private Optional<Profile> updateParam(String param, String value, Profile profile) {
		switch (param) {
			case "description" : profile.setDescription(value);
								 return Optional.of(profile);
			case "profileImg" : profile.setProfileImg(value);
								return Optional.of(profile);
		}
		return Optional.empty();
	}
}
