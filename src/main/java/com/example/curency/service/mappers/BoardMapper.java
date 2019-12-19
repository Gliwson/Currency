package com.example.curency.service.mappers;

import com.example.curency.controllers.dtos.BoardDTO;
import com.example.curency.controllers.dtos.RatesDTO;
import com.example.curency.domain.Board;
import com.example.curency.domain.Rates;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BoardMapper {


    public static Board mapDtoToBoardAndRates(BoardDTO boardDTO) {
        List<Rates> ratesList = new ArrayList<>();
        Rates rates = new Rates();
        Board board = new Board();
        RatesDTO ratesDTO = boardDTO.getRates().get(0);
        board.setEffectiveDate(boardDTO.getEffectiveDate());
        board.setNo(boardDTO.getNo());
        board.setTable(boardDTO.getTable());
        board.setNo(boardDTO.getNo() + LocalDate.now());
        rates.setBoard(board);
        rates.setCode(ratesDTO.getCode());
        rates.setCurrency(ratesDTO.getCurrency());
        rates.setMid(ratesDTO.getMid());
        ratesList.add(rates);
        board.setRates(ratesList);
        return board;
    }
}
