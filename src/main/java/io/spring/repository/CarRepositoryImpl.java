package io.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import io.spring.entity.Car;


@Repository
public class CarRepositoryImpl implements CarRepository {

	@Override
	public List<Car> findAll() {
		// TODO Auto-generated method stub
		List<Car> carslist = new ArrayList<Car>();
		Car car1 = new Car();
		car1.setVin("1HGCR2F3XFA027534");
		Car car2 = new Car();
		car2.setVin("WP1AB29P63LA60179");
		carslist.add(car1);
		carslist.add(car2);

		return carslist;
	}

	@Override
	public Car findOne(String vin) {
		// TODO Auto-generated method stub
		Car car1 = new Car();
		car1.setVin("WP1AB29P63LA60179");
		return car1;
	}

	@Override
	public Car update(String vin, Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car createOne(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String vin) {
		// TODO Auto-generated method stub

	}

	@Override
	public Car findByVin(String vin) {
		// TODO Auto-generated method stub
		return null;
	}

}
