package com.example.demo.service;

import com.example.demo.models.PivotControl;
import com.example.demo.models.PivotMachine;
import com.example.demo.repository.PivotControlRepository;
import com.example.demo.repository.PivotMachineRepository;
import com.example.demo.repository.SectorControlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class PivotMachineServiceImpl implements PivotMachineService {

    @Autowired
    private PivotMachineRepository pivotMachineRepository;

    @Override
    public List<PivotMachine> getAll() {
        return pivotMachineRepository.findAll();
    }

    @Override
    public PivotMachine getById(Long id) {
        return pivotMachineRepository.findById(id).get();
    }

    @Override
    public PivotMachine add(PivotMachine pivotMachine) {
        return pivotMachineRepository.save(pivotMachine);
    }

    @Override
    public PivotMachine update(Long id, PivotMachine pivotMachine) {
        Optional<PivotMachine> pivotMachineOptional =
                pivotMachineRepository.findById(id);
        if (pivotMachineOptional.isPresent()) {
            pivotMachineOptional.get().setName(pivotMachine.getName());
            pivotMachineOptional.get().setLocation(pivotMachine.getLocation());
            pivotMachineOptional.get().setEndowment(pivotMachine.getEndowment());
            pivotMachineOptional.get().setFlow(pivotMachine.getFlow());
            pivotMachineOptional.get().setPressure(pivotMachine.getPressure());
            pivotMachineOptional.get().setLength(pivotMachine.getLength());
            pivotMachineOptional.get().setArea(pivotMachine.getArea());
            pivotMachineOptional.get().setPower(pivotMachine.getPower());
            pivotMachineOptional.get().setSpeed(pivotMachine.getSpeed());
            pivotMachineOptional.get().setEfficiency(pivotMachine.getEfficiency());
            return pivotMachineRepository.save(pivotMachineOptional.get());
        }
        throw new RuntimeException();
    }

    @Override
    public Long delete(Long id) {

        if (pivotMachineRepository.existsById(id)) {
            pivotMachineRepository.deleteById(id);
            return id;
        }else {
            throw new NoSuchElementException("No se encontró ninguna entidad con el ID proporcionado");
        }

    }
}
