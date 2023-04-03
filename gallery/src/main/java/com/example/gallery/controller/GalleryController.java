package com.example.gallery.controller;

import com.example.gallery.dao.GalleryDao;
import com.example.gallery.dto.GalleryDto;
import com.example.gallery.dto.ReplyDto;
import com.example.gallery.service.GalleryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GalleryController {

  @Autowired
  GalleryService galleryService;

  @GetMapping({ "/", "/list" })
  public String list(Model model) {
    List<GalleryDto> galleryList = galleryService.getAllList();
    model.addAttribute("galleryList", galleryList);

    return "/gallery/list";
  }

  @GetMapping("/insert")
  public String insert() {
    return "/gallery/insert";
  }

  @PostMapping("/insert")
  public String insertProcess(GalleryDto galleryDto) {
    galleryService.insertGallery(galleryDto);
    return "redirect:/";
  }

  @GetMapping("/view/{no}")
  public String view(@PathVariable("no") int no, Model model) {
    GalleryDto galleryDto = galleryService.viewGallery(no);
    model.addAttribute("galleryDto", galleryDto);
    return "/gallery/view";
  }

  @PostMapping("/insertReply")
  @ResponseBody
  public List<ReplyDto> insertReply(ReplyDto replyDto) {
    int result = galleryService.insertReply(replyDto);
    List<ReplyDto> replyList = galleryService.getAllReply(
      replyDto.getGalleryId()
    );
    if (result > 0) {
      return replyList;
    } else {
      return replyList;
    }
  }

  @PostMapping("/getReply/{no}")
  @ResponseBody
  public List<ReplyDto> getReply(@PathVariable("no") int no) {
    List<ReplyDto> replyList = galleryService.getAllReply(no);
    return replyList;
  }

  @PostMapping("/deleteReply")
  @ResponseBody
  public List<ReplyDto> deleteReply(ReplyDto replyDto) {
    int result = galleryService.deleteReply(replyDto);
    List<ReplyDto> replyList = galleryService.getAllReply(
      replyDto.getGalleryId()
    );
    if (result > 0) {
      return replyList;
    } else {
      return replyList;
    }
  }
}
