package com.company.carservices.service.implementations;

import com.company.carservices.dto.CarDto;
import com.company.carservices.dto.CarServiceHistoryDto;
import com.company.carservices.entity.Car;
import com.company.carservices.entity.CarServiceHistory;
import com.company.carservices.repository.CarRepository;
import com.company.carservices.repository.CarServiceHistoryRepository;
import com.company.carservices.service.CarServiceHistoryService;
import com.company.carservices.service.mapper.CarMapper;
import com.company.carservices.service.mapper.CarServiceHistoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceHistoryServiceImpl implements CarServiceHistoryService {
    private CarServiceHistoryMapper carServiceHistoryMapper;
    private CarServiceHistoryRepository carServiceHistoryRepository;

    @Override
    public CarServiceHistoryDto save(int carId, CarServiceHistoryDto carServiceHistoryDto) {
        CarServiceHistory carServiceHistory = carServiceHistoryMapper.MapFromDto(carServiceHistoryDto, null);
        carServiceHistory = carServiceHistoryRepository.save(carServiceHistory);
        carServiceHistoryDto.setId(carServiceHistory.getId());
        return carServiceHistoryDto;
    }

    @Override
    public void delete(int carServiceHistoryId) {
        carServiceHistoryRepository.deleteById(carServiceHistoryId);
    }
}
