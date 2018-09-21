package com.hackerrank.weather.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Weather implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(name = "date")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    
    @Embedded
    private Location location;
    
    //private Float[] temperature;

    public Weather() {
    }

    public Weather(Long id, Date dateRecorded, Location location) {
        this.id = id;
        this.date = dateRecorded;
        this.location = location;
        //this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setdate(Date dateRecorded) {
        this.date = dateRecorded;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

//    public Float[] getTemperature() {
//        return temperature;
//    }
//
//    public void setTemperature(Float[] temperature) {
//        this.temperature = temperature;
//    }
}
