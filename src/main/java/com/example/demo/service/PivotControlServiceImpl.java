package com.example.demo.service;

import com.example.demo.models.PivotControl;
import com.example.demo.repository.PivotControlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PivotControlServiceImpl implements PivotControlService {

    @Autowired
    private PivotControlRepository pivotControlRepository;

    @Override
    public List<PivotControl> getAll() {
        return pivotControlRepository.findAll();
    }

    @Override
    public PivotControl getByIdPivot(Long id) {
        return pivotControlRepository.findByIdPivot(id);
    }

    @Override
    public PivotControl add(PivotControl pivotControl) {
        return pivotControlRepository.save(pivotControl);
    }

    @Override
    public PivotControl update(Long id, PivotControl pivotControl) {
        Optional<PivotControl> pivotControlOptional =
                pivotControlRepository.findById(id);
        if (pivotControlOptional.isPresent()) {
            pivotControlOptional.get().setId_pivot(pivotControl.getId_pivot());
            pivotControlOptional.get().setProgress(pivotControl.getProgress());
            pivotControlOptional.get().setIsRunning(pivotControl.getIsRunning());
            pivotControlOptional.get().setStateBomb(pivotControl.getStateBomb());
            pivotControlOptional.get().setWayToPump(pivotControl.getWayToPump());
            pivotControlOptional.get().setTurnSense(pivotControl.getTurnSense());
            return pivotControlRepository.save(pivotControlOptional.get());
        }
        throw new RuntimeException();
    }

    @Override
    public void delete(Long id) {
        delete(id);
    }
}
