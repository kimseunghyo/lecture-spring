package com.example.ch04.dto;

import lombok.Data;

@Data
public class BoardDto {

  private int no;
  private String userName;
  private String title;
  private String contents;
  private String regDate;
  private int hit;
}
