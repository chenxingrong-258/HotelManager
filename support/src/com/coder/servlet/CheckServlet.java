package com.coder.servlet;

import com.coder.entity.Support;
import com.coder.service.impl.SupportServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String os = req.getParameter("os");
        String soft = req.getParameter("soft");
        String email = req.getParameter("email");
        HttpSession session = req.getSession();
        session.setAttribute("os", os);
        session.setAttribute("soft", soft);
        session.setAttribute("email", email);
        SupportServiceImpl service = new SupportServiceImpl();
        Support support = service.selectEmail(email);
        String path = "";
        if(support != null) {
            session.setAttribute("name", support.getName());
            path = "ViewServlet";
        }else {
            path = "reg.jsp";
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
