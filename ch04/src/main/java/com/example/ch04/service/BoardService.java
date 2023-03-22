package com.example.ch04.service;

import com.example.ch04.dao.BoardDao;
import com.example.ch04.dto.BoardDto;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardService {

  @Autowired
  BoardDao boardDao; // DI

  public BoardService() {
    log.info(null);
  }

  public ArrayList<BoardDto> getAllBoard() {
    ArrayList<BoardDto> boardList = boardDao.getAllBoard();
    return boardList;
  }

  public void insertBoard(BoardDto boardDto) {
    boardDao.insertBoard(boardDto);
  }

  public BoardDto getView(int no) {
    BoardDto boardDto = boardDao.getView(no);
    return boardDto;
  }

  public void updateHit(int no) {
    boardDao.updateHit(no);
  }

  public void modifyBoard(BoardDto boardDto) {
    boardDao.modifyBoard(boardDto);
  }

  public void deleteBoard(int no) {
    boardDao.deleteBoard(no);
  }
}
