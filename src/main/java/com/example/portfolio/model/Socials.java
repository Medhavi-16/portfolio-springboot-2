package com.example.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Socials {

	@Id
	private String socialName;
	private String socialBase;
	private String socialUsername;

	public void setSocialBase(String socialBase) {
		this.socialBase = socialBase;
	}

	public String getSocialBase() {
		return socialBase;
	}

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

	public Socials(String socialName, String socialBase, String socialLink) {
		super();
		this.socialName = socialName;
		this.socialBase = socialBase;
		this.socialUsername = socialLink;
	}

	public Socials() {
		super();
	}

	@Override
	public String toString() {
		return "Socials{" +
				"socialName='" + socialName + '\'' +
				", socialBase='" + socialBase + '\'' +
				", socialUsername='" + socialUsername + '\'' +
				'}';
	}
}
