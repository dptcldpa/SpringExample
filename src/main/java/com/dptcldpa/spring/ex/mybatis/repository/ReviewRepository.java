package com.dptcldpa.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dptcldpa.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// SELECT 쿼리

	// 전달된 id와 일치하는 리뷰 행 조회
	public Review selectReview(@Param("id") int id);

	
	// INSERT 쿼리
	
	// 전달받은 리뷰 정보를 기반으로 insert한다.
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	
	
	// 전달받은 Review 객체로 insert한다.
	public int insertReviewByObject(Review review);
	
}
