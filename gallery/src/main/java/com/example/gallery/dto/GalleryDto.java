package com.example.gallery.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class GalleryDto {

  private int no;
  private String title;
  private String contents;
  private MultipartFile file;
  private String original;
  private String renamed;
  private int hit;
}
