package com.company.carservices.service.implementations;

import com.company.carservices.dto.CarDto;
import com.company.carservices.entity.Car;
import com.company.carservices.repository.CarRepository;
import com.company.carservices.service.CarService;
import com.company.carservices.service.mapper.CarMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    private CarMapper carMapper;

    @Override
    public List<CarDto> getCars(int userId) {
        ArrayList<CarDto> cars = new ArrayList<CarDto>();
        for (Car c : carRepository.findByUserId(userId)) {
            cars.add(carMapper.MapToDto(c));
        }

        return cars;
    }

    @Override
    public CarDto getById(int id) {
        Optional<Car> existingCar = carRepository.findById(id);
        CarDto carDto = null;
        if (existingCar != null && existingCar.isPresent()){
            carDto = carMapper.MapToDto(existingCar.get());
        }

        return carDto;
    }

    @Override
    public CarDto save(CarDto car)
    {
        Optional<Car> existingCar = null;
        if (car.getId() > 0){
            existingCar = carRepository.findById(car.getId());
        }
        Car c = carMapper.MapFromDto(car, existingCar != null && existingCar.isPresent() ? existingCar.get() : null);
        Car saved = carRepository.save(c);
        car.setId(saved.getId());
        return car;
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
