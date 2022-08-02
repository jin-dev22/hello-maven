package com.kh.app.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kh.app.common.AbstractController;
import com.kh.app.student.model.service.StudentService;

public class StudentMapEnrollController extends AbstractController{
	static final Logger log = Logger.getLogger(StudentMapEnrollController.class);
	private StudentService studentService;

	public StudentMapEnrollController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	/**
	 * Student Dto를 안만들고 Map<String, Object>로 처리하기
	 */
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("tel", tel);
		log.debug(map);
		
		int result = studentService.insertStudentMap(map);
		request.getSession().setAttribute("msg", "학생정보 등록 성공");
		
		return "redirect:/student/studentEnroll.do";
	}
}
