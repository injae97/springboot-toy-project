package com.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class First {

	@GetMapping("")
	public String doFirst() {
		return "/home/home";
	}
}
