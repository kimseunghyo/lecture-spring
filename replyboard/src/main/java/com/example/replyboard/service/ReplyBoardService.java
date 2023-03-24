package com.example.replyboard.service;

import com.example.replyboard.dto.ReplyBoardDto;
import java.util.List;

public interface ReplyBoardService {
  List<ReplyBoardDto> getAllReplyBoard();
  int insertBoard(ReplyBoardDto replyBoardDto);
  int getMaxReGroup();
  ReplyBoardDto getSelectedBoard(int no);
  int insertReplyBoard(ReplyBoardDto replyBoardDto);
  int updateReLevel(ReplyBoardDto replyBoardDto);
  void updateHit(int no);
  int updateAvailable(ReplyBoardDto replyBoardDto);
}
