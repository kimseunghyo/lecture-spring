package com.example.replyboard02.service;

import com.example.replyboard02.dao.MemberDao;
import com.example.replyboard02.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

  @Autowired
  MemberDao memberDao;

  public MemberServiceImpl() {
    log.info("==========MemberService==========");
  }

  public int insertMember(MemberDto memberDto) {
    return memberDao.insertMember(memberDto);
  }

  public MemberDto getLoggedMember(MemberDto memberDto) {
    return memberDao.getLoggedMember(memberDto);
  }
}
