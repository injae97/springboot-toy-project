package com.spring.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("record_reg")
public class record_reg {

	/* Insert(등록) 
	 * 입력이 a tag Mapping으로 들어왔기 때문에 GetMapping
	 */
	@GetMapping("/insert")
	public String doInsert() {
		return "";
	}
	
	
	/* Upate(수정) */
	@GetMapping("/modify")
	public String doModify(HttpServletRequest request) {
		String strKeyId = request.getParameter("key_id");
		return "/record/record_modify";
	}
	
	
	/* Delete(삭제) */
	@GetMapping("/delete")
	public String doDelete() {
		return "";
	}
}