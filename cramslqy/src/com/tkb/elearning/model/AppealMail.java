package com.tkb.elearning.model;

import java.sql.Timestamp;

public class AppealMail {

	private int id;
	private String pd_name;
	private String mail_address1;
	private String mail_address2;
	private Timestamp create_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public String getMail_address1() {
		return mail_address1;
	}
	public void setMail_address1(String mail_address1) {
		this.mail_address1 = mail_address1;
	}
	public String getMail_address2() {
		return mail_address2;
	}
	public void setMail_address2(String mail_address2) {
		this.mail_address2 = mail_address2;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}			
}
