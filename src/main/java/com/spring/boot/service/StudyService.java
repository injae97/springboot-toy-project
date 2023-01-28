package com.spring.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dao.StudyDao;
import com.spring.boot.vo.Vo_record;

@Service
public class StudyService {
	
	/* Service에서 Dao 값을 가져오기 위해 @Autowired 사용 */
    /* return : Map
    @Autowired
	StudyDao studyDao;
	public List<Map<String, String>> doStudyList() {
		List<Map<String, String>> list = new ArrayList<>();
		list = studyDao.doStudyList();
		return list;
	}
	*/
	
	
	/* 
	 * returnType : VO
	 */
	@Autowired
	StudyDao studyDao;
	public List<Vo_record> doStudyList() {
		List<Vo_record> list = new ArrayList<>();
		list = studyDao.doStudyList();
		return list;
	}
}