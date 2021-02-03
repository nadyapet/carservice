package com.company.carservices.repository;
import com.company.carservices.entity.Manufacturer;
import com.company.carservices.entity.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Integer> {
}
