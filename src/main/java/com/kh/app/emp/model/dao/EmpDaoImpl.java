package com.kh.app.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {
	@Override
	public List<Map<String, Object>> selectEmpList(SqlSession sqlSession) {
		return sqlSession.selectList("emp.selectEmpList");
	}
	
	@Override
	public List<Map<String, Object>> search1(SqlSession sqlSession, Map<String, Object> param) {
		return sqlSession.selectList("emp.search1", param);
	}
	
	@Override
	public List<Map<String, Object>> search2(SqlSession sqlSession, Map<String, Object> param) {
		return sqlSession.selectList("emp.search2", param);
	}
	
	@Override
	public List<Map<String, Object>> selectJobList(SqlSession sqlSession) {
		return sqlSession.selectList("emp.selectJobList");
	}
	
	@Override
	public List<Map<String, Object>> search3(SqlSession sqlSession, Map<String, Object> param) {
		return sqlSession.selectList("emp.search3", param);
	}
	
	@Override
	public List<Map<String, Object>> selectDeptList(SqlSession sqlSession) {
		return sqlSession.selectList("emp.selectDeptList");
	}
}
