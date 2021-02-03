package com.company.carservices.service;

import com.company.carservices.dto.CarDto;
import com.company.carservices.entity.Car;

import java.util.List;

public interface CarService {
    List<CarDto> getCars(int userId);
    CarDto getById(int id);
    CarDto save(CarDto car);
    void deleteCar(int id);
}
