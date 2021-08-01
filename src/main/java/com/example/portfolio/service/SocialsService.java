package com.example.portfolio.service;

import java.util.List;

import com.example.portfolio.model.Socials;

public interface SocialsService {

	public List<Socials> getSocials();

	public Socials getSocials(String socialId);

	public Socials addSocials(Socials socials);

	public Socials updateSocials(Socials socials);

	public void deleteSocials(String socialId);


}
