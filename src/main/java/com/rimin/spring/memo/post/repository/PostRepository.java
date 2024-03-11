package com.rimin.spring.memo.post.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostRepository {
	
	public int saveMemo(
			@Param("title") String title
			, @Param("content") String content);
	
	
	
	
}
