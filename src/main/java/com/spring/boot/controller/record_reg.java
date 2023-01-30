package com.spring.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.boot.service.StudyService;
import com.spring.boot.vo.Vo_record;

@Controller
@RequestMapping("record_reg")
public class record_reg {

	/* @Autowired: 서비스 주입 */
	@Autowired
	StudyService studyService;	
	
	/* Insert(등록) 
	 * 입력이 a tag Mapping으로 들어왔기 때문에 GetMapping
	 */
	@GetMapping("/insert")
	public String doInsert() {
		return "";
	}
	
	/* 수정 화면 페이지(게시글 수정 눌렀을 때 기존 데이터 들고옴) - 고전적인 방식 */
	@GetMapping("/modify")
	public String doModify(HttpServletRequest request) {
		String strKeyId = request.getParameter("key_id");
		
		Vo_record vo_record = new Vo_record();
		vo_record = studyService.doStudyListOne(strKeyId); // 인자 값을 strKeyId로 던져줌
		
		request.setAttribute("vo_record", vo_record); // request에서 vo_record 값을 담아서 저장
		
		return "/record/record_modify";
	}
	
	/* Upate(수정) - VO 사용 */
	/* @ModelAttribute: 쿼리 스트링 자동 매핑  */
	@PostMapping("/modify_exe")
	public String doModExe(@ModelAttribute Vo_record vo_record) {
		
		int intI = studyService.doStudyUp(vo_record); // Mybatis - Update는 int형으로 반환
				
		return "redirect:/home/record"; // home.java(Controller)을 그대로 호출 
	}
	
	
	/* Delete(삭제) */
	@GetMapping("/delete")
	public String doDelete() {
		return "";
	}
}