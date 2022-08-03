package com.kh.app.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.kh.app.common.AbstractController;
import com.kh.app.student.model.dto.Student;
import com.kh.app.student.model.service.StudentService;

public class StudentUpdateController extends AbstractController{
	static final Logger log = Logger.getLogger(StudentUpdateController.class);
	private StudentService studentService;

	public StudentUpdateController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//입력값처리
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Student student = new Student();
		student.setNo(no);
		student.setName(name);
		student.setTel(tel);
		log.debug(student);
		
		//업무로직
		int result = studentService.updateStudent(student);
		
		//응답(JSON)
		response.setContentType("application/json; charset=ust-8");
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "학생정보 변경 성공");
		new Gson().toJson(map, response.getWriter());
		
		return null;
	}
}
