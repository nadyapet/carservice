package com.company.carservices.service.implementations;

import com.company.carservices.dto.CarDto;
import com.company.carservices.dto.ServiceReservationDto;
import com.company.carservices.entity.Car;
import com.company.carservices.entity.ServiceReservation;
import com.company.carservices.repository.CarRepository;
import com.company.carservices.repository.ServiceReservationRepository;
import com.company.carservices.service.CarService;
import com.company.carservices.service.ServiceReservationService;
import com.company.carservices.service.mapper.CarMapper;
import com.company.carservices.service.mapper.ServiceReservationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceReservationServiceImpl implements ServiceReservationService {
    private ServiceReservationRepository serviceReservationRepository;
    private ServiceReservationMapper serviceReservationMapper;

    @Override
    public List<ServiceReservationDto> getReservations(int serviceId) {
        ArrayList<ServiceReservationDto> reservations = new ArrayList<ServiceReservationDto>();
        for (ServiceReservation r : serviceReservationRepository.findByServiceId(serviceId)) {
            reservations.add(serviceReservationMapper.MapToDto(r));
        }

        return reservations;
    }

    @Override
    public ServiceReservationDto getById(int id) {
        Optional<ServiceReservation> existingReservation = serviceReservationRepository.findById(id);
        ServiceReservationDto serviceReservationDto = null;
        if (existingReservation != null && existingReservation.isPresent()){
            serviceReservationDto = serviceReservationMapper.MapToDto(existingReservation.get());
        }

        return serviceReservationDto;
    }

    @Override
    public ServiceReservationDto save(ServiceReservationDto reservation) {
        Optional<ServiceReservation> existingReservation = null;
        if (reservation.getId() > 0){
            existingReservation = serviceReservationRepository.findById(reservation.getId());
        }

        ServiceReservation r = serviceReservationMapper.MapFromDto(reservation, existingReservation != null && existingReservation.isPresent() ? existingReservation.get() : null);
        ServiceReservation saved = serviceReservationRepository.save(r);
        reservation.setId(saved.getId());
        return reservation;
    }

    @Override
    public void delete(int id) {
        serviceReservationRepository.deleteById(id);
    }
}
