package com.example.replyboard.dto;

import lombok.Data;

@Data
public class ReplyBoardDto {

  private int no;
  private String subject;
  private String name;
  private String password;
  private String regDate;
  private String contents;
  private int available;
  private int reGroup;
  private int reLevel;
  private int reStep;
  private int hit;
}
