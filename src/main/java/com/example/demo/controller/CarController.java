package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CarRepo;
import com.example.demo.model.Car;

@RestController
public class CarController {


	@Autowired
	CarRepo repo;
	
	@PostMapping("postCar")
	public Optional<Car> addCar(@RequestBody Car newCar) {
		repo.save(newCar);
		return repo.findById(newCar.getCarID());
	}
	
	@GetMapping("getAllCars")
	public List<Car> getCars(){
		return repo.findAll();
	}
	
}
