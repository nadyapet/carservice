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
@Table(name = "ServiceType")
public class ServiceType extends CodeEntity {

    @OneToMany(mappedBy = "serviceType")
    @JsonIgnoreProperties("serviceType")
    private List<ServiceServiceType> services;


    @OneToMany(mappedBy = "serviceType")
    @JsonIgnoreProperties("serviceType")
    private List<CarServiceHistory> carServiceHistoryList;
}
