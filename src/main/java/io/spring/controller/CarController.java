package io.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.entity.Car;
import io.spring.service.CarService;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

	@Autowired
	CarService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Car> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Car findOne(@PathVariable("vin") String vin) {
		return service.findOne(vin);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Car create(@RequestBody Car car) {
		return service.create(car);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{vin}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Car update(@PathVariable("vin") String vin, @RequestBody Car car) {
		return service.update(vin, car);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
	public void delete(@PathVariable("vin") String vin) {
		service.delete(vin);
	}

}