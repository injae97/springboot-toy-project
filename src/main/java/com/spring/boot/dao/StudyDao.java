package com.spring.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.vo.Vo_record;

@Mapper
public interface StudyDao {
	
	/* public List<Map<String, String>> doStudyList(); // Mapper(resultType = map) */
	public List<Vo_record> doStudyList(); // 기록 전체 리스트: VO 객체로 반환
	
	/* One row Select: VO 객체로 반환(strKeyId 값을 그대로 전달) */
	public Vo_record doStudyListOne(String strKeyId); 
	
	/* 기록 수정 (UPDATE) - 컨트롤러에서 VO객체를 사용했기 때문에 VO 파라미터 설정 */
	public int doStudyUp(Vo_record vo_record);
	
	/* 기록 삭제(DELETE) - 컨트롤러에서 String strKeyId로 받았기 때문에 그대로 사용 */
	public int doStudyDel(String strKeyId);
}