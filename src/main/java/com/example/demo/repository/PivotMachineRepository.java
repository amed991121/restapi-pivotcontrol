package com.example.demo.repository;

import com.example.demo.models.PivotMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PivotMachineRepository extends JpaRepository<PivotMachine, Long> {
}
