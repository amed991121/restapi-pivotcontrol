package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "sector_control")
public class SectorControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "sector_id")
    private Long sector_id;
    @Column(name = "irrigate_state")
    private Boolean irrigateState;
    @Column(name = "dosage")
    private Long dosage;
    @Column(name = "motor_velocity")
    private Long motorVelocity;

}
