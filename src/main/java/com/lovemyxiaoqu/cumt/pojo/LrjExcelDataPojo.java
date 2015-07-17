package com.lovemyxiaoqu.cumt.pojo;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LrjExcelDataPojo {

	private String modifyDate;
	private String randomMin;
	private String randomMax;
	
	
	public String getRandomMin() {
		return randomMin;
	}
	public void setRandomMin(String randomMin) {
		this.randomMin = randomMin;
	}
	public String getRandomMax() {
		return randomMax;
	}
	public void setRandomMax(String randomMax) {
		this.randomMax = randomMax;
	}

	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	
}
