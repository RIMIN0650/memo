package com.rimin.spring.memo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	@GetMapping("/user/join-view") // 파라미터 없으므로 get mapping
	public String inputJoin(){
		return "user/join";
	}
	
	
	
}
