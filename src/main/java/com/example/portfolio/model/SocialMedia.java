package com.example.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class SocialMedia {

	@Id
	private String socialName;

	private String socialBase;

	public SocialMedia() {
	}

	public SocialMedia(String socialName, String socialBase) {
		this.socialName = socialName;
		this.socialBase = socialBase;
	}

	public String getSocialName() {
		return socialName;
	}

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	public String getSocialBase() {
		return socialBase;
	}

	public void setSocialBase(String socialBase) {
		this.socialBase = socialBase;
	}

	@Override
	public String toString() {
		return "SocialMedia{" +
				"socialName='" + socialName + '\'' +
				", socialBase='" + socialBase + '\'' +
				'}';
	}
}
