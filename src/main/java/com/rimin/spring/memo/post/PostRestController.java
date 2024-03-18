package com.rimin.spring.memo.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
			, @RequestParam(value="imageFile", required=false) MultipartFile file
			, HttpSession session) {
		
		// 로그인한 사용자의 pk 를 얻어온다.
		// 세션의 "userId" 키로 저장되어있다 (로그인 할 때 저장)
		
		int userId = (Integer)session.getAttribute("userId");
		//getAttribute : object return
		
		
		Post post = postService.addPost(userId, title, contents, file);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(post != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	
	// 메모 수정 api
	@PutMapping("/post/update")
	public Map<String, String> updateMemo(
			@RequestParam("id") int id
			, @RequestParam("title") String title
			, @RequestParam("contents") String contents){
		
		Post post = postService.updatePost(id, title, contents);
		// 수정된 결과의 객체 return 해줌
		
		Map<String, String> resultMap = new HashMap<>();
		if(post != null) {
			// 수정 완료
			resultMap.put("result", "success");
		} else {
			// 수정 실패
			resultMap.put("result", "fail");
		}
		return resultMap;
		
	}
	
	
	@DeleteMapping("/post/delete")
	public Map<String, String> deleteMemo(@RequestParam("id") int id){
		
		// id 기반으로 조회된 
		Post post = postService.deletePost(id);
		
		Map<String, String> resultMap = new HashMap<>();
		if(post != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	
	
	

}
