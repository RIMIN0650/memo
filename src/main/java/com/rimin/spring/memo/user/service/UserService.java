package com.rimin.spring.memo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.spring.memo.common.EncryptUtils;
import com.rimin.spring.memo.user.domain.User;
import com.rimin.spring.memo.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public int addUser(String loginId, String password, String name, String email){
		// 비밀번호 암호화
		String encryptPassword = EncryptUtils.md5(password);
		return userRepository.insertUser(loginId, encryptPassword, name, email);
	}
	
	
	
	public User getUser(String loginId, String password){
		String encryptPassword = EncryptUtils.md5(password);
		return userRepository.selectUser(loginId, encryptPassword);
	}
	
	
	
}
