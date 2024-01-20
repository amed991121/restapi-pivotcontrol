package com.example.demo.service;



import com.example.demo.models.PivotControl;

import java.util.List;

public interface PivotControlService {

    List<PivotControl> getAll();

    PivotControl getByIdPivot(Long id);

    PivotControl add(PivotControl pivotControl);

    PivotControl update(Long id, PivotControl pivotControl);

    void delete(Long id);
}
