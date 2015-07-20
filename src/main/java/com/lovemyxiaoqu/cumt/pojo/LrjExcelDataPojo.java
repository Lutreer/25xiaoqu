package com.lovemyxiaoqu.cumt.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LrjExcelDataPojo {
	
	@JsonProperty("modifyDate")
	private String modifyDate;
	
	@JsonProperty("randomMin")
	private Float randomMin;
	
	@JsonProperty("randomMax")
	private Float randomMax;
	
	
	public Float getRandomMin() {
		return randomMin;
	}
	public void setRandomMin(Float randomMin) {
		this.randomMin = randomMin;
	}
	public Float getRandomMax() {
		return randomMax;
	}
	public void setRandomMax(Float randomMax) {
		this.randomMax = randomMax;
	}

	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	
}
