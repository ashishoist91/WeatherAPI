package com.hackerrank.weather.controller;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;

@RestController
public class WeatherApiRestController {
	
//	@Autowired
//	private Weather weather;
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	@GetMapping("/weather")
	public List<Weather> getAllWeather(@RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ParseException {
		if(date == null) {
			Sort sort = new Sort(Sort.Direction.ASC, "id");
			return weatherRepository.findAll(sort);
		}
		//weatherRepository.findAll(sort)
		else {
			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//String formattedString = date.format(formatter);
			return weatherRepository.findByDate(date);
		}
	    
	}
	
	
	@PostMapping("/weather")
	public ResponseEntity<Object> createStudent(@RequestBody Weather weather) {
		Weather savedWeather = weatherRepository.save(weather);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedWeather.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	

	
	
	@DeleteMapping("/erase")
	public void deleteWeatherData(@RequestParam(value = "start", required = false) String startDate, @RequestParam(value = "end", required = false) String endDate,
			@RequestParam(value = "lat", required = false) Float latitude,@RequestParam(value = "lon", required = false) Float longitude) {
		
		if(startDate == null && endDate == null && latitude == null && longitude == null) {
			weatherRepository.deleteAll();
		}else {
			System.out.println(startDate);
		}
		
	}
	
	
	
	//@RequestParam("id") long id
}