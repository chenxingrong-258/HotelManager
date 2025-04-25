package com.coder.servlet;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ViewServlet", value = "/ViewServlet")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String os = (String) session.getAttribute("os");
        String soft = (String) session.getAttribute("soft");
        String email = (String) session.getAttribute("email");
        String name = (String) session.getAttribute("name");
        out.println(name+"用户你好<br>");
        out.println("您的操作系统是"+os+"<br>");
        out.println("您的故障软件是"+soft+"<br>");
        out.println("我们会在72小时内将处理结果反馈给你<br>");
        out.println("的邮箱"+email+"<br>"+"请注意查收");
    }
}