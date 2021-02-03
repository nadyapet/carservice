package com.company.carservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Service")
public class Service extends CodeEntity {

    @OneToMany(mappedBy = "service")
    @JsonIgnoreProperties("service")
    private List<ServiceManufacturer> carManufacturers;

    @OneToMany(mappedBy = "service")
    @JsonIgnoreProperties("service")
    private List<ServiceServiceType> serviceTypes;

    @OneToMany(mappedBy = "service")
    @JsonIgnoreProperties("service")
    private List<ServiceReservation> reservations;

    public List<ServiceManufacturer> getCarManufacturers() {
        return carManufacturers;
    }

    public void addManufacturer(Manufacturer manufacturer){
        ServiceManufacturer p = new ServiceManufacturer();
        p.setManufacturer(manufacturer);
        p.setService(this);
        carManufacturers.add(p);
    }

    public List<ServiceServiceType> getServiceTypes() {
        return serviceTypes;
    }

    public void addServiceType(ServiceType serviceType){
        ServiceServiceType p = new ServiceServiceType();
        p.setServiceType(serviceType);
        p.setService(this);
        serviceTypes.add(p);
    }
}
