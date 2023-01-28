package com.spring.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.vo.Vo_record;

@Mapper
public interface StudyDao {
	
	// public List<Map<String, String>> doStudyList(); // Mapper(resultType = map)
	public List<Vo_record> doStudyList(); // VO 객체로 반환

}