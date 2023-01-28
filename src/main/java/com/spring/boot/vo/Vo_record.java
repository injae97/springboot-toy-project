package com.spring.boot.vo;

import lombok.Data;

@Data
public class Vo_record {
	
	private String KEY_ID;
	private String STUDY_DAY;
	private String CONTENTS;
	private String REG_DAY;
		
	/* 
	// Constructor
	public Vo_record(String kEY_ID, String sTUDY_DAY, String cONTENTS, String rEG_DAY) {
		super();
		KEY_ID = kEY_ID;
		STUDY_DAY = sTUDY_DAY;
		CONTENTS = cONTENTS;
		REG_DAY = rEG_DAY;
	}
	
	// Getter & Setter
	public String getKEY_ID() {
		return KEY_ID;
	}
	public void setKEY_ID(String kEY_ID) {
		KEY_ID = kEY_ID;
	}
	public String getSTUDY_DAY() {
		return STUDY_DAY;
	}
	public void setSTUDY_DAY(String sTUDY_DAY) {
		STUDY_DAY = sTUDY_DAY;
	}
	public String getCONTENTS() {
		return CONTENTS;
	}
	public void setCONTENTS(String cONTENTS) {
		CONTENTS = cONTENTS;
	}
	public String getREG_DAY() {
		return REG_DAY;
	}
	public void setREG_DAY(String rEG_DAY) {
		REG_DAY = rEG_DAY;
	}	
	*/
}