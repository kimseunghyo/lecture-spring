package com.example.replyboard02.service;

import com.example.replyboard02.dto.MemberDto;

public interface MemberService {
  public int insertMember(MemberDto memberDto);

  public MemberDto getLoggedMember(MemberDto memberDto);
}
