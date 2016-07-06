package com.tkb.elearning.action.admin;

import java.util.List;

import com.tkb.elearning.model.Appeal;
import com.tkb.elearning.service.AppealService;
import com.tkb.elearning.util.VerifyBaseAction;

public class AppealAction extends VerifyBaseAction{
	

	private static final long serialVersionUID = 1L;
	
	private Appeal appeal;
	private AppealService appealService;
	private List<Appeal> appealList;
	private int pageNo;
	private int[] deleteList;
	
	public String index(){
		
		if(appeal == null){
			appeal = new Appeal();
		}
		
		pageTotalCount = appealService.getCount(appeal);
		pageNo = super.pageSetting(pageNo);
		appealList = appealService.getList(pageCount, pageStart, appeal);
		
		return "list";
	}
	
	public String add(){
		appeal = new Appeal();		
		return "form";		
	}
	
	public Appeal getAppeal() {
		return appeal;
	}
	public void setAppeal(Appeal appeal) {
		this.appeal = appeal;
	}
	public AppealService getAppealService() {
		return appealService;
	}
	public void setAppealService(AppealService appealService) {
		this.appealService = appealService;
	}
	public List<Appeal> getAppealList() {
		return appealList;
	}
	public void setAppealList(List<Appeal> appealList) {
		this.appealList = appealList;
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
