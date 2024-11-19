package com.mundiapolis.employee.service;

import com.mundiapolis.employee.dto.EmployeeDTO;
import com.mundiapolis.employee.dto.EmployeeReq;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    List<EmployeeDTO> getEmployeesByDepartmentId(Long departmentId);

    EmployeeDTO addEmployee(EmployeeReq employeeReq);

    EmployeeDTO updateEmployee(Long id, EmployeeReq employeeReq);

    void deleteEmployee(Long id);
}
