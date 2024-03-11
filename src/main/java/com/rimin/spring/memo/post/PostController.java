package com.rimin.spring.memo.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	
	@GetMapping("/post/list-view")
	public String postList() {
		return "/post/list";
	}
	
	@GetMapping("/post/post-memo")
	public String postMemo() {
		return "post/postMemo";
	}
	
}
