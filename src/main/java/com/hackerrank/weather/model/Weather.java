package com.hackerrank.weather.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Weather implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(name = "date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	//@Convert(converter = DateTimeConverter.class)
	//@Temporal(TemporalType.DATE)
	private LocalDate date;
    
    @Embedded
    private Location location;
    
   
    
   // @ElementCollection
    //@CollectionTable(name ="temperature")
   // @OrderColumn
    //private List<String> tags = new ArrayList<String>();
    private float[] temperature = new float[24];

    public Weather() {
    }

    public Weather(Long id, LocalDate  dateRecorded, Location location,float[] temperature) {
        this.id = id;
        this.date = dateRecorded;
        this.location = location;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate  getDate() {
        return date;
    }

    public void setdate(LocalDate  dateRecorded) {
        this.date = dateRecorded;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public float[] getTemperature() {
        return temperature;
    }

    public void setTemperature(float[] temperature) {
        this.temperature = temperature;
    }
}
