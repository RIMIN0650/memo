package com.rimin.spring.memo.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.memo.post.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public int createMemo(String title, String content) {
		return postRepository.saveMemo(title, content);
	}
	
	
	
}
