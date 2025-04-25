import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "OnlineMarket", value = "/buy")
public class OnlineMarket extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String nickName=request.getParameter("nickName");
        String buyNum= request.getParameter("buynum");
        PrintWriter out=response.getWriter();
        if (buyNum!=null&&Integer.parseInt(buyNum)<=10&&nickName!=null&&!nickName.isEmpty()){
            String ip=request.getRemoteAddr();
            LocalDateTime buyTime=LocalDateTime.now();
            HikariDataSource dataSource=new HikariDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/JavaWeb");
            dataSource.setUsername("root");
            dataSource.setPassword("2673253736Cxr");
            QueryRunner runner=new QueryRunner(dataSource);
            String sql0 = "select * from buy_records where ip =?";
            try {
                List<Buy_records> query = runner.query(sql0, new BeanListHandler<Buy_records>(Buy_records.class), ip);
                if (query.size()>0){
                    out.println("不允许需重复购买");
                }else{
                    String sql = "insert into buy_records(username,buytime,buynum,ip)values(?,?,?,?)";
                    int update = runner.update(sql, nickName, buyTime, buyNum, ip);
                    if (update>0){
                        out.println("购买成功");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            out.println("不要购买超过10个");
        }
    }
}