package com.example.demo.service;



import com.example.demo.models.PivotMachine;

import java.util.List;

public interface PivotMachineService {

    List<PivotMachine> getAll();

    PivotMachine getById(Long id);

    PivotMachine add(PivotMachine pivotMachine);

    PivotMachine update(Long id, PivotMachine pivotMachine);

    Long delete(Long id);
}
