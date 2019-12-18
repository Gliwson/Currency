package com.example.curency.service.implementation;

import com.example.curency.controllers.dtos.BoardDTO;
import com.example.curency.domain.Board;
import com.example.curency.repositories.BoardRepository;
import com.example.curency.service.BoardService;
import com.example.curency.service.mappers.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void addToDatebase(String table) {
        String URL = "http://api.nbp.pl/api/exchangerates/tables/" + table + "?format=json";
        RestTemplate restTemplate = new RestTemplate();
        BoardDTO[] restTemplateForObject = restTemplate.getForObject(URL, BoardDTO[].class);
        BoardDTO boardDTO;
        if (restTemplateForObject != null) {
            boardDTO = restTemplateForObject[0];
        } else {
            throw new NullPointerException();
        }
        Board board = BoardMapper.mapDtoToBoardAndRates(boardDTO);
        boardRepository.save(board);
    }
}
