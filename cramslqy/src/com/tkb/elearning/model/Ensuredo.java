package com.tkb.elearning.model;

import java.sql.Timestamp;

public class Ensuredo {
    
	//品保有什麼能服務的
	private int id;            		    //品保有什麼能服務的-id
	private String do_title;      		//品保有什麼能服務的-標題
	private String do_content;	  		//品保有什麼能服務的-內文
	private Timestamp create_date;		//創建日期
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDo_title() {
		return do_title;
	}
	public void setDo_title(String do_title) {
		this.do_title = do_title;
	}
	public String getDo_content() {
		return do_content;
	}
	public void setDo_content(String do_content) {
		this.do_content = do_content;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	
}
