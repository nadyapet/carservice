package com.company.carservices.service;

import com.company.carservices.dto.CodeDto;

import java.util.List;

public interface CodeBaseService {
    List<CodeDto> getList();
    CodeDto save(CodeDto codeDto);
    void delete(int id);
}
