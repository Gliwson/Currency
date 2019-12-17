package com.example.curency.controllers.dtos;

import lombok.Data;

@Data
public class RatesDTO {

    private String currency;
    private String code;
    private String mid;

    public RatesDTO(String currency, String code, String mid) {
        this.currency = currency;
        this.code = code;
        this.mid = mid;
    }
}
