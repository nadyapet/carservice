package com.company.carservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Manufacturer")
public class Manufacturer extends CodeEntity  {

    @OneToMany(mappedBy = "manufacturer")
    @JsonIgnoreProperties("manufacturer")
    private List<Car> cars;

    @OneToMany(mappedBy = "manufacturer")
    @JsonIgnoreProperties("manufacturer")
    private List<ServiceManufacturer> services;
}
