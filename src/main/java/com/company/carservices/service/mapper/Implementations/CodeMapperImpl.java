package com.company.carservices.service.mapper.Implementations;

import com.company.carservices.dto.CodeDto;
import com.company.carservices.entity.CodeEntity;
import com.company.carservices.service.mapper.CodeMapper;
import org.springframework.stereotype.Component;

@Component
public class CodeMapperImpl<T extends CodeEntity> implements CodeMapper<T> {

    @Override
    public CodeDto MapToDto(CodeEntity source) {
        CodeDto dto = new CodeDto();
        dto.setId(source.getId());
        dto.setCode(source.getCode());
        return dto;
    }

    @Override
    public void MapFromDto(CodeDto source, T target) {
        target.setCode(source.getCode());
    }
}
