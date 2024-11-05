package com.dptcldpa.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dptcldpa.spring.ex.mybatis.domain.Review;
import com.dptcldpa.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;

	// 전달받은 id와 대응되는 리뷰정보 얻어오기
	public Review getReview(int id) {
		// new_review 테이블의 id가 전달받은 값과 일치하는 행 조회 
		Review review = reviewRepository.selectReview(id);
		
		return review;
		
	}
	
}
