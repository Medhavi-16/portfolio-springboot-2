package com.example.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.portfolio.model.Socials;
import com.example.portfolio.service.SocialsService;
import org.springframework.stereotype.Service;

@Service
public class SocialsServiceImpl implements SocialsService {

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
		return socials;
	}

	@Override
	public Socials getSocials(String socialId) {
		Optional<Socials> socialsOptional = socials.stream().filter(e -> e.getSocialName().equalsIgnoreCase(socialId)).findFirst();

		return socialsOptional.orElse(null);

	}

	@Override
	public Socials addSocials(Socials socials) {
		this.socials.add(socials);
		return socials;
	}

	@Override
	public Socials updateSocials(Socials social) {
		Optional<Socials> socialsOptional = socials.stream().filter(e -> e.getSocialName().equals(social.getSocialName())).findFirst();
		socialsOptional.map(e -> {
			e.setSocialUsername(social.getSocialUsername());
			e.setSocialBase(social.getSocialBase());
			return e;
		});

		return socialsOptional.orElse(null);
	}

	@Override
	public void deleteSocials(String socialId) {
		socials = socials.stream().filter(e -> !e.getSocialName().equalsIgnoreCase(socialId)).collect(Collectors.toList());

		return;
	}
}
