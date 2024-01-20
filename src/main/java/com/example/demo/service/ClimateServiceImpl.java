package com.example.demo.service;

import com.example.demo.models.Climate;
import com.example.demo.repository.ClimateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClimateServiceImpl implements ClimateService {

    @Autowired
    private ClimateRepository climateRepository;

    @Override
    public List<Climate> getAll() {
        return climateRepository.findAll();
    }

    @Override
    public Climate getByIdPivot(Long id) {
        return climateRepository.findByIdPivot(id);
    }

    @Override
    public Climate add(Climate climate) {
        return climateRepository.save(climate);
    }

    @Override
    public Climate update(Long id, Climate climate) {
        Optional<Climate> climateOptional =
                climateRepository.findById(id);
        if (climateOptional.isPresent()) {
            climateOptional.get().setId_pivot(climate.getId_pivot());
            climateOptional.get().setReferenceEvapo(climate.getReferenceEvapo());
            climateOptional.get().setCropEvapo(climate.getCropEvapo());
            climateOptional.get().setCropCoefficient(climate.getCropCoefficient());
            climateOptional.get().setSolarRadiation(climate.getSolarRadiation());
            climateOptional.get().setWindSpeed(climate.getWindSpeed());
            climateOptional.get().setAtmoPressure(climate.getAtmoPressure());
            climateOptional.get().setRainy(climate.getRainy());
            climateOptional.get().setTemp(climate.getTemp());
            climateOptional.get().setRH(climate.getRH());
            return climateRepository.save(climateOptional.get());
        }
        throw new RuntimeException();
    }

    @Override
    public void delete(Long id) {
        delete(id);
    }
}
