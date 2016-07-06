package com.tkb.elearning.action.admin;

import java.io.IOException;
import java.util.List;

import com.tkb.elearning.model.MeetingMinutes;
import com.tkb.elearning.service.MeetingMinutesService;
import com.tkb.elearning.util.VerifyBaseAction;

public class MeetingMinutesAction extends VerifyBaseAction {


	private static final long serialVersionUID = 1L;
	
	private MeetingMinutesService meetingMinutesService;		//會議記錄服務
	private List<MeetingMinutes> meetingMinutesList;							//會議記錄清單
	private MeetingMinutes meetingMinutes;										//會議記錄資料
	private int pageNo;											//頁碼
	private int[] deleteList;									//刪除的ID清單

	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(meetingMinutes == null) {
			meetingMinutes = new MeetingMinutes();
		}
		
		pageTotalCount = meetingMinutesService.getCount(meetingMinutes);
		pageNo = super.pageSetting(pageNo);
		meetingMinutesList = meetingMinutesService.getList(pageCount, pageStart, meetingMinutes);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		meetingMinutes = new MeetingMinutes();
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
		
		meetingMinutesService.add(meetingMinutes);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		meetingMinutes = meetingMinutesService.getData(meetingMinutes);
		return "form";
		
	}
	
	 /**
	 * 修改最新消息
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException {
		

		meetingMinutesService.update(meetingMinutes);
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			meetingMinutes.setId(id);
			meetingMinutes = meetingMinutesService.getData(meetingMinutes);
			meetingMinutesService.delete(id);
		}

		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		meetingMinutes=meetingMinutesService.getData(meetingMinutes);
		System.out.println(meetingMinutes.getId());
		return "view";
		
	}

	public MeetingMinutesService getMeetingMinutesService() {
		return meetingMinutesService;
	}

	public void setMeetingMinutesService(MeetingMinutesService meetingMinutesService) {
		this.meetingMinutesService = meetingMinutesService;
	}

	public List<MeetingMinutes> getMeetingMinutesList() {
		return meetingMinutesList;
	}

	public void setMeetingMinutesList(List<MeetingMinutes> meetingMinutesList) {
		this.meetingMinutesList = meetingMinutesList;
	}

	public MeetingMinutes getMeetingMinutes() {
		return meetingMinutes;
	}

	public void setMeetingMinutes(MeetingMinutes meetingMinutes) {
		this.meetingMinutes = meetingMinutes;
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
