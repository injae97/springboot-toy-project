package com.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.service.MemberService;
import com.spring.boot.vo.Vo_member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("member")
public class Member_reg {

	/* @Autowired: 서비스 주입 */
	@Autowired
	MemberService memberService;	
	
	/* 전체 화면 조회 */
	@GetMapping("/list")
	public String doMemberList(Model model) {
		List<Vo_member> list = new ArrayList<>();
		list = memberService.doMemberList();
		
		model.addAttribute("list", list);
		return "/member/member_list";
	}
	
	/*
	 * [INSERT] - 등록(수정 할때와 비슷)
	 * 화면 이동이기 때문에 @GetMapping 사용
	 */
	@GetMapping("/insert")
	public String doIns() {
		return "/member/member_join";
	}
	
	/*
	 * [INSERT] - 등록하기 버튼 실행
	 * 화면 이동이기 때문에 @GetMapping 사용
	 */
	@PostMapping("/insert_exe")
	public String doInsExe(@ModelAttribute Vo_member vo_member) {
		
		int intI = memberService.doMemberIns(vo_member); // INSERT는 int형으로 반환
				
		return "redirect:/member/list"; // home.java(Controller)을 그대로 호출 
	}
		
	/* 수정 클릭시 기존 데이터 들고오면서 수정페이지로 이동 - 고전적인 방식 */
	@GetMapping("/modify")
	public String doMod(HttpServletRequest request) {
		String strMemberId = request.getParameter("strMemberId");
		
		Vo_member vo_member = new Vo_member();
		vo_member = memberService.doMemberListOne(strMemberId); // 인자 값을 strKeyId로 던져줌
		
		request.setAttribute("vo_member", vo_member); // request에서 vo_record 값을 담아서 저장
		
		return "/member/member_mod";
	}
	
	/*
	 * [UPDATE] - 수정 (VO 사용) 
	 * @ModelAttribute: 쿼리 스트링 자동 매핑  
	 */
	@PostMapping("/modify_exe")
	public String doModExe(@ModelAttribute Vo_member vo_member) {
		
		int intI = memberService.doMemberUp(vo_member); // UPDATE는 int형으로 반환
				
		return "redirect:/home/member_reg"; // home.java(Controller)을 그대로 호출 
	}
	
	/*
	 * [DELETE] - 삭제
	 * /SpringBoot-Record/src/main/webapp/WEB-INF/views/home/record.jsp 
	 * <div class="col"><a href="/record_reg/delete?key_id=<%= vo_record.getKeyId() %>">삭제</a></div> 
	 * 넘어올 때 key_id로 넘어오는것을 알 수 있기 때문에 key_id로 DELETE(삭제) 해주면 됨 
	 */
	@GetMapping("/delete")
	public String doDel(@RequestParam(value="memberId", defaultValue = "--") String strMemberId) {
		int intI = memberService.doMemberDel(strMemberId); // DELETE는 int형으로 반환
		log.info("intI ========>" + intI);
		return "redirect:/member/list"; // home.java(Controller)을 그대로 호출 
	}
}