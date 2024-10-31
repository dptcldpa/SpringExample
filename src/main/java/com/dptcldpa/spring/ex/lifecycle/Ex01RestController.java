package com.dptcldpa.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 해당 클래스의 모든 메소드에 @ResponseBody가 적용된다.
@RestController // @RestController = @Controller + @ResponseBody
@RequestMapping("/lifecycle/ex01") // url이 공통된 부분이 있다면 맨 위에 공통된 부분을 작성하기
public class Ex01RestController {
	
	// 직접 만든 클래스 객체 리턴
//	@ResponseBody // 이미 있기 때문에 작성 안해도 됨
	@RequestMapping("/3")
	public Person objectResponse() {
		Person me = new Person("조해민", 31);
		
		return me;
	}
	
	// status code 적용 : 오청에 대한 처리의 상태를 코드로 작성 (HTTP status code)
	// 400 : 파라미터
	// 500 : 서버 에러
	// 검사 > 네트워크 에서 확인 가능함
	
	// status code 임의로 변경
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse() {
		
		Person me = new Person("조해민", 31);
		
		ResponseEntity<Person> entity = new ResponseEntity(me, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
		
	}
	
}
