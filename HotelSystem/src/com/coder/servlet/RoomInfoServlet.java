package com.coder.servlet;

import com.coder.entity.RoomInfo;
import com.coder.entity.RoomType;
import com.coder.service.RoomInfoService;
import com.coder.service.RoomTypeService;
import com.coder.service.impl.RoomInfoServiceImpl;
import com.coder.service.impl.RoomTypeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "RoomInfoServlet", value = "/RoomInfoServlet",initParams=@WebInitParam(name="status",value="1:空,2:有客,3:空脏"))
@MultipartConfig
public class RoomInfoServlet extends BaseServlet {
    private final RoomInfoService service;
    private final RoomTypeService typeService;
    public RoomInfoServlet() {
        service = new RoomInfoServiceImpl();
        typeService = new RoomTypeServiceImpl();
    }
    public String selectList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoomInfo> list = service.list();
        req.setAttribute("list", list);
        return "room_info_list.jsp";
    }
    public String preSave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = this.getServletConfig();
        String status = config.getInitParameter("status");
        String[] statuses = status.split(",");
        Map<String, String> map = new TreeMap<>();
        for (String s : statuses) {//1:空
            map.put(s.split(":")[0], s.split(":")[1]);
        }
        List<RoomType> list = typeService.list();
        req.setAttribute("list", list);
        req.setAttribute("map", map);
        return "room_info_save.jsp";
    }
    public String selectByTid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tid = req.getParameter("tid");
        RoomType roomType = typeService.getById(Integer.valueOf(tid));
        PrintWriter out = resp.getWriter();
        out.println("{\"price\":"+roomType.getPrice()+";\"deposit\":"+roomType.getDeposit()+"}");
        return "room_info_save.jsp";
    }
    public String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomInfo roomInfo = new RoomInfo();
        try {
            BeanUtils.populate(roomInfo,req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/");
        String path = realPath + "upload";
        File dir = new File(path);
        dir.mkdirs();//创建目录
        //完成上传处理
        Part part = req.getPart("pic");
        String fileName = part.getSubmittedFileName();
        String extName = fileName.substring(fileName.lastIndexOf("."));
        String prefix = String.valueOf(System.currentTimeMillis());
        fileName = prefix + extName;
        File file = new File(dir, fileName);
        //上传处理
        part.write(file.getAbsolutePath());
        roomInfo.setPic("/upload/" + fileName);
        service.insert(roomInfo);
        return selectList(req, resp);
    }
    public void download(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getParameter("path");
        String fileName=path.substring(path.lastIndexOf("/")+1);
        String realPath=this.getServletContext().getRealPath("/");
        String file=realPath+path;
        //设置一下响应相关的类型
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
        //通过IO流，实现文件下载
        FileInputStream fis=new FileInputStream(file);
        OutputStream os= resp.getOutputStream();
        byte[] buffer=new byte[1024];
        int b=-1;
        while ((b=fis.read(buffer))!=-1){
            os.write(buffer,0,b);
        }
        fis.close();
        os.close();
    }
}