package com.mundiapolis.employee.web;

import com.mundiapolis.employee.dto.EmployeeDTO;
import com.mundiapolis.employee.dto.EmployeeReq;
import com.mundiapolis.employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/byDepartmentId/{departmentId}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDepartmentId(@PathVariable Long departmentId) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartmentId(departmentId));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeReq employeeReq) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeReq));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeReq employeeReq) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
