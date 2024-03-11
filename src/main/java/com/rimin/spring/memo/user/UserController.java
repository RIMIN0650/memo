package com.rimin.spring.memo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	// jsp 경로 return
	// > responsebody annotation 안붙음
	@GetMapping("/user/join-view") // 파라미터 없으므로 get mapping
	public String inputJoin(){
		return "user/join";
	}
	
	
	//로그인 기능
	@GetMapping("/user/log-in")
	public String logIn() {
		return "user/login";
	}
	
	//로그아웃
	@GetMapping("/user/logout")
	public String logout(HttpServletRequest request){
		// 세션에 사용자 정보 저장하면 로그인
		// > 세션에 저장된 사용자 정보를 제거하면 로그아웃
		
		HttpSession session = request.getSession();
		// userId, userName 이라는 값 저장했으므로
		// 위의 두 값 지우기
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		// 로그인 페이지로 redirect
		return "redirect:/user/log-in";
	}
	
	
	
}
