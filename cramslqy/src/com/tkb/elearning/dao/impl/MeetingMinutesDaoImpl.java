package com.tkb.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.tkb.elearning.dao.MeetingMinutesDao;
import com.tkb.elearning.model.MeetingMinutes;

import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 會議記錄Dao實作類
 * @author Admin
 * @version 創建時間：2016-04-21
 */
public class MeetingMinutesDaoImpl extends PagingDaoImpl implements MeetingMinutesDao {
	
	
	@SuppressWarnings("unchecked")
	public List<MeetingMinutes> getList(int pageCount, int pageStart, MeetingMinutes meetingMinutes) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT * FROM meeting_minutes ";
		
		if(meetingMinutes.getMeeting_name() != null && !"".equals(meetingMinutes.getMeeting_name())) {
			sql += " WHERE MEETING_NAME LIKE ? ";
			args.add("%" + meetingMinutes.getMeeting_name() + "%");
		}
//		
		sql += " ORDER BY ID DESC LIMIT ?, ? ";
//		
////		sql = " SELECT * FROM "
////			+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
////			+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
//		
		args.add(pageStart);
		args.add(pageCount+1);
		
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		
	}
	
	public Integer getCount(MeetingMinutes meetingMinutes) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM meeting_minutes ";
		
		if(meetingMinutes.getMeeting_name() != null && !"".equals(meetingMinutes.getMeeting_name())) {
			sql += " WHERE MEETING_MINUTES LIKE ? ";
			args.add("%" + meetingMinutes.getMeeting_name() + "%");
		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public MeetingMinutes getData(MeetingMinutes meetingMinutes) {
		
		String sql = " SELECT * FROM meeting_minutes WHERE ID = ? ";
		return (MeetingMinutes)getJdbcTemplate().query(sql, new Object[]{ meetingMinutes.getId() }, getRowMapper()).get(0);
		
	}
		
	public void add(MeetingMinutes meetingMinutes) {
		
		String sql = "INSERT INTO meeting_minutes( CLASS_NO, MEETING_NAME, MEETING_DATE, CONTENT, STATUS, CREATE_DATE)"
				+ "VALUES(?, ?, ?, ?, ?, NOW())";
				 		
		getJdbcTemplate().update(sql, new Object[] { meetingMinutes.getClass_no(), meetingMinutes.getMeeting_name(), 
				meetingMinutes.getMeeting_date(), meetingMinutes.getContent(),meetingMinutes.getStatus() });
		
	}
	
	public void update(MeetingMinutes meetingMinutes) {
		
		String sql = " UPDATE meeting_minutes SET CLASS_NO = ?, MEETING_NAME = ?,  MEETING_DATE = ?, "
				+ "CONTENT = ?, STATUS = ? WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { meetingMinutes.getClass_no(), meetingMinutes.getMeeting_name(), 
				meetingMinutes.getMeeting_date(), meetingMinutes.getContent(), meetingMinutes.getStatus(),
				meetingMinutes.getId() });
		
	}
	
	public void delete(Integer id ) {
		
		String sql = " DELETE FROM meeting_minutes WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { id });
	}
	
	@SuppressWarnings("unchecked")
	public String checkMeetingMinutes(MeetingMinutes meetingMinutes){
		String sql = "SELECT * FROM meeting_minutes WHERE MEETING_NAME = ?";
		List<MeetingMinutes> list = getJdbcTemplate().query(sql, new Object[]{ meetingMinutes.getMeeting_name()}, getRowMapper());
		return list.size() == 0 ? null : list.get(0).getMeeting_name();
	}
}
