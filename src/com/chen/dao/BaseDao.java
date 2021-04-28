package com.chen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class BaseDao {
	Connection conn=null;
	PreparedStatement pre=null;
	ResultSet rs=null;
	int num=0;
	private static String driver;//数据库驱动字符串
	private static String url;//连接URL字符串
	private static String user;//登录用户名
	private static String password;//登录密码
	
	static {
		
		
ResourceBundle bundle = ResourceBundle.getBundle("axin", new Locale("zh", "CN"));
		
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		user = bundle.getString("user");
		password = bundle.getString("password");
	}

	public Connection getConnection(){
		Connection conn = null;
		
		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.创建数据库连接Connection对象
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	public void closeAll(Connection conn,PreparedStatement pre,ResultSet rs){//关闭所有连接
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pre!=null){
			try {
				pre.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int getSIDU(String sql,Object...obj){//执行增删改查
		conn =getConnection();
		try {
			pre=conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pre.setObject(i+1, obj[i]);
			}
			num=pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, pre, null);
		}
		
		return num;
		
	}
	


}
