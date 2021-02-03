package com.company.carservices.repository;

import com.company.carservices.entity.Car;
import com.company.carservices.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Integer> {
    @Query("SELECT c FROM Car c WHERE c.user.id = :userId")
    List<Car> findByUserId(@Param("userId") int userId);
}
