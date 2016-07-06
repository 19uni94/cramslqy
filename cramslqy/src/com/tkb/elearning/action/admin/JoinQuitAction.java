package com.tkb.elearning.action.admin;

import java.util.List;

import com.tkb.elearning.model.ConsumerZone;
import com.tkb.elearning.service.JoinQuitService;

public class JoinQuitAction extends ConsumerZoneAction{
	
	private static final long serialVersionUID = 2863923757696514557L;
	
	private JoinQuitService joinQuitService;
	private List<ConsumerZone> joinQuitList;
	private ConsumerZone consumerZone;
	private int pageNo;
	
	public String index(){
		
		if(consumerZone == null){
			consumerZone = new ConsumerZone();
		}
		pageTotalCount = joinQuitService.getCount(consumerZone);
		pageNo = super.pageSetting(pageNo);
		joinQuitList = joinQuitService.getJoinQuitList(pageCount, pageStart, consumerZone);
		
		return "list";
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		consumerZone=joinQuitService.getData(consumerZone);
		return "view";
		
	}

	public JoinQuitService getJoinQuitService() {
		return joinQuitService;
	}

	public void setJoinQuitService(JoinQuitService joinQuitService) {
		this.joinQuitService = joinQuitService;
	}

	public List<ConsumerZone> getJoinQuitList() {
		return joinQuitList;
	}

	public void setJoinQuitList(List<ConsumerZone> joinQuitList) {
		this.joinQuitList = joinQuitList;
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
	
}
