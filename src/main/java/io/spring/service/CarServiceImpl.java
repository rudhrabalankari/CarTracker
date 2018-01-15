package io.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.entity.Car;
import io.spring.exception.BadRequestException;
import io.spring.exception.NotFoundException;
import io.spring.repository.CarRepository;
import io.spring.repository.CarRepositoryImpl;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository repository;

	@Override
	public List<Car> findAll() {
		return repository.findAll();
	}

	@Override
	public Car findOne(String vin) {
		Car existingCar = repository.findOne(vin);
		if (existingCar == null) {
			throw new NotFoundException("Car with vin " + vin + "doesn't exist!!");
		}
		return existingCar;
	}

	@Override
	public Car create(Car car) {
		Car existingCar = repository.findByVin(car.getVin());
		if (existingCar != null) {
			throw new BadRequestException("Car with vin " + car.getVin() + "already exists!!");
		}
		return repository.createOne(car);
	}

	@Override
	public Car update(String vin, Car car) {
		Car existingCar = repository.findOne(vin);
		if (existingCar == null) {
			throw new NotFoundException("Car with vin " + vin + "doesn't exist!!");
		}
		return repository.update(vin, car);
	}

	@Override
	public void delete(String vin) {
		Car existingCar = repository.findOne(vin);
		if (existingCar == null) {
			throw new NotFoundException("Car with vin " + vin + "doesn't exist!!");
		}
		repository.delete(vin);

	}

}
