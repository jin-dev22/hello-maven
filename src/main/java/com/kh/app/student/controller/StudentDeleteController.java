package com.kh.app.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.kh.app.common.AbstractController;
import com.kh.app.student.model.dto.Student;
import com.kh.app.student.model.service.StudentService;

public class StudentDeleteController extends AbstractController {
	static final Logger log = Logger.getLogger(StudentDeleteController.class);
	private StudentService studentService;
	
	public StudentDeleteController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//입력값처리
		int no = Integer.parseInt(request.getParameter("no"));
		
		//업무로직 - 정보 삭제(삭제일 컬럼 변경)
		int result = studentService.deleteStudent(no);
		log.debug(result);
		//json응답
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(result, response.getWriter());
		return null;
	}
}
