package com.kh.app.emp.model.service;

import static com.kh.app.common.SqlSessionUtils.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.emp.model.dao.EmpDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	private final EmpDao empDao;
	
	@Override
	public List<Map<String, Object>> selectEmpList() {
		try(SqlSession sqlSession = getSqlSession()){
			return empDao.selectEmpList(sqlSession);
		}
	}
	
	@Override
	public List<Map<String, Object>> search1(Map<String, Object> param) {
		try(SqlSession sqlSession = getSqlSession()){
			return empDao.search1(sqlSession, param);
		}
	}
	
	@Override
	public List<Map<String, Object>> search2(Map<String, Object> param) {
		try(SqlSession sqlSession = getSqlSession()){
			return empDao.search2(sqlSession, param);
		}
	}
	
	@Override
	public List<Map<String, Object>> selectJobList() {
		try(SqlSession sqlSession = getSqlSession()){
			return empDao.selectJobList(sqlSession);
		}
	}
	
	@Override
	public List<Map<String, Object>> search3(Map<String, Object> param) {
		try(SqlSession sqlSession = getSqlSession()){
			return empDao.search3(sqlSession, param);
		}
	}
	
	@Override
	public List<Map<String, Object>> selectDeptList() {
		try(SqlSession sqlSession = getSqlSession()){
			return empDao.selectDeptList(sqlSession);
		}
	}
}
