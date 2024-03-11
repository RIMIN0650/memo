package com.rimin.spring.memo.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rimin.spring.memo.post.domain.Post;
import com.rimin.spring.memo.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RestController
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
	
	// 메모 제목, 내용, 이미지파일 저장
	@PostMapping("/post/create")
	public Map<String, String> createMemo(
			@RequestParam("title") String title
			, @RequestParam("contents") String contents
			, HttpSession session) {
		
		// 로그인한 사용자의 pk 를 얻어온다.
		// 세션의 "userId" 키로 저장되어있다 (로그인 할 때 저장)
		
		int userId = (Integer)session.getAttribute("userId");
		//getAttribute : object return
		
		
		Post post = postService.addPost(userId, title, contents);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(post != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	

}
