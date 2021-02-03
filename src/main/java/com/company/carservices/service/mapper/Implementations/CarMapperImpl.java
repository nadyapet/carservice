package com.company.carservices.service.mapper.Implementations;

import com.company.carservices.dto.CarDto;
import com.company.carservices.dto.CodeDto;
import com.company.carservices.entity.Car;
import com.company.carservices.entity.Manufacturer;
import com.company.carservices.entity.User;
import com.company.carservices.repository.ManufacturerRepository;
import com.company.carservices.service.mapper.CarMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDto MapToDto(Car source) {
        CarDto target = new CarDto();
        target.setRegistrationNumber(source.getRegistrationNumber());
        target.setModel(source.getModel());
        target.setYear(source.getYear());
        target.setManufacturer(source.getManufacturer().getId());
        target.setUser(new CodeDto(source.getUser().getId(),""));
        return target;
    }

    @Override
    public Car MapFromDto(CarDto source, Car target) {
        if (target == null) {
            target = new Car();
        }

        target.setRegistrationNumber(source.getRegistrationNumber());
        target.setModel(source.getModel());
        target.setYear(source.getYear());

        Manufacturer m = new Manufacturer();
        m.setId(source.getManufacturer());
        target.setManufacturer(m);

        if (source.getUser() != null && source.getUser().getId() > 0) {
            User u = new User();
            u.setId(source.getUser().getId());
            target.setUser(u);
        }

        return target;
    }
}
