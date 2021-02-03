package com.company.carservices.service.mapper;

import com.company.carservices.dto.CarDto;
import com.company.carservices.dto.CodeDto;
import com.company.carservices.entity.CodeEntity;

public interface CodeMapper<T extends CodeEntity> {
    CodeDto MapToDto(CodeEntity source);
    void MapFromDto(CodeDto source, T target);
}
