package com.mundiapolis.department.Service;

import com.mundiapolis.department.dto.DepartmentDTO;
import com.mundiapolis.department.dto.DepartmentReq;
import com.mundiapolis.department.entities.Department;
import com.mundiapolis.department.mappers.DepartmentMapper;
import com.mundiapolis.department.Repository.DepartmentRepository;
import com.mundiapolis.department.Service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return departmentMapper.toDTO(department);
    }

    @Override
    public DepartmentDTO addDepartment(DepartmentReq departmentReq) {
        Department department = new Department();
        department.setNom(departmentReq.getNom());
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDTO(savedDepartment);
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentReq departmentReq) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        existingDepartment.setNom(departmentReq.getNom());
        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return departmentMapper.toDTO(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
