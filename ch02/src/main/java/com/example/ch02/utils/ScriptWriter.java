package com.example.ch02.utils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

public class ScriptWriter {

  public static void alert(HttpServletResponse response, String alertMsg)
    throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + alertMsg + "');");
    out.println("</script>");
  }

  public static void alertAndNext(
    HttpServletResponse response,
    String alertMsg,
    String next
  ) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + alertMsg + "');");
    out.println("location.href='" + next + "';");
    out.println("</script>");
  }

  public static void alertAndBack(
    HttpServletResponse response,
    String alertMsg
  ) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + alertMsg + "');");
    out.println("history.back();");
    out.println("</script>");
  }
}
