package com.company.carservices.service.implementations;

import com.company.carservices.dto.CarDto;
import com.company.carservices.dto.CodeDto;
import com.company.carservices.entity.Car;
import com.company.carservices.entity.CodeEntity;
import com.company.carservices.entity.Manufacturer;
import com.company.carservices.repository.CarRepository;
import com.company.carservices.repository.ManufacturerRepository;
import com.company.carservices.service.CarService;
import com.company.carservices.service.ManufacturerService;
import com.company.carservices.service.mapper.CarMapper;
import com.company.carservices.service.mapper.CodeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {
    private ManufacturerRepository entityRepository;
    private CodeMapper<Manufacturer> codeMapper;

    @Override
    public List<CodeDto> getList() {
        ArrayList<CodeDto> list = new ArrayList<CodeDto>();
        for (CodeEntity codeEntity : entityRepository.findAll()) {
            list.add(codeMapper.MapToDto(codeEntity));
        }

        return list;
    }

    @Override
    public CodeDto save(CodeDto codeDto) {
        Optional<Manufacturer> existingEntity = null;
        if (codeDto.getId() > 0){
            existingEntity = entityRepository.findById(codeDto.getId());
        }

        Manufacturer codeEntity = existingEntity != null && existingEntity.isPresent() ? existingEntity.get() : new Manufacturer();
        codeMapper.MapFromDto(codeDto, codeEntity);
        Manufacturer saved = entityRepository.save(codeEntity);
        codeDto.setId(saved.getId());
        return codeDto;
    }

    @Override
    public void delete(int id) {
        entityRepository.deleteById(id);
    }
}
