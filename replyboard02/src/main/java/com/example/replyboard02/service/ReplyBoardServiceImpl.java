package com.example.replyboard02.service;

import com.example.replyboard02.dao.ReplyBoardDao;
import com.example.replyboard02.dto.ReplyBoardDto;
import java.util.HashMap;
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
    log.info("==========ReplyBoardService==========");
  }

  public int insertBoard(ReplyBoardDto replyBoardDto) {
    replyBoardDto.setReGroup(getMaxReGroup() + 1);
    replyBoardDto.setReLevel(1);
    replyBoardDto.setReStep(1);
    return replyBoardDao.insertBoard(replyBoardDto);
  }

  public List<ReplyBoardDto> getAllBoardList(
    String category,
    String searchTxt
  ) {
    HashMap<String, Object> hashMap = new HashMap<>();
    hashMap.put("category", category);
    hashMap.put("searchTxt", searchTxt);
    List<ReplyBoardDto> boardList = replyBoardDao.getAllBoardList(hashMap);
    return boardList;
  }

  public ReplyBoardDto getSelectOne(int no) {
    return replyBoardDao.getSelectOne(no);
  }

  public int updateHit(int no) {
    return replyBoardDao.updateHit(no);
  }

  public int getMaxReGroup() {
    return replyBoardDao.getMaxReGroup();
  }

  public int insertReplyBoard(ReplyBoardDto replyBoardDto) {
    int reGroup = replyBoardDto.getReGroup();
    int reLevel = replyBoardDto.getReLevel();
    int reStep = replyBoardDto.getReStep();

    replyBoardDao.updateReLevel(replyBoardDto);

    replyBoardDto.setReGroup(reGroup);
    replyBoardDto.setReLevel(reLevel + 1);
    replyBoardDto.setReStep(reStep + 1);

    return replyBoardDao.insertReplyBoard(replyBoardDto);
  }

  public int updateReLevel(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.updateReLevel(replyBoardDto);
  }

  public int updateBoard(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.updateBoard(replyBoardDto);
  }

  public int updateAvailable(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.updateAvailable(replyBoardDto);
  }

  public ReplyBoardDto getPrevSelect(int num) {
    return replyBoardDao.getPrevSelect(num);
  }

  public ReplyBoardDto getNextSelect(int num) {
    return replyBoardDao.getNextSelect(num);
  }
}
