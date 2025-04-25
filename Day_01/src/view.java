import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "view", value = "/view")
public class view extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HikariDataSource dataSource=new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/JavaWeb");
        dataSource.setUsername("root");
        dataSource.setPassword("2673253736Cxr");
        QueryRunner runner=new QueryRunner(dataSource);
        String sql = "select id,username,buytime,buynum,ip from buy_records";
        try {
            List<Buy_records> list = runner.query(sql, new BeanListHandler<Buy_records>(Buy_records.class));
            StringBuffer sb=new StringBuffer();
            sb.append("<table border=1px solid black>")
                    .append("<tr><td>编号</td>")
                    .append("<td>客户姓名</td>")
                    .append("<td>购买时间</td>")
                    .append("<td>购买数量</td>")
                    .append("<td>IP地址</td></tr>");
            for (Buy_records buyRecords : list) {
                sb.append("<tr><td>"+buyRecords.getId()+"</td>")
                .append("<td>"+buyRecords.getUsername()+"</td>")
                .append("<td>"+buyRecords.getBuytime()+"</td>")
                .append("<td>"+buyRecords.getBuynum()+"</td>")
                .append("<td>"+buyRecords.getIp()+"</td></tr>");
            }
            sb.append("</table>");
            out.println(sb.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}