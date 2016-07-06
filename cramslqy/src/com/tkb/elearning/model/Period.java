package com.tkb.elearning.model;

import java.sql.Timestamp;

/**
 * 屆別管理
 * @author Admin
 * @version 創建時間：2016-04-18
 */
public class Period {

	private Integer id ; 				
	private String period_name;    			//屆別名稱
	private Integer class_no;				//屆別(數字)
	private String period_start;			//開始日
	private String period_end;				//結束日	
	private String status;              	//狀態
	private Timestamp create_date;			//建立日期
	

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPeriod_name() {
		return period_name;
	}
	
	public void setPeriod_name(String period_name) {
		this.period_name = period_name;
	}	
	
	public Integer getClass_no() {
		return class_no;
	}

	public void setClass_no(Integer class_no) {
		this.class_no = class_no;
	}

	public String getPeriod_start() {
		return period_start;
	}
	
	public void setPeriod_start(String period_start) {
		this.period_start = period_start;
	}
	
	public String getPeriod_end() {
		return period_end;
	}
	
	public void setPeriod_end(String period_end) {
		this.period_end = period_end;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Timestamp getCreate_date() {
		return create_date;
	}
	
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	
}
