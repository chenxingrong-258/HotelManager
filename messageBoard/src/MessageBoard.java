
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MessageBoard", value = "/x")
public class MessageBoard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
//设置响应内容类型是网页
        response.setContentType("text/html");
//设置响应编码
        response.setCharacterEncoding("UTF-8");
//获取打印流
        String nickName=request.getParameter("nickName");
        String content=request.getParameter("content");
        String ip=request.getRemoteAddr();
        PrintWriter out=response.getWriter();
        HikariDataSource dataSource=new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/JavaWeb");
        dataSource.setUsername("root");
        dataSource.setPassword("2673253736Cxr");
//获取apache DBUtils中的QueryRunner工具类
        QueryRunner runner=new QueryRunner(dataSource);
        String sql="insert into message(nickname,content,ip,mtime)values(?,?,?,?)";
        try {
            int update = runner.update(sql, nickName, content,ip,
                    LocalDateTime.now());
            out.println(update>0?"留言成功":"留言失败");
//System.out.println("控制台上");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}