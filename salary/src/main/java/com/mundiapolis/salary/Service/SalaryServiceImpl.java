package com.mundiapolis.salary.Service;

import com.mundiapolis.salary.dto.SalaryDTO;
import com.mundiapolis.salary.dto.SalaryReq;
import com.mundiapolis.salary.entities.Salary;
import com.mundiapolis.salary.mappers.SalaryMapper;
import com.mundiapolis.salary.Repository.SalaryRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository salaryRepository;
    private final SalaryMapper salaryMapper;

    public SalaryServiceImpl(SalaryRepository salaryRepository, SalaryMapper salaryMapper) {
        this.salaryRepository = salaryRepository;
        this.salaryMapper = salaryMapper;
    }

    @Override
    public List<SalaryDTO> getAllSalaries() {
        return salaryRepository.findAll()
                .stream()
                .map(salaryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SalaryDTO getSalaryById(Long id) {
        Salary salary = salaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salary not found"));
        return salaryMapper.toDTO(salary);
    }

    @Override
    public List<SalaryDTO> getSalariesByEmployeeId(Long employeeId) {
        return salaryRepository.findByEmployeeId(employeeId)
                .stream()
                .map(salaryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SalaryDTO addSalary(SalaryReq salaryReq) {
        Salary salary = salaryMapper.fromDTO(new SalaryDTO(null, salaryReq.getAmount(), salaryReq.getEmployeeId(), salaryReq.getDateVersement()));
        Salary savedSalary = salaryRepository.save(salary);
        return salaryMapper.toDTO(savedSalary);
    }

    @Override
    public SalaryDTO updateSalary(Long id, SalaryReq salaryReq) {
        Salary existingSalary = salaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salary not found"));
        existingSalary.setAmount(salaryReq.getAmount());
        existingSalary.setDateVersement(salaryReq.getDateVersement());
        existingSalary.setEmployeeId(salaryReq.getEmployeeId());
        Salary updatedSalary = salaryRepository.save(existingSalary);
        return salaryMapper.toDTO(updatedSalary);
    }

    @Override
    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }
}
