package com.rimin.spring.memo.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.spring.memo.user.domain.User;

@Mapper
public interface UserRepository {
	
	// 사용자 추가
	public int insertUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("name") String name
			, @Param("email") String email);
	
	
	// 일치하는 행은 하나이거나 0개임
	public User selectUser(
			@Param("loginId") String loginId
			, @Param("password") String password);
	
	
}
