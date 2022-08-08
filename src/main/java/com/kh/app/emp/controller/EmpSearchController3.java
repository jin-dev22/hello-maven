package com.kh.app.emp.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.common.AbstractController;
import com.kh.app.emp.model.service.EmpService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
public class EmpSearchController3 extends AbstractController{
	private final EmpService empService;
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자입력값
		String[] jobCodes = request.getParameterValues("jobCode");
		String[] deptCodes = request.getParameterValues("deptCode");
		List<String> chkdDeptList = deptCodes != null ? Arrays.asList(deptCodes) : null;//꼭 문자열 배열이 아니어도 됨
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("jobCodes", jobCodes);
		param.put("chkdDeptList", chkdDeptList);
		
		//2. 업무로직
		List<Map<String, Object>> list = empService.search3(param);
		log.debug("list>>>>>"+list);
		
		// 폼에 나열할 직급목록 조회
		List<Map<String, Object>> jobList = empService.selectJobList();
		log.debug("jobList>>>>>"+jobList);
		List<Map<String, Object>> deptList = empService.selectDeptList();
		
		request.setAttribute("jobList", jobList);
		request.setAttribute("list", list);
		request.setAttribute("deptList", deptList);
		return "emp/search3";
	}
}
