package com.mundiapolis.salary.web;

import com.mundiapolis.salary.dto.SalaryDTO;
import com.mundiapolis.salary.dto.SalaryReq;
import com.mundiapolis.salary.Service.SalaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping
    public ResponseEntity<List<SalaryDTO>> getAllSalaries() {
        return ResponseEntity.ok(salaryService.getAllSalaries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaryDTO> getSalaryById(@PathVariable Long id) {
        return ResponseEntity.ok(salaryService.getSalaryById(id));
    }

    @PostMapping
    public ResponseEntity<SalaryDTO> addSalary(@RequestBody SalaryReq salaryReq) {
        return ResponseEntity.ok(salaryService.addSalary(salaryReq));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaryDTO> updateSalary(@PathVariable Long id, @RequestBody SalaryReq salaryReq) {
        return ResponseEntity.ok(salaryService.updateSalary(id, salaryReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
        return ResponseEntity.noContent().build();
    }
}
