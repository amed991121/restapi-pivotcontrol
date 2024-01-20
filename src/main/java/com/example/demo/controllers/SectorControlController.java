package com.example.demo.controllers;

import com.example.demo.models.SectorControl;
import com.example.demo.service.SectorControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pivot-control")
public class SectorControlController {

    @Autowired
    private SectorControlService sectorControlService;

    @GetMapping(value = "/sector")
    @ResponseStatus(HttpStatus.OK)
    public List<SectorControl> getAll() {
        return sectorControlService.getAll();
    }

    @GetMapping(value = "/sector/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SectorControl getByIdSector(@PathVariable Long id) {
        return sectorControlService.getByIdSector(id);
    }

    @PostMapping(value = "/sector")
    @ResponseStatus(HttpStatus.CREATED)
    public SectorControl add(@RequestBody SectorControl sectorControl) {
        return sectorControlService.add(sectorControl);
    }

    @PutMapping(value = "/sector/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public SectorControl update(@PathVariable Long id, @RequestBody SectorControl sec) {
        return sectorControlService.update(id, sec);
    }

    @DeleteMapping(value = "/sector/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        sectorControlService.delete(id);
    }
}
