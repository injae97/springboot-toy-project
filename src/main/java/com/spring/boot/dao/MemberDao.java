package com.spring.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.vo.Vo_member;

@Mapper
public interface MemberDao {
	
	/* 회원 목록 전체 리스트: VO 객체로 반환 */
	public List<Vo_member> doMemberList(); // public List<Map<String, String>> doStudyList(); ,Mapper(resultType = map)
	
	/* 회원 목록 - One row Select: VO 객체로 반환(strKeyId 값을 그대로 전달) */
	public Vo_member doMemberListOne(String strKeyId); 
	
	/* 회원 목록 수정 (UPDATE) - 컨트롤러에서 VO객체를 사용했기 때문에 VO 파라미터 설정 */
	public int doMemberUp(Vo_member vo_record);
	
	/* 회원 목록 삭제(DELETE) - 컨트롤러에서 String strKeyId로 받았기 때문에 그대로 사용 */
	public int doMemberDel(String strKeyId);
	
	/* 회원 목록 등록(INSERT) - 컨트롤러에서 VO객체를 사용했기 때문에 VO 파라미터 설정 */
	public int doMemberIns(Vo_member vo_record);
}