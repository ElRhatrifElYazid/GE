package com.mundiapolis.employee.mappers;

import com.mundiapolis.employee.dto.EmployeeDTO;
import com.mundiapolis.employee.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setNom(employee.getNom());
        dto.setPrenom(employee.getPrenom());
        dto.setPoste(employee.getPoste());
        dto.setDepartmentId(employee.getDepartmentId());
        return dto;
    }

    public Employee fromDTO(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setNom(dto.getNom());
        employee.setPrenom(dto.getPrenom());
        employee.setPoste(dto.getPoste());
        employee.setDepartmentId(dto.getDepartmentId());
        return employee;
    }
}
