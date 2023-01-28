package com.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	/* @ResponseBody 사용할 경우 jsp에서 view 화면 보여주지 않음 */
	@GetMapping("/record")
	public String dorecord(HttpServletRequest request, Model model) {
		List<Map<String, String>> list = new ArrayList<>();
		list = studyService.doStudyList();
		
		for(Map<String, String> map : list) {
		    System.out.println(map.get("KEY_ID"));
		    System.out.println(map.get("STUDY_DAY"));
		    System.out.println(map.get("CONTENTS"));
		    System.out.println(map.get("REG_DAY"));
		}		
		
		// request.setAttribute("list", list); -> request에서 담는 방법
	    model.addAttribute("list", list); // 모델에 담는 방법
		return "/home/record"; // return은 forward이기 때문에 request로 보낸 값을 보냄
	}
	
	@GetMapping("/member_list")
	public String domember() {
		return "/home/member_list";
	}
}

