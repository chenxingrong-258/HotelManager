package com.coder.servlet;

import com.coder.entity.Admin;
import com.coder.service.AdminService;
import com.coder.service.impl.AdminServiceImpl;
import com.coder.util.DBUtil;
import org.apache.commons.beanutils.BeanUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends BaseServlet {
    private final AdminService service;
    public AdminServlet(){
        service=new AdminServiceImpl();
    }
    public String selectList(HttpServletRequest request, HttpServletResponse response){
        List<Admin> list = service.list();
        request.setAttribute("list",list);
        return "admin_list.jsp";
    }
    public String save(HttpServletRequest request,HttpServletResponse response){
        Admin admin=new Admin();
        try {
            BeanUtils.populate(admin,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        admin.setPwd("123456");
        service.insert(admin);
        return selectList(request,response);
    }
    public String login(HttpServletRequest request,HttpServletResponse response){
        Admin admin=new Admin();
        try {
            BeanUtils.populate(admin,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        admin=service.login(admin);
        if (admin==null){
            request.setAttribute("msg","帐户或密码错误");
            return "login.jsp";
        }else{
            admin.setLasttime(LocalDateTime.now());
            service.updateLogin(admin);
            return "index.jsp";
        }
    }
    public String logout(HttpServletRequest request,HttpServletResponse response){
        HttpSession session=request.getSession();
        session.removeAttribute("admin");
        session.invalidate();
        return "login_ajax.jsp";
    }
    public void loginAjax(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Admin admin=new Admin();
        try {
            BeanUtils.populate(admin,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        String pwd=admin.getPwd();
        admin=service.login(admin);
        PrintWriter out = response.getWriter();
        String rem = request.getParameter("rem");
        if (admin==null){
            request.setAttribute("msg","帐户或密码错误");
            out.println("{\"msg\":\"fail\"}");
        }else{
            admin.setLasttime(LocalDateTime.now());
            service.updateLogin(admin);
            if ("true".equals(rem)){
                Cookie nameCookie = new Cookie("nameCookie",admin.getName());
                Cookie pwdCookie = new Cookie("pwdCookie",pwd);
                nameCookie.setMaxAge(60*60*24*10);
                pwdCookie.setMaxAge(60*60*24*10);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
            HttpSession session=request.getSession();
            session.setAttribute("admin",admin);
            out.println("{\"msg\":\"success\"}");
        }
    }
    public String delete(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        service.delete(Integer.parseInt(id));
        return selectList(request,response);
    }
    public String deleteCheck(HttpServletRequest request,HttpServletResponse response){
        String[]ids = request.getParameterValues("ids");
        service.deleteChecked(ids);
        return selectList(request,response);
    }
    public String preEdit(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        Admin admin = service.getById(Integer.parseInt(id));
        request.setAttribute("admin",admin);
        return "admin_update.jsp";
    }
    public String update(HttpServletRequest request,HttpServletResponse response){
        Admin admin=new Admin();
        try {
            BeanUtils.populate(admin,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        service.update(admin);
        return selectList(request,response);
    }
}