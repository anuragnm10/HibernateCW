package com.gl.HibernateMavenDemo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;
	private String country;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
