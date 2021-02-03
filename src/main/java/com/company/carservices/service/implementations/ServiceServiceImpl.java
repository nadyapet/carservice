package com.company.carservices.service.implementations;

import com.company.carservices.dto.CodeDto;
import com.company.carservices.entity.CodeEntity;
import com.company.carservices.entity.Service;
import com.company.carservices.repository.ServiceRepository;
import com.company.carservices.service.ServiceService;
import com.company.carservices.service.mapper.CodeMapper;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private ServiceRepository entityRepository;
    private CodeMapper<Service> codeMapper;

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
        Optional<Service> existingEntity = null;
        if (codeDto.getId() > 0){
            existingEntity = entityRepository.findById(codeDto.getId());
        }

        Service codeEntity = existingEntity != null && existingEntity.isPresent() ? existingEntity.get() : new Service();
        codeMapper.MapFromDto(codeDto, codeEntity);
        Service saved = entityRepository.save(codeEntity);
        codeDto.setId(saved.getId());
        return codeDto;
    }

    @Override
    public void delete(int id) {
        entityRepository.deleteById(id);
    }
}
