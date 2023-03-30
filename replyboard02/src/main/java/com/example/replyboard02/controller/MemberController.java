package com.example.replyboard02.controller;

import com.example.replyboard02.dto.MemberDto;
import com.example.replyboard02.service.MemberService;
import com.example.replyboard02.utils.ScriptWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
  public String joinProcess(
    MemberDto memberDto,
    HttpServletRequest request,
    HttpServletResponse response,
    RedirectAttributes redirectAttributes
  ) {
    int result = memberService.insertMember(memberDto);

    if (result > 0) {
      redirectAttributes.addFlashAttribute("msg", "회원가입 되었습니다.");
      return "redirect:/";
    } else {
      return null;
    }
  }

  @GetMapping("/login")
  public String login() {
    return "/member/login";
  }

  @PostMapping("/loginProcess")
  public String loginProcess(
    MemberDto memberDto,
    HttpServletRequest request,
    HttpServletResponse response,
    RedirectAttributes redirectAttributes
  ) throws IOException {
    MemberDto loggedMemberDto = memberService.getLoggedMember(memberDto);

    if (loggedMemberDto != null) {
      HttpSession session = request.getSession();
      session.setAttribute("loggedMember", loggedMemberDto);
      redirectAttributes.addFlashAttribute("msg", "로그인 되었습니다.");
      return "redirect:/";
    } else {
      ScriptWriter.alertAndBack(
        response,
        "아이디 비밀번호를 다시 확인해 주세요."
      );
      return null;
    }
  }

  @GetMapping("/logout")
  public String logout(
    HttpServletRequest request,
    RedirectAttributes redirectAttributes
  ) {
    HttpSession session = request.getSession();
    //session.invalidate();
    session.removeAttribute("loggedMember");
    redirectAttributes.addFlashAttribute("msg", "로그아웃 되었습니다.");
    return "redirect:/";
  }

  @GetMapping("/info")
  public String info() {
    return "/member/info";
  }
}
