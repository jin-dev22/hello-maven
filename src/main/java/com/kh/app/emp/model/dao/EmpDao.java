package com.kh.app.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface EmpDao {

	List<Map<String, Object>> selectEmpList(SqlSession sqlSession);

	List<Map<String, Object>> search1(SqlSession sqlSession, Map<String, Object> param);

	List<Map<String, Object>> search2(SqlSession sqlSession, Map<String, Object> param);

	List<Map<String, Object>> selectJobList(SqlSession sqlSession);

	List<Map<String, Object>> search3(SqlSession sqlSession, Map<String, Object> param);

	List<Map<String, Object>> selectDeptList(SqlSession sqlSession);

}
