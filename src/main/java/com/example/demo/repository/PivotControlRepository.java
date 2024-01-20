package com.example.demo.repository;


import com.example.demo.models.PivotControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PivotControlRepository extends JpaRepository<PivotControl, Long> {

    @Query("SELECT p FROM PivotControl p WHERE p.id_pivot = :id_pivot")
    PivotControl findByIdPivot(@Param("id_pivot") Long id_pivot);

}
