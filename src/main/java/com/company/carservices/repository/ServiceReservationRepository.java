package com.company.carservices.repository;
import com.company.carservices.entity.ServiceReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceReservationRepository extends CrudRepository<ServiceReservation, Integer> {

    @Query("SELECT r FROM ServiceReservation r WHERE r.service.id = :serviceId")
    List<ServiceReservation> findByServiceId(@Param("serviceId") int serviceId);
}
