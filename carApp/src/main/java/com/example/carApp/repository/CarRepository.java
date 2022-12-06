package com.example.carApp.repository;

import com.example.carApp.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    Car findCarById(Integer id);
    Car findCarByMake(String make);
    Car findCarByRegistration(String registration);

    List<Car> findAll();
}
