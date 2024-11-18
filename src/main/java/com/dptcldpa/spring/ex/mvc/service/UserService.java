package com.dptcldpa.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dptcldpa.spring.ex.mvc.domain.User;
import com.dptcldpa.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public int addUser(
			String name
			, String birthday
			, String email
			, String introduce) {
		
		int count = userRepository.insertUser(name, birthday, email, introduce);
		
		return count;
		
	}
	
	public int addUserByObject(User user) {
		int count = userRepository.insertUserByObject(user);
		
		return count;
	}
	
	public User getLastUser() {
		User user = userRepository.selectLastUser();
		
		return user;
	}
	
	
	// 이메일을 전달받고, 이전에 있었는지 없었는지 확인
	public boolean isDuplicateEmail(String email) {
		
		int count = userRepository.countByEmail(email);
		
		if(count > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
