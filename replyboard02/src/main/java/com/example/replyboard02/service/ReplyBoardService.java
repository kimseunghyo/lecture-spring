package com.example.replyboard02.service;

import com.example.replyboard02.dto.ReplyBoardDto;
import java.util.List;

public interface ReplyBoardService {
  public int insertBoard(ReplyBoardDto replyBoardDto);

  public List<ReplyBoardDto> getAllBoardList(String category, String searchTxt);

  public ReplyBoardDto getSelectOne(int no);

  public int updateHit(int no);

  public int getMaxReGroup();

  public int insertReplyBoard(ReplyBoardDto replyBoardDto);

  public int updateReLevel(ReplyBoardDto replyBoardDto);

  public int updateBoard(ReplyBoardDto replyBoardDto);

  public int updateAvailable(ReplyBoardDto replyBoardDto);
}
