package com.tkb.elearning.action.admin;

import java.io.IOException;
import java.util.List;

import com.tkb.elearning.model.ConsumerZone;
import com.tkb.elearning.service.ConsumerZoneService;
import com.tkb.elearning.util.VerifyBaseAction;

public class ConsumerZoneAction extends VerifyBaseAction{
	
	private static final long serialVersionUID = 1L;
	
	private ConsumerZoneService consumerZoneService;
	private List<ConsumerZone> consumerZoneList;
	private ConsumerZone consumerZone;
	private int pageNo;
	private int[] deleteList;
	
	/**
	 * 清單頁面
	 **/
	public String index(){
		if(consumerZone == null){
			consumerZone = new ConsumerZone();
		}
		pageTotalCount = consumerZoneService.getCount(consumerZone);
		pageNo = super.pageSetting(pageNo);
		consumerZoneList = consumerZoneService.getList(pageCount, pageStart, consumerZone);
		
		System.out.println(consumerZone.getMember_no());
		
		return "list";
	}
	
	/**
	 * 新增消費者小幫手
	 * **/
	public String add(){
		
		consumerZone = new ConsumerZone();
		return "form";
		
	}
	
	/**
	 * 新增消費者小幫手資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
			
		consumerZoneService.add(consumerZone);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		consumerZone = consumerZoneService.getData(consumerZone);
		return "form";
		
	}
	
	 /**
	 * 修改消費者小幫手
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException {
				
		consumerZoneService.update(consumerZone);
		return "index";
		
	}
	
	/**
	 * 刪除消費者小幫手
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			consumerZone.setId(id);
			consumerZone = consumerZoneService.getData(consumerZone);
			consumerZoneService.delete(id);
		}
		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		consumerZone=consumerZoneService.getData(consumerZone);
		return "view";
		
	}
		
	public ConsumerZoneService getConsumerZoneService() {
		return consumerZoneService;
	}

	public void setConsumerZoneService(ConsumerZoneService consumerZoneService) {
		this.consumerZoneService = consumerZoneService;
	}

	public List<ConsumerZone> getConsumerZoneList() {
		return consumerZoneList;
	}

	public void setConsumerZoneList(List<ConsumerZone> consumerZoneList) {
		this.consumerZoneList = consumerZoneList;
	}

	public ConsumerZone getConsumerZone() {
		return consumerZone;
	}

	public void setConsumerZone(ConsumerZone consumerZone) {
		this.consumerZone = consumerZone;
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
