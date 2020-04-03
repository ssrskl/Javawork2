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
		//����Jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//�������ݴ洢����
		User u=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/t_user","root","ar352878987");
			//����Sql����
			String sql="select * from t_user where uname=? and pwd=?";
			//����Sql�������
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setString(1, uname);
			ps.setString(2, pwd);
			//ִ��
			rs=ps.executeQuery();
			//����ִ�н��
			while(rs.next()){
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
			//�ر���Դ
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
		//����
		return u;
	}
	//����UID��ȡ�û���Ϣ
	@Override
	public User checkUidDao(String uid) {
			//����Jdbc����
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				//�������ݴ洢����
				User u=null;
				try {
					//��������
					Class.forName("com.mysql.jdbc.Driver");
					//��ȡ���Ӷ���
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","1234");
					//����Sql����
					String sql="select * from t_user where uid=?";
					//����Sql�������
					ps=conn.prepareStatement(sql);
					//��ռλ����ֵ
					ps.setString(1, uid);
					//ִ��
					rs=ps.executeQuery();
					//����ִ�н��
					while(rs.next()){
						u=new User();
						u.setUid(rs.getInt("uid"));
						u.setUname(rs.getString("uname"));
						u.setPwd(rs.getString("pwd"));
					}
					//�ر���Դ
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
				//����
				return u;
	}
		
}
