package com.example.ch04.controller;

import com.example.ch04.dto.BoardDto;
import com.example.ch04.service.BoardService;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  BoardService boardService;

  @GetMapping("/list")
  public String list(Model model) {
    ArrayList<BoardDto> boardList = boardService.getAllBoard();
    model.addAttribute("boardList", boardList);
    return "/board/list";
  }

  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @PostMapping("/writeProcess")
  public String writeProcess(BoardDto boardDto) {
    boardService.insertBoard(boardDto);
    return "redirect:/board/list";
  }

  @GetMapping("/view")
  public String view(int no, Model model) {
    boardService.updateHit(no);
    BoardDto boardDto = boardService.getView(no);
    model.addAttribute("boardDto", boardDto);
    return "/board/view";
  }

  @GetMapping("/modify")
  public String modify(int no, Model model) {
    BoardDto boardDto = new BoardDto();
    boardDto = boardService.getView(no);
    model.addAttribute("boardDto", boardDto);
    return "/board/modify";
  }

  @PostMapping("/modifyProcess")
  public String modifyProcess(BoardDto boardDto) {
    boardService.modifyBoard(boardDto);
    return "redirect:/board/list";
  }

  @GetMapping("/deleteProcess")
  public String deleteProcess(int no) {
    log.info("no==" + no);
    boardService.deleteBoard(no);
    return "redirect:/board/list";
  }
}
