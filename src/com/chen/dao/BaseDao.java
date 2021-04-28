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
	private static String driver;//���ݿ������ַ���
	private static String url;//����URL�ַ���
	private static String user;//��¼�û���
	private static String password;//��¼����
	
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
			// 1.��������
			Class.forName(driver);
			// 2.�������ݿ�����Connection����
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
	public void closeAll(Connection conn,PreparedStatement pre,ResultSet rs){//�ر���������
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
	public int getSIDU(String sql,Object...obj){//ִ����ɾ�Ĳ�
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
