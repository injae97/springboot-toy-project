package com.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.boot.service.StudyService;
import com.spring.boot.vo.Vo_record;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/home")
public class Home {

	/* Service를 가져오기 위해 @Autowired 사용 */
	@Autowired
	StudyService studyService;

	@GetMapping("")
	public String doHome() {
		return "/home/home";
	}
	
	/* return type : mapUnderscoreToCamelCase(VO 객체) */
	@GetMapping("/record")
	public String dorecord(HttpServletRequest request, Model model) {
		List<Vo_record> list = new ArrayList<>();
		list = studyService.doStudyList();
		
		/*
		// Getter & Setter 사용
		log.info("Vo_record");
		for(Vo_record vo_record : list) {
			log.info(vo_record.getKeyId());
			log.info(vo_record.getStudyDay());
			log.info(vo_record.getContents());
			log.info(vo_record.getRegDay());
		}		
		*/
		
		 request.setAttribute("list", list); // request에서 담는 방법
	    // model.addAttribute("list", list); // 모델에 담는 방법
		return "/home/record"; // return은 forward이기 때문에 request로 보낸 값을 보냄
	}

	/* ★ 회원 가입 시 해당 파일로 매핑(여기 부분 수정) ★ */
	@GetMapping("/member_list")
	public String domember() {
		return "/home/member_list";
	}
}
