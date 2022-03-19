package com.example.cartest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cartest.domain.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
