package com.tkb.elearning.model;

import java.sql.Timestamp;

/**
 * 地區管理
 * @author Admin
 * @version 創建時間：2016-03-11
 */
public class Zone {
	private int id;
	private String zone_name;
	private int sort;
	private Integer status;
	private Timestamp create_date;

		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZone_name() {
		return zone_name;
	}
	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	
}
