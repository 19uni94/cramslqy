package com.tkb.elearning.model;

import java.sql.Timestamp;

/**
 * 最新消息
 * @author Admin
 * @version 創建時間：2016-03-15
 */
public class News {

	private int id;
	private String title;	
	private String news_start;
	private String news_end;
	private int index_show;
	private String image;
	private String brief_introduction;
	private String content;
	private int top;
	private Timestamp create_date;
	private Timestamp update_date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
	public String getNews_start() {
		return news_start;
	}
	public void setNews_start(String news_start) {
		this.news_start = news_start;
	}
	public String getNews_end() {
		return news_end;
	}
	public void setNews_end(String news_end) {
		this.news_end = news_end;
	}	
	public int getIndex_show() {
		return index_show;
	}
	public void setIndex_show(int index_show) {
		this.index_show = index_show;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}	
	public String getBrief_introduction() {
		return brief_introduction;
	}
	public void setBrief_introduction(String brief_introduction) {
		this.brief_introduction = brief_introduction;
	}	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	
}
