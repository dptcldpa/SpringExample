package com.dptcldpa.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dptcldpa.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {

	public int insertUser(
			@Param("name") String name
			, @Param("birthday") String birthday
			, @Param("email") String email
			, @Param("introduce") String introduce);
	
	public int insertUserByObject(User user);
	
	public User selectLastUser();
	
}