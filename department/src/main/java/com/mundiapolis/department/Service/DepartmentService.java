package com.mundiapolis.department.Service;

import com.mundiapolis.department.dto.DepartmentDTO;
import com.mundiapolis.department.dto.DepartmentReq;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartmentById(Long id);

    DepartmentDTO addDepartment(DepartmentReq departmentReq);

    DepartmentDTO updateDepartment(Long id, DepartmentReq departmentReq);

    void deleteDepartment(Long id);
}
