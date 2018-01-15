package io.spring.service;

import java.util.List;

import io.spring.entity.Car;

public interface CarService {

	List<Car> findAll();

	Car findOne(String vin);

	Car create(Car car);

	Car update(String vin, Car car);

	void delete(String vin);

}
