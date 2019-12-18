package com.example.curency.controllers;

import com.example.curency.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/add")
public class CurrencyController {

    private BoardService boardService;

    public CurrencyController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public void addToDatabase() {
        boardService.addToDatebase();
    }
}
