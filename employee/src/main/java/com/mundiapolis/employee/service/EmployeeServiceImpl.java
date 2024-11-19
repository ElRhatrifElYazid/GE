package com.mundiapolis.employee.service;

import com.mundiapolis.employee.dto.EmployeeDTO;
import com.mundiapolis.employee.dto.EmployeeReq;
import com.mundiapolis.employee.entities.Employee;
import com.mundiapolis.employee.mappers.EmployeeMapper;
import com.mundiapolis.employee.repository.EmployeeRepository;
import com.mundiapolis.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return employeeMapper.toDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getEmployeesByDepartmentId(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId)
                .stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeReq employeeReq) {
        Employee employee = new Employee();
        employee.setNom(employeeReq.getNom());
        employee.setPrenom(employeeReq.getPrenom());
        employee.setPoste(employeeReq.getPoste());
        employee.setDepartmentId(employeeReq.getDepartmentId());
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeReq employeeReq) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existingEmployee.setNom(employeeReq.getNom());
        existingEmployee.setPrenom(employeeReq.getPrenom());
        existingEmployee.setPoste(employeeReq.getPoste());
        existingEmployee.setDepartmentId(employeeReq.getDepartmentId());
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.toDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
