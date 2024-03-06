package com.rimin.spring.memo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	// jsp 경로 return
	// > responsebody annotation 안붙음
	@GetMapping("/user/join-view") // 파라미터 없으므로 get mapping
	public String inputJoin(){
		return "user/join";
	}
	
	
	
	@GetMapping("/user/log-in")
	public String logIn() {
		return "user/login";
	}
	
	
	
}
