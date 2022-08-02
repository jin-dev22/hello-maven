package com.kh.app;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class HelloworldServlet
 */
@WebServlet("/helloworld")
public class HelloworldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "안녕하세요");
		map.put("num", 1234567890);
		map.put("today", new Date());
		
		//gson의존을 maven을 통해 프로젝트에 주입받기
		//1. pom.xml에 의존 등록
		//2. gson의존을 지역 저장소에 다운 ----여기서부터는 메이븐이 함
		//3. project와 연결
		Gson gson = new Gson();
		response.setContentType("application/json; charset=utf-8");
		gson.toJson(map, response.getWriter());
	}

}
