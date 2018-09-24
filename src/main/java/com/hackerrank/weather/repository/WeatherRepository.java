package com.hackerrank.weather.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.hackerrank.weather.model.Weather;



public interface WeatherRepository extends JpaRepository<Weather, Long>{
	
	//List<Weather> findAllBy
	//@Query("SELECT w FROM Weather w WHERE w.date = ?1")
	List<Weather> findByDate(LocalDate compareDate);
	
}
