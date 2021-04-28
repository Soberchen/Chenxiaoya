package com.chen.dao.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MapperUtil {
	private static SqlSessionFactory factory;
	static{
		InputStream is;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			 factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static SqlSession createsSqlSession(){
		return factory.openSession(true);
	}
	public static void closeSqlSession(SqlSession sqlSession){
		if (sqlSession != null) {
			sqlSession.close();
		}
	}


}
