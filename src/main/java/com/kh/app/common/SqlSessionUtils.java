package com.kh.app.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtils {

	static SqlSessionFactory factory;
	
	static {//0805 factoryBuilder 하나만 만들엇 쓰도록 수정
		String resource = "/mybatis-config.xml";
		
		//1. FactoryBuilder
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		//2. Factory
		InputStream is =null;
		try {
			is = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		factory = builder.build(is);
	}
	
	public static SqlSession getSqlSession() {
//		SqlSession sqlSession = null;
//		
//		
//		//3. SqlSession찍어내기
//		sqlSession = //auroCommit여부
//		
//		try {//한줄로 작성하려면 이렇게 할 수 있음
//            sqlSession = 
//                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource)).openSession(false);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
		return factory.openSession(false);
	}

}
