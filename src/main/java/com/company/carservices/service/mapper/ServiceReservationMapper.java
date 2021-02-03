package com.company.carservices.service.mapper;

import com.company.carservices.dto.CarDto;
import com.company.carservices.dto.ServiceReservationDto;
import com.company.carservices.entity.Car;
import com.company.carservices.entity.ServiceReservation;

public interface ServiceReservationMapper {
    ServiceReservationDto MapToDto(ServiceReservation source);
    ServiceReservation MapFromDto(ServiceReservationDto source, ServiceReservation target);
}
