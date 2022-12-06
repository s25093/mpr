package com.example.carApp.service;

import com.example.carApp.Car;
import com.example.carApp.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public Car getById(Integer id) {
        return carRepository.findCarById(id);
    }

    public Car getByMake(String make) {
        return carRepository.findCarByMake(make);
    }

    public Car getByRegistration(String registration) {
        return carRepository.findCarByRegistration(registration);
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

}
