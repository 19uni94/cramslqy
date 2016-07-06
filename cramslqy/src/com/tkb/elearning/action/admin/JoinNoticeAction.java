package com.tkb.elearning.action.admin;

import java.io.IOException;
import java.util.List;

import com.tkb.elearning.model.JoinNotice;
import com.tkb.elearning.service.JoinNoticeService;
import com.tkb.elearning.util.VerifyBaseAction;

public class JoinNoticeAction extends VerifyBaseAction{
	
	private static final long serialVersionUID = 1L;
	
	private JoinNoticeService joinNoticeService;		//各區協會資訊服務
	private List<JoinNotice> joinNoticeList;			//各區協會資訊清單
	private JoinNotice joinNotice;						//各區協會資訊資料
	private int pageNo;									//頁碼
	private int[] deleteList;							//刪除的ID清單
	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(joinNotice == null) {
			joinNotice = new JoinNotice();
		}
		
		pageTotalCount = joinNoticeService.getCount(joinNotice);
		pageNo = super.pageSetting(pageNo);
		joinNoticeList = joinNoticeService.getList(pageCount, pageStart, joinNotice);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		joinNotice= new JoinNotice();
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
				
		joinNoticeService.add(joinNotice);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		joinNotice = joinNoticeService.getData(joinNotice);
		return "form";
		
	}
	
	/**
	 * 修改最新消息
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException {
	
		joinNoticeService.update(joinNotice);
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			joinNotice.setId(id);
			joinNotice = joinNoticeService.getData(joinNotice);			
			joinNoticeService.delete(id);
		}
		return "index";		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		joinNotice=joinNoticeService.getData(joinNotice);
		return "view";
		
	}

	public JoinNoticeService getJoinNoticeService() {
		return joinNoticeService;
	}

	public void setJoinNoticeService(JoinNoticeService joinNoticeService) {
		this.joinNoticeService = joinNoticeService;
	}

	public List<JoinNotice> getJoinNoticeList() {
		return joinNoticeList;
	}

	public void setJoinNoticeList(List<JoinNotice> joinNoticeList) {
		this.joinNoticeList = joinNoticeList;
	}

	public JoinNotice getJoinNotice() {
		return joinNotice;
	}

	public void setJoinNotice(JoinNotice joinNotice) {
		this.joinNotice = joinNotice;
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
