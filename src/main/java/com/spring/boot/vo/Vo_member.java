package com.spring.boot.vo;

import lombok.Data;

@Data
public class Vo_member {
	
	/* DB보고 컬럼명을 카멜 케이스로 선언 */
	private String memberId;
	private String loginId;
	private String password;
	private String name;
	private String role;
	private String regDay;
}