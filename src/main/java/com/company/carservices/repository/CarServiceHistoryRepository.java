package com.company.carservices.repository;
import com.company.carservices.entity.CarServiceHistory;
import com.company.carservices.entity.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface CarServiceHistoryRepository extends CrudRepository<CarServiceHistory, Integer> {
}
