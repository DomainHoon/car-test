package com.example.cartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cartest.domain.Car;
import com.example.cartest.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	private CarRepository carRepository;
	
	@Autowired
	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public List<Car> list() {
		return carRepository.findAll();
	}

	@Override
	public void register(Car car) {
		carRepository.save(car);
	}

	@Override
	public Car read(Integer id) {
		return carRepository.getById(id);
	}

	@Override
	public void modify(Car car) {
		Car carEntity = carRepository.getById(car.getId());
		carEntity.setModel(car.getModel());
		carEntity.setDescr(car.getDescr());
		carEntity.setMgp(car.getMgp());
		carEntity.setHorsePower(car.getHorsePower());
		carEntity.setYear(car.getYear());

	}

	@Override
	public void delete(Integer id) {
		carRepository.deleteById(id);

	}

}
