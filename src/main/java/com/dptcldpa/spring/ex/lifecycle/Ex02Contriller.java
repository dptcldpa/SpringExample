package com.dptcldpa.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Contriller {
	
	@RequestMapping("/lifecycle/ex02")
	public String thymeleafEx() {
		return "lifecycle/ex02"; // html 생략 가능, html 경로는 앞의 / 생략
	}

}
