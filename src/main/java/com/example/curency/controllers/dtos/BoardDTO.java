package com.example.curency.controllers.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BoardDTO {

    private String table;
    private String no;
    private String effectiveDate;
    private List<RatesDTO> rates;

}
