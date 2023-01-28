package com.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.service.StudyService;

@Controller
@RequestMapping("/home")
public class Home {

	/*
	 * HTML은 request(/WEB-INF/views/home.html)를 받을 수 없음(호출 실패)
	 * JSP는 request(/WEB-INF/views/home.jsp)를 받을 수 있음(호출 성공)
	 */
	
	/* Service를 가져오기 위해 @Autowired 사용 */
	@Autowired
	StudyService studyService;

	@GetMapping("")
	public String doHome() {
		return "/home/home";
	}
	
	@GetMapping("/record")
	@ResponseBody
	public String dorecord() {
		List<Map<String, String>> list = new ArrayList<>();
		list = studyService.doStudyList();
		
		for(Map<String, String> map : list) {
		    System.out.println(map.get("KEY_ID"));
		    System.out.println(map.get("STUDY_DAY"));
		    System.out.println(map.get("CONTENTS"));
		    System.out.println(map.get("REG_DAY"));
		}		
		return "---";
	}
	
	@GetMapping("/member_list")
	public String domember() {
		return "/home/member_list";
	}
}

