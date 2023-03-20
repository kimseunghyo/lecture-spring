package com.example.ch01.controller;

import com.example.ch01.dto.Member;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("name", "홍길동");
    return "/index/index";
  }

  @GetMapping("/member/list")
  public String list(Model model) {
    ArrayList<Member> memberList = new ArrayList<>();
    memberList.add(new Member("01", "홍길동", "영등포"));
    memberList.add(new Member("02", "최이박", "이천"));
    memberList.add(new Member("03", "가나다", "세종"));

    model.addAttribute("memberList", memberList);

    return "/member/list";
  }

  @GetMapping("/mv")
  public ModelAndView home02() {
    ModelAndView mav = new ModelAndView();
    mav.addObject("subject", "제목을 실어서 보냅니다.");
    mav.setViewName("/index/index02");
    return mav;
  }
}
