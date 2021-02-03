package com.company.carservices.dto;


import com.company.carservices.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

public class CarServiceHistoryDto {
    private int id;
    private CodeDto car;
    private CodeDto service;
    private CodeDto serviceType;
    private BigDecimal price;

    public CodeDto getCar() {
        return car;
    }

    public void setCar(CodeDto car) {
        this.car = car;
    }

    public CodeDto getService() {
        return service;
    }

    public void setService(CodeDto service) {
        this.service = service;
    }

    public CodeDto getServiceType() {
        return serviceType;
    }

    public void setServiceType(CodeDto serviceType) {
        this.serviceType = serviceType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
