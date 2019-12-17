package com.example.curency.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String currency;
    private String code;
    private String mid;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "board_id")
    private Board board;

}
