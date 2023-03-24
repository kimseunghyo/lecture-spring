package com.example.replyboard.service;

import com.example.replyboard.dao.ReplyBoardDao;
import com.example.replyboard.dto.ReplyBoardDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReplyBoardServiceImpl implements ReplyBoardService {

  @Autowired
  ReplyBoardDao replyBoardDao;

  public ReplyBoardServiceImpl() {
    log.info("=========ReplyBoardService=========");
  }

  public List<ReplyBoardDto> getAllReplyBoard() {
    return replyBoardDao.getAllReplyBoard();
  }

  public int insertBoard(ReplyBoardDto replyBoardDto) {
    int maxReGroup = getMaxReGroup();
    replyBoardDto.setReGroup(maxReGroup + 1);
    replyBoardDto.setReLevel(1);
    replyBoardDto.setReStep(1);

    return replyBoardDao.insertBoard(replyBoardDto);
  }

  public int getMaxReGroup() {
    return replyBoardDao.getMaxReGroup();
  }

  public ReplyBoardDto getSelectedBoard(int no) {
    return replyBoardDao.getSelectedBoard(no);
  }

  public int insertReplyBoard(ReplyBoardDto replyBoardDto) {
    updateReLevel(replyBoardDto);

    return replyBoardDao.insertReplyBoard(replyBoardDto);
  }

  public int updateReLevel(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.updateReLevel(replyBoardDto);
  }

  public void updateHit(int no) {
    replyBoardDao.updateHit(no);
  }

  public int updateAvailable(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.updateAvailable(replyBoardDto);
  }
}
