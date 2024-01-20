package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "pivot_machines")
public class PivotMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "endowment")
    private Double endowment;
    @Column(name = "flow")
    private Double flow;
    @Column(name = "pressure")
    private Double pressure;
    @Column(name = "length")
    private Double length;
    @Column(name = "area")
    private Double area;
    @Column(name = "power")
    private Double power;
    @Column(name = "speed")
    private Double speed;
    @Column(name = "efficiency")
    private Double efficiency;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pivot_control_id")
    private PivotControl pivotControl;

    public PivotMachine() {
        PivotControl pivotControlOptional = new PivotControl();
        pivotControlOptional.setId_pivot(getId());
        pivotControlOptional.setProgress(0F);
        pivotControlOptional.setIsRunning(false);
        pivotControlOptional.setStateBomb(false);
        pivotControlOptional.setWayToPump(false);
        pivotControlOptional.setTurnSense(false);
        this.pivotControl = pivotControlOptional;

    }
}