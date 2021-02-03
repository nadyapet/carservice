package com.company.carservices.service.mapper.Implementations;

import com.company.carservices.dto.CodeDto;
import com.company.carservices.dto.ServiceReservationDto;
import com.company.carservices.entity.Car;
import com.company.carservices.entity.Service;
import com.company.carservices.entity.ServiceReservation;
import com.company.carservices.service.mapper.ServiceReservationMapper;
import org.springframework.stereotype.Component;

@Component
public class ServiceReservationMapperImpl implements ServiceReservationMapper {

    @Override
    public ServiceReservationDto MapToDto(ServiceReservation source) {
        ServiceReservationDto target = new ServiceReservationDto();
        target.setCar(new CodeDto(source.getCar()));
        target.setService(new CodeDto(source.getService()));
        target.setOrderDate(source.getOrderDate());
        target.setServiceDate(source.getServiceDate());
        target.setRemark(source.getRemark());
        return target;
    }

    @Override
    public ServiceReservation MapFromDto(ServiceReservationDto source, ServiceReservation target) {
        if (target == null) {
            target = new ServiceReservation();
        }

        Car car = new Car();
        car.setId(source.getCar().getId());
        target.setCar(car);

        Service service = new Service();
        service.setId(source.getService().getId());
        target.setService(service);

        target.setOrderDate(source.getOrderDate());
        target.setServiceDate(source.getServiceDate());
        target.setRemark(source.getRemark());

        return target;
    }
}
