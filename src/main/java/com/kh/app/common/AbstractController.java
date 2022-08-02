package com.kh.app.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.common.exception.MethodNotAllowedException;
/**
 * 전략 클래스
 *
 */
public abstract class AbstractController {
	/**
	 * 원래 서블릿에 있는 doGet은 void임.
	 * view단 처리부분을 편하게 하기 위해 반환값 문자열로
	 */
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		throw new MethodNotAllowedException("GET");
	}
	
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{		
		throw new MethodNotAllowedException("POST");
	}
}
