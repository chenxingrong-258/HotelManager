package com.coder.util;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DBUtil {
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("com.coder.util/db");
        DRIVER = rb.getString("jdbc.driver");
        URL = rb.getString("jdbc.url");
        USERNAME = rb.getString("jdbc.username");
        PASSWORD = rb.getString("jdbc.password");
    }
    public static HikariDataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
    public static QueryRunner getQueryRunner(){
        return new QueryRunner(getDataSource());
    }
    public static boolean deleteBatch(String sql,String []ids){
        List<Object>list = new ArrayList<>();
        for (String id : ids) {
            list.add(new Object[]{id});
        }
        try {
            getQueryRunner().batch(sql,list.toArray(new Object[list.size()][]));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
