package com.example.replyboard.controller;

import com.example.replyboard.dto.ReplyBoardDto;
import com.example.replyboard.service.ReplyBoardService;
import java.util.List;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

  @Autowired
  ReplyBoardService replyBoardService;

  @GetMapping("/list")
  public String list(Model model) {
    List<ReplyBoardDto> boardList = replyBoardService.getAllReplyBoard();
    model.addAttribute("boardList", boardList);
    return "/board/list";
  }

  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @PostMapping("/writeProcess")
  public String writeProcess(ReplyBoardDto replyBoardDto) {
    replyBoardService.insertBoard(replyBoardDto);
    return "redirect:/board/list";
  }

  @GetMapping("/view")
  public String view(int no, Model model) {
    replyBoardService.updateHit(no);

    ReplyBoardDto boardDto = replyBoardService.getSelectedBoard(no);
    model.addAttribute("boardDto", boardDto);
    return "/board/view";
  }

  @GetMapping("/reply")
  public String reply(int no, Model model) {
    return "/board/reply";
  }

  @PostMapping("/replyProcess")
  public String replyWriteProcess(ReplyBoardDto replyBoardDto) {
    replyBoardService.insertReplyBoard(replyBoardDto);
    return "redirect:/board/list";
  }

  @GetMapping("/delete")
  public String delete() {
    return "/board/delete";
  }

  @PostMapping("/deleteProcess")
  public String deleteProcess(ReplyBoardDto replyBoardDto) {
    replyBoardService.updateAvailable(replyBoardDto);
    log.info("ReplyBoardDto=======" + replyBoardDto);
    return "redirect:/board/list";
  }
}
