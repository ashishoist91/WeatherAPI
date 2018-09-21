package com.hackerrank.weather.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Location implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "lat")
	private Float lat;
	@Column(name = "lon")
	private Float lon;
	@Column(name = "city")
    private String city;
	@Column(name = "state")
    private String state;
   

    public Location() {
    }

    public Location(String cityName, String stateName, Float latitude, Float longitude) {
        this.city = cityName;
        this.state = stateName;
        this.lat = latitude;
        this.lon = longitude;
    }

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

  
}