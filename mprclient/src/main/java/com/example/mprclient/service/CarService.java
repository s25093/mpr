package com.example.mprclient.service;

import com.example.mprclient.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
//@RequestMapping("https://localhost:8081")
public class CarService {

    RestTemplate restTemplate = new RestTemplate();

    public Car getById(Integer id) {
        ResponseEntity<Car> getById = restTemplate.getForEntity("/getById", Car.class, id);
        if (getById.getBody() == null) {
            throw new NullPointerException();
        }
        return getById.getBody();
    }

    public Car getByMake(String make) {
        ResponseEntity<Car> getByMake = restTemplate.getForEntity("/getByMake", Car.class, make);
        if (getByMake.getBody() == null) {
            throw new NullPointerException();
        }
        return getByMake.getBody();
    }

    public Car getByRegistration(String registration) {
        ResponseEntity<Car> getByRegistration = restTemplate.getForEntity("/getByRegistration", Car.class, registration);
        if (getByRegistration.getBody() == null) {
            throw new NullPointerException();
        }
        return getByRegistration.getBody();
    }

    public void save(Car car) {
        restTemplate.postForEntity("/add", car, Car.class);
    }

    public void delete(Car car) {
        restTemplate.delete("/delete/{id}", Car.class, car);
    }

    public List<Car> getAll() {
        ResponseEntity<Car[]> getAll = restTemplate.getForEntity("http://localhost:8081/getAll", Car[].class);
        if (getAll.getBody() == null) {
            throw new NullPointerException();
        }
        return Arrays.asList(getAll.getBody());
    }

}