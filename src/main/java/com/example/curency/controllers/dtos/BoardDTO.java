package com.example.curency.controllers.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BoardDTO {

    private String table;
    private String no;
    private LocalDate effectiveDate;
    private List<RatesDTO> rates;

    public BoardDTO(String table, String no, LocalDate effectiveDate, List<RatesDTO> rates) {
        this.table = table;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }
}
