package com.spring.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.service.StudyService;
import com.spring.boot.vo.Vo_record;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("record_reg")
public class record_reg {

	/* @Autowired: 서비스 주입 */
	@Autowired
	StudyService studyService;	
	
	
	/* 수정 화면 페이지(게시글 수정 눌렀을 때 기존 데이터 들고옴) - 고전적인 방식 */
	@GetMapping("/modify")
	public String doModify(HttpServletRequest request) {
		String strKeyId = request.getParameter("key_id");
		
		Vo_record vo_record = new Vo_record();
		vo_record = studyService.doStudyListOne(strKeyId); // 인자 값을 strKeyId로 던져줌
		
		request.setAttribute("vo_record", vo_record); // request에서 vo_record 값을 담아서 저장
		
		return "/record/record_modify";
	}
	
	/*
	 * [UPDATE] - 수정(VO 사용) 
	 * @ModelAttribute: 쿼리 스트링 자동 매핑  
	 */
	@PostMapping("/modify_exe")
	public String doModExe(@ModelAttribute Vo_record vo_record) {
		
		int intI = studyService.doStudyUp(vo_record); // Mybatis - UPDATE는 int형으로 반환
				
		return "redirect:/home/record"; // home.java(Controller)을 그대로 호출 
	}
	
	
	/*
	 * [DELETE] - 삭제
	 * /SpringBoot-Record/src/main/webapp/WEB-INF/views/home/record.jsp 
	 * <div class="col"><a href="/record_reg/delete?key_id=<%= vo_record.getKeyId() %>">삭제</a></div> 
	 * 넘어올 때 key_id로 넘어오는것을 알 수 있기 때문에 key_id로 DELETE(삭제) 해주면 됨 
	 */
	@GetMapping("/delete")
	public String doDel(@RequestParam(value="key_id", defaultValue = "--") String strKeyId) {
		int intI = studyService.doStudyDel(strKeyId); // Mybatis - DELETE는 int형으로 반환
		log.info("intI ========>" + intI);
		return "redirect:/home/record"; // home.java(Controller)을 그대로 호출 
	}
	
	/*
	 * [INSERT] - 등록(수정 할때와 비슷)
	 * 화면 이동이기 때문에 @GetMapping 사용
	 */
	@GetMapping("/insert")
	public String doIns() {
		return "/record/record_ins";
	}
	
	/*
	 * [INSERT] - 등록하기 버튼 실행
	 * 화면 이동이기 때문에 @GetMapping 사용
	 */
	@PostMapping("/insert_exe")
	public String doInsExe(@ModelAttribute Vo_record vo_record) {
		
		int intI = studyService.doStudyIns(vo_record); // Mybatis - INSERT는 int형으로 반환
				
		return "redirect:/home/record"; // home.java(Controller)을 그대로 호출 
	}
}