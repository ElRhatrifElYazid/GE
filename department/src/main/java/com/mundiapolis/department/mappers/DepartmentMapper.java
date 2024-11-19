package com.mundiapolis.department.mappers;

import com.mundiapolis.department.dto.DepartmentDTO;
import com.mundiapolis.department.entities.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
    public DepartmentDTO toDTO(Department department) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(department.getId());
        dto.setNom(department.getNom());
        return dto;
    }

    public Department fromDTO(DepartmentDTO dto) {
        Department department = new Department();
        department.setId(dto.getId());
        department.setNom(dto.getNom());
        return department;
    }
}
