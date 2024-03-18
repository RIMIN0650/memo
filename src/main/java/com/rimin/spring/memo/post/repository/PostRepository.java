package com.rimin.spring.memo.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimin.spring.memo.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	// userId 컬럼 값이 일치하는 행 조회
	// WHERE `userId` = #{userId} ORDER BY `id` DESC
	// 한 행을 조회하기 위한 entity 클래스 : Post
	public List<Post> findByUserIdOrderByIdDesc(int userId);
	 
}
