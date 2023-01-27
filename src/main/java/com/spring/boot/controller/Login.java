package com.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class Login {

	@GetMapping("login")
	public String dologin() {
		return "/login/login";
	}
	
	@GetMapping("join")
	public String dojoin() {
		return "/login/join";
	}
}
