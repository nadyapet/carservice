package com.company.carservices.controller;


import com.company.carservices.controller.security.UserContext;
import com.company.carservices.dto.CarDto;
import com.company.carservices.dto.CarServiceHistoryDto;
import com.company.carservices.dto.CodeDto;
import com.company.carservices.service.CarService;
import com.company.carservices.service.CarServiceHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarServiceHistoryService carServiceHistoryService;
    private UserContext userContext;

    @GetMapping(value="/cars")
    public Iterable<CarDto> getCars() {
        return carService.getCars(userContext.getUserId());
    }

    @PostMapping(value="/cars")
    public CarDto addCar(@RequestBody CarDto car)
    {
        CodeDto userCodeDto = new CodeDto();
        userCodeDto.setId(userContext.getUserId());
        car.setUser(userCodeDto);
        return carService.save(car);
    }

    @GetMapping(value="/cars/{id}")
    public CarDto get(@PathVariable int id) { return carService.getById(id); }

    @DeleteMapping(value = "/cars/{id}")
    public void delete(@PathVariable int id) {
        carService.deleteCar(id);
    }

    @PostMapping(value="/cars/{id}/serviceHistory")
    public CarServiceHistoryDto addCarServiceHistory(@PathVariable int id, @RequestBody CarServiceHistoryDto serviceHistoryEntry)
    {
        return carServiceHistoryService.save(id, serviceHistoryEntry);
    }

    @DeleteMapping(value="/cars/{id}/serviceHistory/{entryId}")
    public void addCarServiceHistory(@PathVariable int id, @PathVariable int entryId)
    {
        carServiceHistoryService.delete(entryId);
    }
}

