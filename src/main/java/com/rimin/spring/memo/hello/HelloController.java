package com.rimin.spring.memo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@ResponseBody
	@PostMapping("/hello")
	public String helloWorld() {
		return "Hello 123 World!!";
	}
}
