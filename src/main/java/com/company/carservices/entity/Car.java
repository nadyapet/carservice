package com.company.carservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "Car")
public class Car extends BaseEntity implements IdCodeEntity {
    private String registrationNumber;

    @ManyToOne
    @JoinColumn(name = "Fk_Manufacturer_Id")
    private Manufacturer manufacturer;

    private String model;
    private int year;

    @ManyToOne
    @JoinColumn(name = "Fk_User_Id")
    private User user;

    @OneToMany(mappedBy = "car")
    @JsonIgnoreProperties("car")
    private List<CarServiceHistory> carServiceHistoryList;

    public List<CarServiceHistory> getHistory(){
        return carServiceHistoryList;
    }

    public void addServiceHistory(CarServiceHistory serviceHistory){
        serviceHistory.setCar(this);
        carServiceHistoryList.add(serviceHistory);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String getCode() {
        return registrationNumber;
    }
}
