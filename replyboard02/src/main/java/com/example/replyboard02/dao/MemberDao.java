package com.example.replyboard02.dao;

import com.example.replyboard02.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
  int insertMember(MemberDto memberDto);

  MemberDto getLoggedMember(MemberDto memberDto);
}
