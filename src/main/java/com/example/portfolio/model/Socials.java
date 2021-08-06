package com.example.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Socials {

	@Id
	private String socialName;
	private String socialUsername;

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	public void setSocialUsername(String socialUsername) {
		this.socialUsername = socialUsername;
	}

	public String getSocialName() {
		return socialName;
	}

	public String getSocialUsername() {
		return socialUsername;
	}

	public Socials(String socialName, String socialLink) {
		super();
		this.socialName = socialName;
		this.socialUsername = socialLink;
	}

	public Socials() {
		super();
	}

	@Override
	public String toString() {
		return "Socials{" +
				"socialName='" + socialName + '\'' +
				", socialUsername='" + socialUsername + '\'' +
				'}';
	}
}
