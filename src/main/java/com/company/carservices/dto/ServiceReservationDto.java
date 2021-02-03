package com.company.carservices.dto;

import com.company.carservices.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

public class ServiceReservationDto {
    private int id;
    private CodeDto car;
    private CodeDto service;
    private LocalDateTime orderDate;
    private LocalDateTime serviceDate;
    private String remark;

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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDateTime serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
