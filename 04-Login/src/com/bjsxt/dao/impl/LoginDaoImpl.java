package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjsxt.dao.LoginDao;
import com.bjsxt.pojo.User;

public class LoginDaoImpl implements LoginDao{

	@Override
	public User checkLoginDao(String uname, String pwd) {
		//声明Jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明数据存储对象
		User u=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/t_user","root","ar352878987");
			//创建Sql命令
			String sql="select * from t_user where uname=? and pwd=?";
			//创建Sql命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, uname);
			ps.setString(2, pwd);
			//执行
			rs=ps.executeQuery();
			//遍历执行结果
			while(rs.next()){
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
			//关闭资源
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//返回
		return u;
	}
	//根据UID获取用户信息
	@Override
	public User checkUidDao(String uid) {
			//声明Jdbc对象
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				//声明数据存储对象
				User u=null;
				try {
					//加载驱动
					Class.forName("com.mysql.jdbc.Driver");
					//获取连接对象
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","1234");
					//创建Sql命令
					String sql="select * from t_user where uid=?";
					//创建Sql命令对象
					ps=conn.prepareStatement(sql);
					//给占位符赋值
					ps.setString(1, uid);
					//执行
					rs=ps.executeQuery();
					//遍历执行结果
					while(rs.next()){
						u=new User();
						u.setUid(rs.getInt("uid"));
						u.setUname(rs.getString("uname"));
						u.setPwd(rs.getString("pwd"));
					}
					//关闭资源
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//返回
				return u;
	}
		
}
