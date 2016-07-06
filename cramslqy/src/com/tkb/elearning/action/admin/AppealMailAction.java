package com.tkb.elearning.action.admin;

import java.io.IOException;
import java.util.List;

import com.tkb.elearning.model.AppealMail;
import com.tkb.elearning.service.AppealMailService;
import com.tkb.elearning.util.VerifyBaseAction;

public class AppealMailAction extends VerifyBaseAction{
	
	private static final long serialVersionUID = 1L;
	
	private AppealMail appealMail;					//申訴專區Mail
	private List<AppealMail> appealMailList;		//申訴專區Mail清單
	private AppealMailService appealMailService;	//申訴專區Mail服務
	private int pageNo;								//頁碼
	private int[] deleteList;						//刪除的ID清單
	
	public String index(){
		
		if(appealMail == null){
			appealMail = new AppealMail();
		}
		
		pageTotalCount = appealMailService.getCount(appealMail);
		pageNo = super.pageSetting(pageNo);
		appealMailList = appealMailService.getList(pageCount, pageStart, appealMail);
		
		return "list";
	}
	
	public String add(){
		appealMail = new AppealMail();
		return"form";
	}
	
	public String addSubmit() throws IOException {
		
		appealMailService.add(appealMail);
		return "index";
	} 
	
	public String update(){
		appealMail = appealMailService.getData(appealMail);
		return "form";
	}
	
	public String updateSubmit() throws IOException {
		
		appealMailService.update(appealMail);
		
		return "index";
	}
	
	public String delete() throws IOException {
		for(int id : deleteList){
			appealMail.setId(id);
			appealMail = appealMailService.getData(appealMail);
			appealMailService.delete(id);
		}
		return "index";
	}
	
	public String view(){
		
		appealMail = appealMailService.getData(appealMail);
		
		return "view";
	}
	
	
	public AppealMail getAppealMail() {
		return appealMail;
	}
	public void setAppealMail(AppealMail appealMail) {
		this.appealMail = appealMail;
	}
	public List<AppealMail> getAppealMailList() {
		return appealMailList;
	}
	public void setAppealMailList(List<AppealMail> appealMailList) {
		this.appealMailList = appealMailList;
	}
	public AppealMailService getAppealMailService() {
		return appealMailService;
	}
	public void setAppealMailService(AppealMailService appealMailService) {
		this.appealMailService = appealMailService;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int[] getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(int[] deleteList) {
		this.deleteList = deleteList;
	}			
}
