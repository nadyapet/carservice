package com.company.carservices.service;

import com.company.carservices.dto.CarServiceHistoryDto;

public interface CarServiceHistoryService {
    CarServiceHistoryDto save(int carId, CarServiceHistoryDto carServiceHistoryDto);
    void delete(int carServiceHistoryId);
}
