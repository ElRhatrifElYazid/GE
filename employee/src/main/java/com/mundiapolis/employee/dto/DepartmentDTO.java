package com.mundiapolis.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDTO {
    private Long id;
    private String nom; // Department name
    private List<EmployeeDTO> employees; // List of employee IDs
}
