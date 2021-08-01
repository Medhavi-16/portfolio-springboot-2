package com.example.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {

	@Id
	private String name;
	private String description;
	private String profileImg;

	public Profile() {
		super();
	}

	public Profile(String name, String description, String profileImg) {
		this.name = name;
		this.description = description;
		this.profileImg = profileImg;
	}

	@Override
	public String toString() {
		return "Profile{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", profileImg='" + profileImg + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
}
