package com.example.gallery.dao;

import com.example.gallery.dto.GalleryDto;
import com.example.gallery.dto.ReplyDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GalleryDao {
  int insertGallery(GalleryDto galleryDto);

  // @Select("SELECT * FROM GALLERY ORDER BY GALLERY")
  List<GalleryDto> getAllList();

  GalleryDto viewGallery(int no);

  int insertReply(ReplyDto replyDto);

  List<ReplyDto> getAllReply(int galleryId);

  int deleteReply(ReplyDto replyDto);
}
