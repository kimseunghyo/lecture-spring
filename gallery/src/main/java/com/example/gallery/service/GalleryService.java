package com.example.gallery.service;

import com.example.gallery.dto.GalleryDto;
import com.example.gallery.dto.ReplyDto;
import java.util.List;

public interface GalleryService {
  int insertGallery(GalleryDto galleryDto);

  List<GalleryDto> getAllList();

  GalleryDto viewGallery(int no);

  int insertReply(ReplyDto replyDto);

  List<ReplyDto> getAllReply(int galleryId);

  int deleteReply(int no);
}
