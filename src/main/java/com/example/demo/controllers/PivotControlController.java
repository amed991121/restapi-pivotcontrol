package com.example.demo.controllers;

import com.example.demo.models.PivotControl;
import com.example.demo.service.PivotControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pivot-control")
public class PivotControlController {

    @Autowired
    private PivotControlService pivotControlService;

    @GetMapping(value = "/control")
    @ResponseStatus(HttpStatus.OK)
    public List<PivotControl> getAll() {
        return pivotControlService.getAll();
    }

    @GetMapping(value = "/control/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PivotControl getByIdPivot(@PathVariable Long id) {
        return pivotControlService.getByIdPivot(id);
    }

    @PostMapping(value = "/control")
    @ResponseStatus(HttpStatus.CREATED)
    public PivotControl add(@RequestBody PivotControl pivotControl) {
        return pivotControlService.add(pivotControl);
    }

    @PutMapping(value = "/control/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public PivotControl update(@PathVariable Long id, @RequestBody PivotControl pivotControl) {
        return pivotControlService.update(id, pivotControl);
    }

    @DeleteMapping(value = "/control/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        pivotControlService.delete(id);
    }

}

