package com.example.replyboard02.controller;

import com.example.replyboard02.dto.ReplyBoardDto;
import com.example.replyboard02.service.ReplyBoardService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

  @Autowired
  ReplyBoardService replyBoardService;

  @GetMapping("/list")
  public String list(Model model, String category, String searchTxt) {
    List<ReplyBoardDto> boardList = replyBoardService.getAllBoardList(
      category,
      searchTxt
    );
    //log.info("===============" + boardList);
    log.info("==========" + category);
    model.addAttribute("boardList", boardList);
    return "/board/list";
  }

  @GetMapping("/view")
  public String view(int no, Model model) {
    replyBoardService.updateHit(no);
    ReplyBoardDto replyBoardDto = replyBoardService.getSelectOne(no);
    model.addAttribute("replyBoardDto", replyBoardDto);
    return "/board/view";
  }

  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @PostMapping("/writeProcess")
  public String writeProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttributes
  ) {
    replyBoardService.insertBoard(replyBoardDto);
    //redirectAttributes.addAttribute("msg", "글이 등록되었습니다.");
    redirectAttributes.addFlashAttribute("msg", "글이 등록되었습니다.");
    return "redirect:/board/list";
  }

  @GetMapping("/reply")
  public String reply() {
    return "/board/reply";
  }

  @PostMapping("/replyProcess")
  public String replyProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttributes
  ) {
    replyBoardService.insertReplyBoard(replyBoardDto);
    redirectAttributes.addFlashAttribute("msg", "글이 등록되었습니다.");
    return "redirect:/board/list";
  }

  @GetMapping("/modify")
  public String modify(int no, Model model) {
    ReplyBoardDto replyBoardDto = replyBoardService.getSelectOne(no);
    model.addAttribute("replyBoardDto", replyBoardDto);
    return "/board/modify";
  }

  @PostMapping("/modifyProcess")
  public String modifyProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttributes
  ) {
    int result = replyBoardService.updateBoard(replyBoardDto);
    int no = replyBoardDto.getNo();

    if (result > 0) {
      redirectAttributes.addFlashAttribute("msg", "글이 수정되었습니다.");
      return "redirect:/board/list";
    } else {
      redirectAttributes.addFlashAttribute(
        "msg",
        "비밀번호를 다시 확인해주세요."
      );
      return "redirect:/board/modify?no=" + no;
    }
  }

  @GetMapping("/delete")
  public String delete() {
    return "/board/delete";
  }

  @PostMapping("/deleteProcess")
  public String deleteProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttributes
  ) {
    int result = replyBoardService.updateAvailable(replyBoardDto);
    int no = replyBoardDto.getNo();

    if (result > 0) {
      redirectAttributes.addFlashAttribute("msg", "글이 삭제되었습니다.");
      return "redirect:/board/list";
    } else {
      redirectAttributes.addFlashAttribute(
        "msg",
        "비밀번호를 다시 확인해주세요."
      );
      return "redirect:/board/delete?no=" + no;
    }
  }

  @PostMapping("/deleteAjaxProcess")
  @ResponseBody
  public Map<String, Object> deleteAjaxProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttributes
  ) {
    int result = replyBoardService.updateAvailable(replyBoardDto);
    //ReplyJsonDto replyJsonDto = new ReplyJsonDto();
    Map<String, Object> sendJson = new HashMap<>();

    if (result > 0) {
      //replyJsonDto.setMsg("ok");
      sendJson.put("msg", "ok");
    } else {
      //replyJsonDto.setMsg("fail");
      sendJson.put("msg", "fail");
    }
    //return replyJsonDto;
    return sendJson;
  }

  @GetMapping("/search")
  public String search(ReplyBoardDto replyBoardDto) {
    return "/board/list";
  }
}
