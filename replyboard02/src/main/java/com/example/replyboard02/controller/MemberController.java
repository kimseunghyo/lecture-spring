package com.example.replyboard02.controller;

import com.example.replyboard02.dto.MemberDto;
import com.example.replyboard02.service.MemberService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

  @Autowired
  MemberService memberService;

  @GetMapping("/join")
  public String join() {
    return "/member/join";
  }

  @PostMapping("/joinProcess")
  public String joinProcess(MemberDto memberDto, HttpServletRequest request) {
    int result = memberService.insertMember(memberDto);

    if (result > 0) {
      HttpSession session = request.getSession();
      session.setAttribute("sessionName", memberDto.getUserName());
    }
    return "/index/index";
  }

  @GetMapping("/login")
  public String login() {
    return "/member/login";
  }

  @PostMapping("/loginProcess")
  public String loginProcess(MemberDto memberDto, HttpServletRequest request) {
    MemberDto loggedMemberDto = memberService.getLoggedMember(memberDto);
    HttpSession session = request.getSession();
    session.setAttribute("sessionName", loggedMemberDto.getUserName());
    return "/index/index";
  }

  @GetMapping("/logout")
  public String logout(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.invalidate();
    return "/index/index";
  }
}
