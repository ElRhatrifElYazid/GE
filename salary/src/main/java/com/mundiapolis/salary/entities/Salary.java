package com.mundiapolis.salary.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "date_versement")
    private LocalDate dateVersement;
}
