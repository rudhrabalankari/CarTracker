package io.spring.repository;

import java.util.List;

import io.spring.entity.Car;

public interface CarRepository {

	public List<Car> findAll();

	public Car findOne(String vin);

	public Car update(String vin, Car car);

	public Car createOne(Car car);

	public void delete(String vin);

	public Car findByVin(String vin);

}
