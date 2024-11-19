package com.mundiapolis.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaryDTO {
    private Long id;
    private Double amount;
    private Long employeeId;
    private LocalDate dateVersement;
}
