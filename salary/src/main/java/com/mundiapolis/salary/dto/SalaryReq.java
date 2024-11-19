package com.mundiapolis.salary.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SalaryReq {
    private Double amount;
    private Long employeeId;
    private LocalDate dateVersement;
}
