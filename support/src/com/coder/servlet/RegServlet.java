package com.coder.servlet;

import com.coder.entity.Support;
import com.coder.service.impl.SupportServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegServlet", value = "/RegServlet")
public class RegServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        Support support = new Support();
        support.setName(name);
        support.setEmail(email);
        session.setAttribute("name",name);
        SupportServiceImpl service = new SupportServiceImpl();
        service.insert(support);
        request.getRequestDispatcher("ViewServlet").forward(request,response);

    }
}