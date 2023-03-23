package com.example.replyboard.controller;

import com.example.replyboard.dto.ReplyBoardDto;
import com.example.replyboard.service.ReplyBoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
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
    int maxReGroup = replyBoardService.getMaxReGroup();
    replyBoardDto.setReGroup(maxReGroup + 1);
    replyBoardDto.setReLevel(1);
    replyBoardDto.setReStep(1);
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
}
