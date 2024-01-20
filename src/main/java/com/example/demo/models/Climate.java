package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "climatic_var")
public class Climate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "id_pivot")
    private Long id_pivot;
    @Column(name = "reference_evapo")
    private Double referenceEvapo;
    @Column(name = "crop_evapo")
    private Double cropEvapo;
    @Column(name = "crop_coefficient")
    private Double cropCoefficient;
    @Column(name = "solar_radiation")
    private Long solarRadiation;
    @Column(name = "wind_speed")
    private Double windSpeed;
    @Column(name = "atmo_pressure")
    private Double atmoPressure;
    @Column(name = "rainy")
    private Long rainy;
    @Column(name = "temp")
    private Double temp;
    @Column(name = "RH")
    private Double RH;
    @Column(name = "time_stamp")
    private String timestamp;

    public Climate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        this.timestamp = localDateTime.format(formatter);
    }

}