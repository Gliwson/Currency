package com.example.curency.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tables")
    private String table;
    private String no;
    private LocalDate effectiveDate;
    @OneToMany
    private List<Rates> rates;

}
