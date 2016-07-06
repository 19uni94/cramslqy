package com.tkb.elearning.action.admin;

import java.io.IOException;

import java.util.List;

import com.tkb.elearning.model.Active;
import com.tkb.elearning.model.Period;
import com.tkb.elearning.service.ActiveService;
import com.tkb.elearning.service.PeriodService;
import com.tkb.elearning.util.VerifyBaseAction;


public class PeriodAction extends VerifyBaseAction {

	private static final long serialVersionUID = 1L;
	
	private PeriodService periodService;		//地區管理Service
	private List<Period> periodList;			//地區管理清單
	private Period period;						//地區管理資料
	private Active active;						//活動資料
	private ActiveService activeService; 		//活動Service
	private int pageNo;							//頁碼
	private int[] deleteList;					//刪除的ID清單
	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(period == null) {
			period = new Period();
		}
		
		pageTotalCount = periodService.getCount(period);
		pageNo = super.pageSetting(pageNo);
		periodList = periodService.getList(pageCount, pageStart, period);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		period = new Period();
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
		
		periodService.add(period);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		period = periodService.getData(period);
		return "form";
		
	}
	
	 /**
	 * 修改最新消息
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException {
		
//		if(active==null){
//			active = new Active();
//		}
//		
//		int before = active.getClass_no();
//		active.setClass_no(active.getClass_no());
		
		periodService.update(period);
		
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			period.setId(id);
			period = periodService.getData(period);
			periodService.delete(id);
		}

		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		period=periodService.getData(period);
		System.out.println(period.getId());
		return "view";
		
	}
	
	/**
	 * 檢查屆別是否使用中
	 * @return
	 * @throws IOException 
	 */
	public void checkUsingPeriod() throws IOException {
		int class_no = Integer.parseInt(request.getParameter("class_no"));
		String checkmsg = "";
		
		Period period = new Period();
		period.setId(class_no);
		period = periodService.getData(period);
		Active active = new Active();
		active.setClass_no(active.getClass_no());
		int returnPeriodnum = activeService.checkUsingPeriod(active);
		if(returnPeriodnum == 0) {
			checkmsg = "true";
		} else {
			checkmsg = "false";
		}
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(checkmsg);
	}
	
	/**
	 * 檢查屆別是否使用中
	 * @return
	 * @throws IOException 
	 */
	public void checkClassNo() throws IOException {
		int class_no = Integer.parseInt(request.getParameter("class_no"));
		String msg = "";
		
		Period period = new Period();
		period.setClass_no(class_no);
		int returnClassNo = periodService.checkClassNo(period);
		if(returnClassNo == 0) {
			msg = "true";
		} else {
			msg = "false";
		}
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(msg);
	}

	public PeriodService getPeriodService() {
		return periodService;
	}

	public void setPeriodService(PeriodService periodService) {
		this.periodService = periodService;
	}

	public Active getActive() {
		return active;
	}

	public void setActive(Active active) {
		this.active = active;
	}

	public List<Period> getPeriodList() {
		return periodList;
	}

	public void setPeriodList(List<Period> periodList) {
		this.periodList = periodList;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
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