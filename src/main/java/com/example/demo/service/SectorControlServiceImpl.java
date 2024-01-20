package com.example.demo.service;

import com.example.demo.models.SectorControl;
import com.example.demo.repository.SectorControlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SectorControlServiceImpl implements SectorControlService {
    @Autowired
    private SectorControlRepository sectorControlRepository;

    @Override
    public List<SectorControl> getAll() {
        return sectorControlRepository.findAll();
    }

    @Override
    public SectorControl getByIdSector(Long id) {
        return sectorControlRepository.findByIdSector(id);
    }

    @Override
    public SectorControl add(SectorControl sectorControl) {
        return sectorControlRepository.save(sectorControl);
    }

    @Override
    public SectorControl update(Long id, SectorControl sectorControl) {
        Optional<SectorControl> sectorControlOptional =
                sectorControlRepository.findById(id);
        if (sectorControlOptional.isPresent()) {
            sectorControlOptional.get().setSector_id(sectorControl.getSector_id());
            sectorControlOptional.get().setIrrigateState(sectorControl.getIrrigateState());
            sectorControlOptional.get().setDosage(sectorControl.getDosage());
            sectorControlOptional.get().setMotorVelocity(sectorControl.getMotorVelocity());
            return sectorControlRepository.save(sectorControlOptional.get());
        }
        throw new RuntimeException();
    }

    @Override
    public void delete(Long id) {
        delete(id);
    }
}
