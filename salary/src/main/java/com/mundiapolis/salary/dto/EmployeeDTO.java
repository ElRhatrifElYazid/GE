package com.mundiapolis.salary.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
    private String poste;

}
