package com.kh.app.student.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.student.model.dto.Student;

public class StudentDaoImpl implements StudentDao {
	
	@Override
	public int insertStudent(SqlSession sqlSession, Student student) {
		return sqlSession.insert("student.insertStudent", student);
		//                        mapper의 namespace.id값
	}
	
	@Override
	public int insertStudentMap(SqlSession sqlSession, Map<String, Object> map) {
		return sqlSession.insert("student.insertStudentMap", map);//매개변수 map자리 무조건 객체 하나만 전달 가능 여러개면 하나로 만들어야됨
	}
	
	@Override
	public int getTotalCount(SqlSession sqlSession) {
		return sqlSession.selectOne("student.getTotalCount");
	}
	
	@Override
	public Student selectOneStudent(SqlSession sqlSession, int no) {
		return sqlSession.selectOne("student.selectOneStudent", no);
	}
}
