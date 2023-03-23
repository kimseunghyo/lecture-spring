package com.example.replyboard.dao;

import com.example.replyboard.dto.ReplyBoardDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyBoardDao {
  List<ReplyBoardDto> getAllReplyBoard();
  int insertBoard(ReplyBoardDto replyBoardDto);
  int getMaxReGroup();
  ReplyBoardDto getSelectedBoard(int no);
  int insertReplyBoard(ReplyBoardDto replyBoardDto);
  void updateHit(int no);
}
