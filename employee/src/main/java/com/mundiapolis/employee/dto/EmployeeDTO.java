package com.mundiapolis.employee.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String poste;
    private Long departmentId;
}
