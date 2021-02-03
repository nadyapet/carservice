package com.company.carservices.controller;


import com.company.carservices.controller.security.UserContext;
import com.company.carservices.dto.CarDto;
import com.company.carservices.dto.CodeDto;
import com.company.carservices.entity.Manufacturer;
import com.company.carservices.repository.ManufacturerRepository;
import com.company.carservices.service.CarService;
import com.company.carservices.service.ManufacturerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value="/manufacturers")
public class ManufacturerController {
    @Autowired
    private ManufacturerService codeService;

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
}

