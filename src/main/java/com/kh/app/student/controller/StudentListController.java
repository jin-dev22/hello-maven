package com.kh.app.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.common.AbstractController;
import com.kh.app.student.model.service.StudentService;

public class StudentListController extends AbstractController {
	
	private StudentService studentService;
	
	public StudentListController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//학생목록 조회
		
		return "student/studentList";
	}
}
