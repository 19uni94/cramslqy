package com.tkb.elearning.model;

import java.sql.Timestamp;


/**
 * 最新消息
 * @author Admin
 * @version 創建時間：2016-04-15
 */
public class Banner {

	public int id;						//id
	public String type;					//廣告類型
	public String title;				//主旨
	public String image;				//圖片	
	public String img_name;				//圖片名稱
	public String url;					//連結
	public int sort; 					//排序
	public String index_show;			//前台顯示狀態
	public String start_date;			//開始日期	
	public String end_date;				//結束日期
	public String countdown;			//剩下天數
	public int ctr;						//點擊率
	public Timestamp create_date;		//創建日期
	public Timestamp update_date;		//編輯日期
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIndex_show() {
		return index_show;
	}
	public void setIndex_show(String index_show) {
		this.index_show = index_show;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getCountdown() {
		return countdown;
	}
	public void setCountdown(String countdown) {
		this.countdown = countdown;
	}
	public int getCtr() {
		return ctr;
	}
	public void setCtr(int ctr) {
		this.ctr = ctr;
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
