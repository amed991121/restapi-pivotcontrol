package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "pivot_control")
public class PivotControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "id_pivot")
    private Long id_pivot;
    @Column(name = "progress")
    private Float progress;
    @Column(name = "is_running")
    private Boolean isRunning;
    @Column(name = "state_bomb")
    private Boolean stateBomb;
    @Column(name = "way_to_pump")
    private Boolean wayToPump;
    @Column(name = "turn_sense")
    private Boolean turnSense;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sector_control_id")
    private List<SectorControl> sectorControlList = new ArrayList<>();

    public PivotControl() {
        for (int i = 0; i < 4; i++) {
            SectorControl sectorControl = new SectorControl();
            sectorControl.setSector_id((long) i + 1);
            sectorControl.setIrrigateState(true);
            sectorControl.setDosage(0L);
            sectorControl.setMotorVelocity(0L);
            this.sectorControlList.add(sectorControl);
        }
    }

}