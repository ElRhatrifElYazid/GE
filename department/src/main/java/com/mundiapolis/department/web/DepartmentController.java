package com.mundiapolis.department.web;

import com.mundiapolis.department.dto.DepartmentDTO;
import com.mundiapolis.department.dto.DepartmentReq;
import com.mundiapolis.department.Service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentReq departmentReq) {
        return ResponseEntity.ok(departmentService.addDepartment(departmentReq));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable Long id, @RequestBody DepartmentReq departmentReq) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, departmentReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
