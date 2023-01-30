package com.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	/* 
	 * One Row Select 
	 * returnType : VO
	 */
	public Vo_record doStudyListOne(String strKeyId) {
		Vo_record vo_record = new Vo_record(); 
		vo_record = studyDao.doStudyListOne(strKeyId); // strKeyId 값을 그대로 전달
		return vo_record;
	}
	
	
	/* 
	 * [UPDATE] - 기록 수정
	 * /src/main/java/com/spring/boot/controller/record_reg.java 에서 VO객체(@ModelAttribute 사용했기 때문에 VO객체로 맞춤)
	 * UPDATE 할 때 int로 받기로 컨트롤러에 선언했기 때문에 int형 
	 */
	public int doStudyUp(Vo_record vo_record) {
		int intI = studyDao.doStudyUp(vo_record); //  Mybatis - Update는 int형으로 반환
		return intI;
	}
	
	
	/* 
	 * [DELETE] - 기록 삭제
	 * /src/main/java/com/spring/boot/controller/record_reg.java 에서 @RequestParam 사용
	 * DELETE 할 때 int로 받기로 컨트롤러에 선언했기 때문에 int형 
	 */	
	public int doStudyDel(String strKeyId) {
		int intI = studyDao.doStudyDel(strKeyId); //  Mybatis - DELETE는 int형으로 반환
		return intI;
	}
	
	
	/* 
	 * [INSERT] - 기록 등록
	 * /src/main/java/com/spring/boot/controller/record_reg.java 에서 VO객체(@ModelAttribute 사용했기 때문에 VO객체로 맞춤)
	 * INSERT 할 때 int로 받기로 컨트롤러에 선언했기 때문에 int형 
	 */
	public int doStudyIns(Vo_record vo_record) {
		int intI = studyDao.doStudyIns(vo_record); //  Mybatis - INSERT는 int형으로 반환
		return intI;
	}
}