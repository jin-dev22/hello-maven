package com.kh.app.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.common.AbstractController;
import com.kh.app.student.model.dto.Student;
import com.kh.app.student.model.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequiredArgsConstructor
public class SelectListController extends AbstractController {
	
	private final StudentService studentService;
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//학생목록 조회
		List<Student> list = studentService.selectStudentList();
		log.debug("list>>>"+list);
		
		List<Map<String, Object>> mapList = studentService.selectStudentMapList();
		log.debug("mapList>>>"+mapList);
		
		//jsp 전달
		request.setAttribute("list", list);
		request.setAttribute("mapList", mapList);
		
		return "student/selectList";
	}
}
