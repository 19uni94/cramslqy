package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.MeetingMinutesDao;
import com.tkb.elearning.model.MeetingMinutes;
import com.tkb.elearning.service.MeetingMinutesService;

/**
 * 會議記錄Service實作類
 * @author Admin
 * @version 創建時間：2016-04-21
 */
	public class MeetingMinutesServiceImpl implements MeetingMinutesService{
	
		private MeetingMinutesDao meetingMinutesDao;
		
		public List<MeetingMinutes> getList(int pageCount, int pageStart, MeetingMinutes meetingMinutes){
			
			return meetingMinutesDao.getList(pageCount, pageStart, meetingMinutes);
		}
	
		public Integer getCount(MeetingMinutes meetingMinutes){
			
			return meetingMinutesDao.getCount(meetingMinutes);
		}
		
		public MeetingMinutes getData(MeetingMinutes meetingMinutes){
			return meetingMinutesDao.getData(meetingMinutes);
		}
		
		public void add(MeetingMinutes meetingMinutes){
			meetingMinutesDao.add(meetingMinutes);
		}
		
	
		public void update(MeetingMinutes meetingMinutes){
			meetingMinutesDao.update(meetingMinutes);
		}
		
		public void delete(Integer id){
			meetingMinutesDao.delete(id);
		}
		
		public String checkMeetingMinutes(MeetingMinutes meetingMinutes){
			return meetingMinutesDao.checkMeetingMinutes(meetingMinutes);
		}
		
		public void setMeetingMinutesDao(MeetingMinutesDao meetingMinutesDao){
			this.meetingMinutesDao = meetingMinutesDao; 
		}
	}
