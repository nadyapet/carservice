package com.company.carservices.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ServiceServiceType")
public class ServiceServiceType extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "Fk_ServiceType_Id")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "Fk_Service_Id")
    private Service service;

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
