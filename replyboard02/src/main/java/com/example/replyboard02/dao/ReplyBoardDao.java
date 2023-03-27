package com.example.replyboard02.dao;

import com.example.replyboard02.dto.ReplyBoardDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyBoardDao {
  int insertBoard(ReplyBoardDto replyBoardDto);

  List<ReplyBoardDto> getAllBoardList();

  ReplyBoardDto getSelectOne(int no);

  int updateHit(int no);

  int getMaxReGroup();

  int insertReplyBoard(ReplyBoardDto replyBoardDto);

  int updateReLevel(ReplyBoardDto replyBoardDto);

  int updateBoard(ReplyBoardDto replyBoardDto);

  int updateAvailable(ReplyBoardDto replyBoardDto);
}
