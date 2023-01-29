package com.spring.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.vo.Vo_record;

@Mapper
public interface StudyDao {
	
	// public List<Map<String, String>> doStudyList(); // Mapper(resultType = map)
	public List<Vo_record> doStudyList(); // 기록 전체 리스트: VO 객체로 반환
	
	public Vo_record doStudyListOne(String strKeyId); // [UPDATE] 기록 One row: VO 객체로 반환(strKeyId 값을 그대로 전달)	
	
}