package com.company.carservices.service.mapper.Implementations;

import com.company.carservices.dto.CarDto;
import com.company.carservices.dto.CarServiceHistoryDto;
import com.company.carservices.dto.CodeDto;
import com.company.carservices.entity.*;
import com.company.carservices.service.mapper.CarMapper;
import com.company.carservices.service.mapper.CarServiceHistoryMapper;
import org.springframework.stereotype.Component;

@Component
public class CarServiceHistoryMapperImpl implements CarServiceHistoryMapper {

    @Override
    public CarServiceHistoryDto MapToDto(CarServiceHistory source) {
        CarServiceHistoryDto target = new CarServiceHistoryDto();
        target.setId(source.getId());
        target.setCar(new CodeDto(source.getCar()));
        target.setService(new CodeDto(source.getService()));
        target.setServiceType(new CodeDto(source.getServiceType()));
        target.setPrice(source.getPrice());

        return target;
    }

    @Override
    public CarServiceHistory MapFromDto(CarServiceHistoryDto source, CarServiceHistory target) {
        if (target == null) {
            target = new CarServiceHistory();
        }

        Car car = new Car();
        car.setId(source.getCar().getId());
        target.setCar(car);

        Service service = new Service();
        service.setId(source.getService().getId());
        target.setService(service);

        ServiceType serviceType = new ServiceType();
        serviceType.setId(source.getServiceType().getId());
        target.setServiceType(serviceType);

        target.setPrice(source.getPrice());

        return target;
    }
}
