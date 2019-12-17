package com.example.curency.controllers;

import com.example.curency.controllers.dtos.BoardDTO;
import com.example.curency.domain.Board;
import com.example.curency.repositories.BoardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/add")
public class CurrencyController {

    private BoardRepository boardRepository;

    public CurrencyController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping
    public void addToDatabase() {
        String URL = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";


        RestTemplate restTemplate = new RestTemplate();
        BoardDTO[] forObject = restTemplate.getForObject(URL, BoardDTO[].class);
        BoardDTO boardDTO = forObject[0];
        Board board = new Board();
        board.setEffectiveDate(boardDTO.getEffectiveDate());
        board.setNo(boardDTO.getNo());
        board.setTable(boardDTO.getTable());


        board.setNo(boardDTO.getNo() + LocalDate.now());

        boardRepository.save(board);


    }
}
