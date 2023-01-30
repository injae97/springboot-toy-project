package com.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dao.MemberDao;
import com.spring.boot.vo.Vo_member;

@Service
public class MemberService {
		
	@Autowired
	MemberDao memberDao;
	
	/* 맴버 리스트 - 회원 전체 조회 */
	public List<Vo_member> doMemberList() {
		List<Vo_member> list = new ArrayList<>();
		list = memberDao.doMemberList();
		return list;
	}
	
	/* 
	 * One Row Select 
	 * returnType : VO
	 */
	public Vo_member doMemberListOne(String strMemberId) {
		Vo_member vo_member = memberDao.doMemberListOne(strMemberId); // strMemberId 값을 그대로 전달
		return vo_member;
	}
	
	/* 
	 * [UPDATE] - 회원 수정
	 * /src/main/java/com/spring/boot/controller/record_reg.java 에서 VO객체(@ModelAttribute 사용했기 때문에 VO객체로 맞춤)
	 */
	public int doMemberUp(Vo_member vo_member) {
		int intI = memberDao.doMemberUp(vo_member); // UPDATE는 int형으로 반환
		return intI;
	}
	
	/* 
	 * [DELETE] - 회원 삭제
	 * /src/main/java/com/spring/boot/controller/record_reg.java 에서 @RequestParam 사용
	 */	
	public int doMemberDel(String strMemberId) {
		int intI = memberDao.doMemberDel(strMemberId); // DELETE는 int형으로 반환
		return intI;
	}
	
	/* 
	 * [INSERT] - 회원 등록
	 * /src/main/java/com/spring/boot/controller/record_reg.java 에서 VO객체(@ModelAttribute 사용했기 때문에 VO객체로 맞춤)
	 */
	public int doMemberIns(Vo_member vo_member) {
		int intI = memberDao.doMemberIns(vo_member); // INSERT는 int형으로 반환
		return intI;
	}
}