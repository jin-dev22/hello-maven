package com.kh.app.emp.controller;

import java.io.IOException;
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
public class EmpSearchController2 extends AbstractController{
	private final EmpService empService;
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 입력값처리
		String searchType = request.getParameter("searchType");//사용자가 입력하지 않아도 빈 문자열("")로 넘어옴.index에서 넘어와서 바로검색하면 null
		String searchKeyword = request.getParameter("searchKeyword");
		String gender = request.getParameter("gender");
		//조건추가
		int salary = 0;
		try {
			salary = Integer.parseInt(request.getParameter("salary"));// "" || null
		} catch (NumberFormatException e) {} 
		String salaryCompare = request.getParameter("salaryCompare");// "ge" || "le" || null
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		param.put("gender", gender);
		param.put("salary", salary);
		param.put("salaryCompare", salaryCompare);
		log.debug("param>>>>>"+param);
		
		//2. 검색
		List<Map<String, Object>> list = empService.search2(param);
		log.debug("list>>>>>"+list);
		request.setAttribute("list", list);
		
		return "emp/search2";
	}
}
