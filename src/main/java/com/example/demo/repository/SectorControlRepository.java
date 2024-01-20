package com.example.demo.repository;

import com.example.demo.models.SectorControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorControlRepository extends JpaRepository<SectorControl, Long> {

    @Query("SELECT s FROM SectorControl s WHERE s.sector_id = :sector_id")
    SectorControl findByIdSector(@Param("sector_id") Long sector_id);

}
