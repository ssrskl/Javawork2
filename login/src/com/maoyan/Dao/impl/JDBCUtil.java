package com.maoyan.Dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static String driver;
    private static String url;
    private static String usernmae;
    private static String password;
    static {
        String dbproperties = "/db.properties";
        //获取属性文件的内容
        Properties properties = new Properties();
        //获取属性文件的流对象
        InputStream inputStream = JDBCUtil.class.getResourceAsStream(dbproperties);
        try {
            //加载属性文件
            properties.load(inputStream);
            //获取参数
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            usernmae = properties.getProperty("username");
            password = properties.getProperty("password");
            //加载驱动
            Class.forName(driver);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usernmae, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

}
