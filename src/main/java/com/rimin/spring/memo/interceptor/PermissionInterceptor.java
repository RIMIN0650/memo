package com.rimin.spring.memo.interceptor;

import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PermissionInterceptor implements HandlerInterceptor {
	
	// prehandle : 전달되는 과정
	
	// posthandle
	
	@Override
	public boolean preHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId"); // null 처리하기 위해 Integer userId
		
		
		// /post/list-view
		String uri = request.getRequestURI();
		
		
		// 로그인 안 된 상태에서 리스트 페이지, 게시글 작성 페이지, 메모 보기 페이지 접근 막기
		// 메모 게시글과 관련된 모든 페이지 접근을 막고
		// 로그인 페이지로 이동
		if(userId == null) {
			// /post로 시작하는 주소의 요청만 조건으로 만들어냄
			if(uri.startsWith("/post")) {
				// 로그인 페이지로 리다이렉트
				response.sendRedirect("/user/log-in");
				return false;
			}
		
		} else {
			// 로그인이 된 경우 > 로그인과 관련된 페이지를 접근하지 못하도록 막아줌
			// /user로 시작하는 주소의 요청만 조건으로 만들어냄
			// > 리스트 페이지로 이동
			if(uri.startsWith("/user")) {
				response.sendRedirect("/post/list-view");
				return false;
			}
		}
		
		return true;
		
	}
	
}
