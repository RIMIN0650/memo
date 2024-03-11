package com.rimin.spring.memo.post;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rimin.spring.memo.post.service.PostService;

@RestController
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
	// 메모 제목, 내용, 이미지파일 저장
	@PostMapping("/post/create")
	public Map<String, String> createMemo(
			@RequestParam("title") String title
			, @RequestParam("content") String content){
		
		
		
	}
	
	
	
}
