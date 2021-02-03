package com.company.carservices.service.implementations;

import com.company.carservices.dto.CodeDto;
import com.company.carservices.entity.CodeEntity;
import com.company.carservices.entity.Manufacturer;
import com.company.carservices.entity.ServiceType;
import com.company.carservices.repository.ManufacturerRepository;
import com.company.carservices.repository.ServiceTypeRepository;
import com.company.carservices.service.ManufacturerService;
import com.company.carservices.service.ServiceTypeService;
import com.company.carservices.service.mapper.CodeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceTypeServiceImpl implements ServiceTypeService {
    private ServiceTypeRepository entityRepository;
    private CodeMapper<ServiceType> codeMapper;

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
        Optional<ServiceType> existingEntity = null;
        if (codeDto.getId() > 0){
            existingEntity = entityRepository.findById(codeDto.getId());
        }

        ServiceType codeEntity = existingEntity != null && existingEntity.isPresent() ? existingEntity.get() : new ServiceType();
        codeMapper.MapFromDto(codeDto, codeEntity);
        ServiceType saved = entityRepository.save(codeEntity);
        codeDto.setId(saved.getId());
        return codeDto;
    }

    @Override
    public void delete(int id) {
        entityRepository.deleteById(id);
    }
}
