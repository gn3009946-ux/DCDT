package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}