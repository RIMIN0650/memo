package com.rimin.spring.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rimin.spring.memo.user.service.UserService;

// API 를 만들기 위한 Controller
// @Controller + @ResponseBody > @RestController
@RestController
public class UserRestController {
	// view : response html
	// api : response data 채우기 위해 json
	
	// 모든 메소드에 다 response body @ 들어가야하는데 @RestController이므로 붙일 필요 없음
	
	
	@Autowired
	private UserService userService;
	
	
	// 회원가입 API
	@PostMapping("/user/join")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("email") String email){
		
		int count = userService.addUser(loginId, password, name, email);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result",  "fail");
		}
		
		return resultMap;
		
	}
	

	
}
