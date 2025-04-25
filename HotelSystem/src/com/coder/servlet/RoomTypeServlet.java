package com.coder.servlet;

import com.coder.entity.RoomType;
import com.coder.service.RoomTypeService;
import com.coder.service.impl.RoomTypeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RoomTypeServlet", value = "/RoomTypeServlet")
public class RoomTypeServlet extends BaseServlet {
    private final RoomTypeService service;
    public RoomTypeServlet() {
        this.service = new RoomTypeServiceImpl();
    }

    public String selectList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<RoomType> list = service.list();
        request.setAttribute("list",list);
        return "room_type_list.jsp";
    }
    public String save(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        RoomType roomType = new RoomType();
        try {
            BeanUtils.populate(roomType,request.getParameterMap());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println(roomType);
        String type = request.getParameter("type");
        String price = request.getParameter("price");
        String deposit = request.getParameter("deposit");
        String bednum = request.getParameter("bedNum");
        String remark = request.getParameter("remark");
        roomType.setType(type);
        roomType.setPrice(Integer.valueOf(price));
        roomType.setDeposit(Integer.valueOf(deposit));
        roomType.setBednum(Integer.valueOf(bednum));
        roomType.setRemark(remark);
        service.insert(roomType);
        return selectList(request, response);

    }
    public String delete(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        service.remove(Integer.valueOf(id));
        return selectList(request, response);
    }
    public String update(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        RoomType roomType = new RoomType();
        try {
            BeanUtils.populate(roomType,request.getParameterMap());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        service.update(roomType);
        return selectList(request, response);

    }
    public String preEdit(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        RoomType roomType = service.getById(Integer.valueOf(id));
        request.setAttribute("roomType",roomType);
        return "room_type_update.jsp";
    }
    public String deleteCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String []ids = request.getParameterValues("ids");
        service.deleteChecked(ids);
        return selectList(request, response);
    }
}