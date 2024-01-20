package com.example.demo.controllers;

import com.example.demo.models.Climate;
import com.example.demo.service.ClimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pivot-control")
public class ClimateController {

    @Autowired
    private ClimateService climateService;

    @GetMapping(value = "/climate")
    @ResponseStatus(HttpStatus.OK)
    public List<Climate> getAll() {
        return climateService.getAll();
    }


    @GetMapping(value = "/climate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Climate getByIdPivot(@PathVariable Long id) {
        return climateService.getByIdPivot(id);
    }

    @PostMapping(value = "/climate")
    @ResponseStatus(HttpStatus.CREATED)
    public Climate add(@RequestBody Climate climate) {
        return climateService.add(climate);
    }

    @PutMapping(value = "/climate/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Climate update(@PathVariable Long id, @RequestBody Climate climate) {
        return climateService.update(id, climate);
    }

    @DeleteMapping(value = "/climate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        climateService.delete(id);
    }

}
