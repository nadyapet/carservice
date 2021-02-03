package com.company.carservices.controller;


import com.company.carservices.dto.CodeDto;
import com.company.carservices.dto.ServiceReservationDto;
import com.company.carservices.service.ManufacturerService;
import com.company.carservices.service.ServiceReservationService;
import com.company.carservices.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value="/services")
public class ServiceController {
    @Autowired
    private ServiceService codeService;
    private ServiceReservationService serviceReservationService;

    @GetMapping(value="/")
    public Iterable<CodeDto> getAll() {
        return codeService.getList();
    }

    @PostMapping(value="/")
    public CodeDto add(@RequestBody CodeDto dto)
    {
        CodeDto saved = codeService.save(dto);
        return saved;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        codeService.delete(id);
    }


    @PostMapping(value="/{id}/reservations")
    public ServiceReservationDto addReservation(@PathVariable int id, @RequestBody ServiceReservationDto reservation)
    {
        return serviceReservationService.save(reservation);
    }

    @DeleteMapping(value="/{id}/reservations/{entryId}")
    public void addCarServiceHistory(@PathVariable int id, @PathVariable int entryId)
    {
        serviceReservationService.delete(entryId);
    }
}

