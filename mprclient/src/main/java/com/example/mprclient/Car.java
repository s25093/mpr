package com.example.mprclient;

public class Car {
    private Integer id;
    private String make;
    private String registration;

    public Car(Integer id, String make, String registration) {
        this.id = id;
        this.make = make;
        this.registration = registration;
    }

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", registration='" + registration + '\'' +
                '}';
    }
}
