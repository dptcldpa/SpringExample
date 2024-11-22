package com.dptcldpa.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dptcldpa.spring.ex.jpa.domain.Student;
import com.dptcldpa.spring.ex.jpa.repository.StudentRepository;
import com.dptcldpa.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// 절대 Controller에서 Respository 활용하면 안됨
	// 임시로 이번만 하는 것!!!!
	@Autowired
	private StudentRepository studentRepository;
	
	// create, update, delete
	
	// create
	// 한 학생의 정보 저장 기능
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent() {
		
		// 김철수, 010-1234-5678, dptcldpa@gmail.com, 개발자
		Student student = studentService.addStudent("김철수", "101-1234-5678", "dptcldpa@gmail.com", "개발자");
		
		return student;
		
	}
	
	// update
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		
		// id가 3인 장래희망을 강사로 변경
		Student student = studentService.updateStudent(3, "강사");
		
		return student;
		
	}

	// delete
	@ResponseBody
	@GetMapping("/delete")
	public String deleteStudent() {
		
		// id가 3인 학생정보 삭제
		studentService.deleteStudent(3);
		
		return "삭제!";
		
	}
	
	// select
	@ResponseBody
	@GetMapping("/find")
	public List<Student> findStudent() {
		
		List<Student> studentList =  null;
		// 모든 행 조회
//		List<Student> studentList =  studentRepository.findAll();
		
		// 모든 행을 id 컬럼 내림차순으로 조회
//		studentList = studentRepository.findAllByOrderByIdDesc();
		
//		studentList = studentRepository.findTop2ByOrderByIdDesc();
		
//		studentList = studentRepository.findByName("김인규");
		
		List<String> nameList = new ArrayList<>();
		nameList.add("유재석");
		nameList.add("조세호");
		
//		studentList = studentRepository.findByNameIn(nameList);
		
//		studentList = studentRepository.findByEmailContaining("gmail");
		
//		studentList = studentRepository.findByIdBetweenOrderByIdDesc(2, 5);
		
		studentList = studentRepository.selectByDreamJob("모델");
		
		return studentList;
		
	}
	

	@ResponseBody
	@GetMapping("/lombok")
	public Student lombokTest() {
		
//		Student student = new Student(1, "김철수", "010-1234-5678", "dptcldpa@gmail.com", "개발자", null, null);
//		student.setName("김철수");
//		student.setEmail("dptcldpa@gmail.com");
//		student.setPhoneNumber("010-1234-5678");
		
		// builder 패턴
		Student student = Student.builder()
				.name("김철수")
				.email("dptcldpa@gmail.com")
				.phoneNumber("010-1234-5678")
				.build();
		
		return student;
		
	}
	
}
