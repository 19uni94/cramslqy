package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.JoinNoticeDao;
import com.tkb.elearning.model.JoinNotice;
import com.tkb.elearning.service.JoinNoticeService;



public class JoinNoticeServiceImpl implements JoinNoticeService{
	
	private JoinNoticeDao joinNoticeDao;
	
	/**
	 * 加入會員須知清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param joinNotice
	 * @return List<JoinNotice>
	 * **/
	public List<JoinNotice> getList(int pageCount, int pageStart, JoinNotice joinNotice){
		
		return joinNoticeDao.getList(pageCount, pageStart, joinNotice);
	}
	
	/**
	 * 取得加入會員須知筆數
	 * @param joinNotice
	 * @return AllAssociation
	 * **/
	public Integer getCount(JoinNotice joinNotice){
		
		return joinNoticeDao.getCount(joinNotice);
	}
	
	/**
	 * 取得單筆加入會員須知
	 * @param joinNotice
	 * @return AllAssociation
	 * */
	public JoinNotice getData(JoinNotice joinNotice){
		return joinNoticeDao.getData(joinNotice);
	}
	
	/**
	 * 新增加入會員須知
	 * @param joinNotice
	 * */
	public void add(JoinNotice joinNotice){
		joinNoticeDao.add(joinNotice);
	}
	
	/**
	 * 修改加入會員須知
	 * @param joinNotice
	 * */
	public void update(JoinNotice joinNotice){
		joinNoticeDao.update(joinNotice);
	}
	
	/**
	 * 刪除加入會員須知
	 * @param id
	 * */
	public void delete(Integer id){
		joinNoticeDao.delete(id);
	}

	public void setJoinNoticeDao(JoinNoticeDao joinNoticeDao){
		this.joinNoticeDao = joinNoticeDao;
	}

}
