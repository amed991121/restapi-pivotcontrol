package com.example.demo.service;



import com.example.demo.models.SectorControl;

import java.util.List;

public interface SectorControlService {

    List<SectorControl> getAll();

    SectorControl getByIdSector(Long id);

    SectorControl add(SectorControl sectorControl);

    SectorControl update(Long id, SectorControl sectorControl);

    void delete(Long id);
}
