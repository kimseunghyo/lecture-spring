package com.example.ch02.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("msg", "메세지를 내려 보냅니다.");
    return "/index/index";
  }
}
