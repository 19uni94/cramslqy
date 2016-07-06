package com.tkb.elearning.action.admin;

import java.io.IOException;


import java.util.List;

import com.tkb.elearning.model.Active;
import com.tkb.elearning.model.Period;
import com.tkb.elearning.service.ActiveService;
import com.tkb.elearning.service.PeriodService;
import com.tkb.elearning.util.VerifyBaseAction;

public class ActiveAction extends VerifyBaseAction{
	

	private static final long serialVersionUID = 1L;
	
	private ActiveService activeService;    //活動訊息服務
	private PeriodService periodService;	//屆別服務
	private List<Active> activeList;		//活動訊息清單
	private List<Period> periodList;		//活動訊息清單
	private Active active;					//活動訊息
	private Period period;                  //屆別
	private int pageNo;						//頁碼
	private int[] deleteList;				//刪除的ID清單

	/**
	 * 清單頁面
	 * @return
	 * */
	public String index(){
		
		if(active == null){
			active = new Active();
		}
		
		pageTotalCount = activeService.getCount(active);
		pageNo = super.pageSetting(pageNo);
		activeList = activeService.getList(pageCount, pageStart, active);
			
		return "list";
	}
	
	/**
	 * 新增頁面
	 * @return
	 * */
	public String add(){
		
	   active=new Active();
	   periodList=periodService.getPeriodList();
	   return "form";
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 * */
	public String addSubmit() throws IOException{
		
		activeService.add(active);
		return "index";
	}
	
	/**
	 * 修改頁面
	 * @return 
	 * @throws IOExeption
	 * */
	public String update() {
		active = activeService.getData(active);
		return "form";
	}	
	
	/**
	 * 修改活動訊息
	 * @return 
	 * @throws IOException
	 * */
	public String updateSubmit() throws IOException{
		
		activeService.update(active);
		return "index";
	}
	
	/**
	 * 刪除活動訊息
	 * @return
	 * */
	public String delete(){
		
		for(int id:deleteList){
			active.setId(id);
			active=activeService.getData(active);
			activeService.delete(id);
		}
			return "index";
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 * */
	public String view(){
		
		active=activeService.getData(active);
		return "view";
	}
	
	public ActiveService getActiveService() {
		return activeService;
	}

	public void setActiveService(ActiveService activeService) {
		this.activeService = activeService;
	}

	public PeriodService getPeriodService() {
		return periodService;
	}

	public void setPeriodService(PeriodService periodService) {
		this.periodService = periodService;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public List<Active> getActiveList() {
		return activeList;
	}

	public void setActiveList(List<Active> activeList) {
		this.activeList = activeList;
	}

	public List<Period> getPeriodList() {
		return periodList;
	}

	public void setPeriodList(List<Period> periodList) {
		this.periodList = periodList;
	}

	public Active getActive() {
		return active;
	}

	public void setActive(Active active) {
		this.active = active;
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
