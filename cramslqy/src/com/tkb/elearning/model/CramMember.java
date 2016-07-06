package com.tkb.elearning.model;

import com.sun.jmx.snmp.Timestamp;

public class CramMember {

	private int id;          		//會員編號
	private String cram_school;     //補習班名稱
	private int telephone;   		//電話
	private int cellphone;   		//手機
	private String email;    		//電子信箱
	private String address;  		//住家地址
	private Timestamp create_date;	//建立日期
	private Timestamp update_date;  //編輯日期
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getCram_school() {
		return cram_school;
	}
	public void setCram_school(String cram_school) {
		this.cram_school = cram_school;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public int getCellphone() {
		return cellphone;
	}
	public void setCellphone(int cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
