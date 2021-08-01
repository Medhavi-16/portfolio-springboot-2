package com.example.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;

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

		for(Socials socials: this.socials)
		{
			if(socials.getSocialName().equalsIgnoreCase(socialId)) {
				return socials;
			}
		}
		return null;
	}

	@Override
	public Socials addSocials(Socials socials) {
		this.socials.add(socials);
		return socials;
	}

	@Override
	public Socials updateSocials(Socials social) {
		for(Socials socials: this.socials) {

			if(socials.getSocialName().equals(social.getSocialName()))
			{
				socials.setSocialBase(social.getSocialBase());
				socials.setSocialUsername(social.getSocialUsername());
				return socials;
			}
		}

		return null;
	}

	@Override
	public Socials deleteSocials(String socialId) {
		Socials deletedSocials = null;
		for(Socials socials: this.socials)
		{
			if(socials.getSocialName().equalsIgnoreCase(socialId)) {
				deletedSocials = socials;
				break;
			}
		}

		if(deletedSocials != null)
			this.socials.remove(deletedSocials);

		return  deletedSocials;
	}
}
