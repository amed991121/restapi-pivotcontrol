package com.example.demo.repository;

import com.example.demo.models.Climate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimateRepository extends JpaRepository<Climate, Long> {

    @Query("SELECT c FROM Climate c WHERE c.id_pivot = :id_pivot")
    Climate findByIdPivot(@Param("id_pivot") Long id_pivot);
}
