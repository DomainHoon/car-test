package com.example.cartest.service;

import java.util.List;

import com.example.cartest.domain.Car;

public interface CarService {
	public List<Car> list();
	public void register(Car car);
	public Car read(Integer id);
	public void modify(Car car);
	public void delete(Integer id);

}
