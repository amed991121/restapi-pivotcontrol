package com.example.demo.controllers;

import com.example.demo.models.PivotMachine;
import com.example.demo.service.PivotMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pivot-control")
public class PivotMachineController {

    @Autowired
    private PivotMachineService pivotMachineService;

    @GetMapping(value = "/machines")
    @ResponseStatus(HttpStatus.OK)
    public List<PivotMachine> getAll() {
        return pivotMachineService.getAll();
    }

    @GetMapping(value = "/machines/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PivotMachine getById(@PathVariable Long id) {
        return pivotMachineService.getById(id);
    }

    @PostMapping(value = "/machines", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PivotMachine add(@RequestBody PivotMachine pivotMachine) {
        return pivotMachineService.add(pivotMachine);
    }

    @PutMapping(value = "/machines/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public PivotMachine update(@PathVariable Long id, @RequestBody PivotMachine pivotMachine) {
        return pivotMachineService.update(id, pivotMachine);
    }

    @DeleteMapping(value = "/machines/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Long> delete(@PathVariable Long id) {

        try {
            return new ResponseEntity<>(pivotMachineService.delete(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
