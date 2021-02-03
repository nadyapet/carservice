package com.company.carservices.service;

import com.company.carservices.dto.CarDto;
import com.company.carservices.dto.ServiceReservationDto;
import com.company.carservices.entity.ServiceReservation;

import java.util.List;

public interface ServiceReservationService {
    List<ServiceReservationDto> getReservations(int serviceId);
    ServiceReservationDto getById(int id);
    ServiceReservationDto save(ServiceReservationDto car);
    void delete(int id);
}
