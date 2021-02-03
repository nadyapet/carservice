package com.company.carservices.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CarServiceHistory")
public class CarServiceHistory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "Fk_Car_Id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "Fk_Service_Id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "Fk_ServiceType_Id")
    private ServiceType serviceType;

    private BigDecimal price;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
