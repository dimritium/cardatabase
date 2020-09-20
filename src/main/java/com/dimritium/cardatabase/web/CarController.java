package com.dimritium.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dimritium.cardatabase.domain.Car;
import com.dimritium.cardatabase.domain.CarRepository;

@RestController
public class CarController {
	@Autowired
	private CarRepository carRepository;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return carRepository.findAll();
	}
}
