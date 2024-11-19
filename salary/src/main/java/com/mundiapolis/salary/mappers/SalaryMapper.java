package com.mundiapolis.salary.mappers;

import com.mundiapolis.salary.dto.SalaryDTO;
import com.mundiapolis.salary.entities.Salary;
import org.springframework.stereotype.Component;

@Component
public class SalaryMapper {
    public SalaryDTO toDTO(Salary salary) {
        SalaryDTO dto = new SalaryDTO();
        dto.setId(salary.getId());
        dto.setAmount(salary.getAmount());
        dto.setEmployeeId(salary.getEmployeeId());
        dto.setDateVersement(salary.getDateVersement());
        return dto;
    }

    public Salary fromDTO(SalaryDTO dto) {
        Salary salary = new Salary();
        salary.setId(dto.getId());
        salary.setAmount(dto.getAmount());
        salary.setEmployeeId(dto.getEmployeeId());
        salary.setDateVersement(dto.getDateVersement());
        return salary;
    }
}
