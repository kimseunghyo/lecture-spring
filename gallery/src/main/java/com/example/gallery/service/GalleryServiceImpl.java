package com.example.gallery.service;

import com.example.gallery.dao.GalleryDao;
import com.example.gallery.dto.GalleryDto;
import com.example.gallery.dto.ReplyDto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GalleryServiceImpl implements GalleryService {

  @Autowired
  GalleryDao galleryDao;

  @Value("${file.path}")
  private String uploadFoler;

  public int insertGallery(GalleryDto galleryDto) {
    UUID uuid = UUID.randomUUID();
    // form에서 전달된 파일이름
    String originalFile = galleryDto.getFile().getOriginalFilename();
    // 중복방지용 이름
    String renamedFile = uuid + "_" + originalFile;

    Path imgFilePath = Paths.get(uploadFoler + renamedFile);
    galleryDto.setOriginal(originalFile);
    galleryDto.setRenamed(renamedFile);

    try {
      Files.write(imgFilePath, galleryDto.getFile().getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }

    int result = galleryDao.insertGallery(galleryDto);
    return result;
  }

  public List<GalleryDto> getAllList() {
    List<GalleryDto> galleryList = galleryDao.getAllList();
    return galleryList;
  }

  public GalleryDto viewGallery(int no) {
    return galleryDao.viewGallery(no);
  }

  public int insertReply(ReplyDto replyDto) {
    int result = galleryDao.insertReply(replyDto);
    return result;
  }

  public List<ReplyDto> getAllReply(int galleryId) {
    List<ReplyDto> replyList = galleryDao.getAllReply(galleryId);
    return replyList;
  }

  public int deleteReply(ReplyDto replyDto) {
    int result = galleryDao.deleteReply(replyDto);
    return result;
  }
}
