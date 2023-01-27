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
		return "/home/home";
	}
	
	@GetMapping("/record")
	public String dorecord() {
		return "/home/record";
	}
	
	@GetMapping("/member_list")
	public String domember() {
		return "/home/member_list";
	}
}

