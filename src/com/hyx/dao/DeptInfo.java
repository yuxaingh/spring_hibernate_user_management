package com.hyx.dao;

public class DeptInfo {
	private Integer number;
	private String name;
	private String createDate;
	private String remark;
	
	public DeptInfo() {
		
	}
	
	public DeptInfo(String name, String createDate, String remark) {
		this.name = name;
		this.createDate = createDate;
		this.remark = remark;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
