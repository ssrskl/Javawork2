package com.maoyan.Dao.impl;

import com.maoyan.Dao.LoginDao;
import com.maoyan.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoimpl implements LoginDao {
    @Override
    public User checkLoginDao(String uname, String pwd) {
        //声明
        User u = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        //连接
        connection = JDBCUtil.getConnection();
        //创建Sql命令
        String sql="select * from login_user where uname=? and pwd=?";

        try {
            //创建命令对象
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1,uname);
            preparedStatement.setString(2,pwd);
            //执行
            resultSet = preparedStatement.executeQuery();
            //遍历结果
            while (resultSet.next()){
                u = new User();
                //u.setUid(resultSet.getInt("uid"));
                u.setUname(resultSet.getString("uname"));
                u.setPwd(resultSet.getString("pwd"));
            }
            //关闭资源
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return u;
    }
}
