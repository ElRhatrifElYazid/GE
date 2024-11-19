package com.mundiapolis.employee.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String poste;

    @Column(name = "department_id")
    private Long departmentId; // Reference to Department
}
