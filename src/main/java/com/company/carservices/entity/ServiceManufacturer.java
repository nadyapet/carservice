package com.company.carservices.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
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
@Table(name = "ServiceManufacturer")
public class ServiceManufacturer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "Fk_Manufacturer_Id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "Fk_Service_Id")
    private Service service;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
