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

public class StudentController extends AbstractController {
	
	static final Logger log = Logger.getLogger(StudentController.class);
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 입력값처리
		int no = Integer.parseInt(request.getParameter("no"));
		log.debug(no);
		
		//업무로직 - 1명 조회
		Student student = studentService.selectOneStudent(no);
		log.debug(student);
		
		//json응답처리
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(student, response.getWriter());
		
		return null;//비동기요청이라 null로 return
	}
}
