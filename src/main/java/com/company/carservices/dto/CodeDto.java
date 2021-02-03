package com.company.carservices.dto;

import com.company.carservices.entity.BaseEntity;
import com.company.carservices.entity.CodeEntity;
import com.company.carservices.entity.IdCodeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

public class CodeDto {
    private int id;
    private String code;

    public CodeDto(){ }

    public CodeDto(int id, String code){
        this.id = id;
        this.code = code;
    }

    public CodeDto(IdCodeEntity idCodeEntity){
        this.id = idCodeEntity.getId();
        this.code = idCodeEntity.getCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
