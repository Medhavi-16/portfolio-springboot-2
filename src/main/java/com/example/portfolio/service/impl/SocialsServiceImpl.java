package com.example.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.portfolio.dao.SocialsDao;
import com.example.portfolio.model.Socials;
import com.example.portfolio.service.SocialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialsServiceImpl implements SocialsService {

	@Autowired
	private SocialsDao socialsDao;

	List<Socials> socials;

	public SocialsServiceImpl(List<Socials> socials) {
		this.socials = socials;
	}

	public SocialsServiceImpl() {
		socials = new ArrayList<>();

		socials.add(new Socials("Github", "www.github.com", "Medhavi-16"));
	}

	@Override
	public List<Socials> getSocials() {
		return socialsDao.findAll();
	}

	@Override
	public Socials getSocials(String socialId) {
//		Optional<Socials> socialsOptional = socials.stream().filter(e -> e.getSocialName().equalsIgnoreCase(socialId)).findFirst();
//
//		return socialsOptional.orElse(null);

		return socialsDao.findById(socialId).orElse(null);

	}

	@Override
	public Socials addSocials(Socials socials) {
		//this.socials.add(socials);
		socialsDao.save(socials);
		return socials;
	}

	@Override
	public Socials updateSocials(Socials social) {
//		Optional<Socials> socialsOptional = socials.stream().filter(e -> e.getSocialName().equals(social.getSocialName())).findFirst();
//		socialsOptional.map(e -> {
//			e.setSocialUsername(social.getSocialUsername());
//			e.setSocialBase(social.getSocialBase());
//			return e;
//		});

		socialsDao.save(social);

		return social;
	}

	@Override
	public void deleteSocials(String socialId) {
		//socials = socials.stream().filter(e -> !e.getSocialName().equalsIgnoreCase(socialId)).collect(Collectors.toList());

		socialsDao.deleteById(socialId);

		return;
	}
}
