package com.tkb.elearning.service;

import java.util.List;

import com.tkb.elearning.model.MeetingMinutes;

/**
 * 會議紀錄Service介面接口
 * @author Admin
 * @version 創建時間：2016-04-22
 */
public interface MeetingMinutesService {
	
	/**
	 * 取得會議紀錄清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param meetingMinutes
	 * @return List<MeetingMinutes>
	 * **/
	public List<MeetingMinutes> getList(int pageCount, int pageStart, MeetingMinutes meetingMinutes);
	
	/**
	 * 取得會議紀錄筆數
	 * @param meetingMinutes
	 * @return MeetingMinutes
	 * **/
	public Integer getCount(MeetingMinutes meetingMinutes);
	
	/**
	 * 取得單筆會議紀錄
	 * @param meetingMinutes
	 * @return MeetingMintes
	 * */
	public MeetingMinutes getData(MeetingMinutes meetingMinutes);
	
	/**
	 * 新增會議紀錄
	 * @param meetingMinutes
	 * */
	public void add(MeetingMinutes meetingMinutes);
	
	/**
	 * 修改會議紀錄
	 * @param meetingMinutes
	 * */
	public void update(MeetingMinutes meetingMinutes);
	
	/**
	 * 刪除會議記錄
	 * @param id
	 * */
	public void delete(Integer id);
	
	/**
	 * 檢查會議紀錄
	 * */
	public String checkMeetingMinutes(MeetingMinutes meetingMinutes);
}
