package com.example.mprclient.controller;

import com.example.mprclient.Car;
import com.example.mprclient.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(path = "/getAll")
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping(path = "/getById")
    public @ResponseBody Car getCarById(@RequestParam Integer id) {
        if (carService.getById(id) == null) {
            System.err.println("Car not found.");
            return null;
        }
        return carService.getById(id);
    }

    @GetMapping(path = "/getByMake")
    public @ResponseBody Car getCarByMake(@RequestParam String make) {
        if (carService.getByMake(make) == null) {
            System.err.println("Car not found.");
            return null;
        }
        return carService.getByMake(make);
    }

    @GetMapping(path = "/getByRegistration")
    public @ResponseBody Car getCarByRegistration(@RequestParam String registration) {
        if (carService.getByRegistration(registration) == null) {
            System.err.println("Car not found.");
            return null;
        }
        return carService.getByRegistration(registration);
    }

    @PostMapping(path = "/add")
    public void addCar(@RequestBody Car car) {
        carService.save(car);
    }

    @PatchMapping(path = "/update/{id}/{make}")
    public void updateCar(@PathVariable Integer id, @PathVariable String make) {
        Car car = carService.getById(id);
        car.setMake(make);
        carService.save(car);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCar(@PathVariable Integer id) {
        Car car = getCarById(id);
        carService.delete(car);
    }
}
