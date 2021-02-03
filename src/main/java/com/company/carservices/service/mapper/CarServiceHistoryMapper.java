package com.company.carservices.service.mapper;

import com.company.carservices.dto.CarDto;
import com.company.carservices.dto.CarServiceHistoryDto;
import com.company.carservices.entity.Car;
import com.company.carservices.entity.CarServiceHistory;

public interface CarServiceHistoryMapper {
    CarServiceHistoryDto MapToDto(CarServiceHistory source);
    CarServiceHistory MapFromDto(CarServiceHistoryDto source, CarServiceHistory target);
}
