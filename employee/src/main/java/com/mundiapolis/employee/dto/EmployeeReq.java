package com.mundiapolis.employee.dto;

import lombok.Data;

@Data
public class EmployeeReq {
    private String nom;
    private String prenom;
    private String poste;
    private Long departmentId;
}
