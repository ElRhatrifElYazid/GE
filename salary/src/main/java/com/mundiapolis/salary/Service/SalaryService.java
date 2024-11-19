package com.mundiapolis.salary.Service;

import com.mundiapolis.salary.dto.SalaryDTO;
import com.mundiapolis.salary.dto.SalaryReq;

import java.util.List;

public interface SalaryService {
    List<SalaryDTO> getAllSalaries();

    SalaryDTO getSalaryById(Long id);

    List<SalaryDTO> getSalariesByEmployeeId(Long employeeId);

    SalaryDTO addSalary(SalaryReq salaryReq);

    SalaryDTO updateSalary(Long id, SalaryReq salaryReq);

    void deleteSalary(Long id);
}
