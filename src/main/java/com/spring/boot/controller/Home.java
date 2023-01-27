package com.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Home {

	/*
	 * HTML은 request(/WEB-INF/views/home.html)를 받을 수 없음(호출 실패)
	 * JSP는 request(/WEB-INF/views/home.jsp)를 받을 수 있음(호출 성공)
	 */
	@GetMapping("")
	public String doHome() {
		return "/WEB-INF/views/home/home.jsp";
	}
	
	@GetMapping("/record")
	public String dorecord() {
		return "/WEB-INF/views/home/record.jsp";
	}
	
	@GetMapping("/member_list")
	public String domember() {
		return "/WEB-INF/views/home/member_list.jsp";
	}
}

