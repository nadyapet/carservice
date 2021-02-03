package com.company.carservices.service.mapper;

import com.company.carservices.dto.CarDto;
import com.company.carservices.entity.Car;

public interface CarMapper {
    CarDto MapToDto(Car source);
    Car MapFromDto(CarDto source, Car target);
}
