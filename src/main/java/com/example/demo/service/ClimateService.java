package com.example.demo.service;

import com.example.demo.models.Climate;

import java.util.List;

public interface ClimateService {

    List<Climate> getAll();

    Climate getByIdPivot(Long id);

    Climate add(Climate climate);
    Climate update(Long id, Climate climate);

    void delete(Long id);
}
