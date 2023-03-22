package com.example.ch04.dao;

import com.example.ch04.dto.BoardDto;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
  ArrayList<BoardDto> getAllBoard();
  void insertBoard(BoardDto boardDto);
  BoardDto getView(int no);
  void updateHit(int no);
  void modifyBoard(BoardDto boardDto);
  void deleteBoard(int no);
}
