package com.tkb.elearning.model;

import java.sql.Timestamp;

public class ConsumerZone {

	private int id;       					//會員流水號
	private String member_no;               //會員編號
	private String cramschool_name; 		//補習班名稱
	private String ein;						//統一編號
	private String join_quit_show;         //入會公告顯示
	private String join_date;               //入會日期
	private String quit_date;				//退會日期
	private String founder;					//立案人
	private int founder_no;					//立案字號
    private String website;					//網址
	private String address;					//地址
	private int telephone;					//電話
	private int fax;						//傳真
	private String found_date;				//成立日期
	private String email;					//電子郵箱
	private String display;					//是否顯示於入會&退出公告中
	private Timestamp create_date;			//資料建立日期
	private Timestamp update_date;			//資料編輯日期
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
	public String getCramschool_name() {
		return cramschool_name;
	}
	public void setCramschool_name(String cramschool_name) {
		this.cramschool_name = cramschool_name;
	}
	public String getEin() {
		return ein;
	}
	public void setEin(String ein) {
		this.ein = ein;
	}
	public String getJoin_quit_show() {
		return join_quit_show;
	}
	public void setJoin_quit_show(String join_quit_show) {
		this.join_quit_show = join_quit_show;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getQuit_date() {
		return quit_date;
	}
	public void setQuit_date(String quit_date) {
		this.quit_date = quit_date;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public int getFounder_no() {
		return founder_no;
	}
	public void setFounder_no(int founder_no) {
		this.founder_no = founder_no;
	}	
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public int getFax() {
		return fax;
	}
	public void setFax(int fax) {
		this.fax = fax;
	}
	public String getFound_date() {
		return found_date;
	}
	public void setFound_date(String found_date) {
		this.found_date = found_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
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
