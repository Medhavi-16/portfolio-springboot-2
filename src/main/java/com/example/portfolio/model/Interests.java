package com.example.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Interests {

	@Id
	private Long id;

	private String interest;

	public Interests() {
		super();
	}

	public Interests(Long id, String interest) {
		this.id = id;
		this.interest = interest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "Interests{" +
				"id=" + id +
				", interest='" + interest + '\'' +
				'}';
	}
}
