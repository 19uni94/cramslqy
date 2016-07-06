package com.tkb.elearning.service.impl;

import java.util.List;


import com.tkb.elearning.dao.JoinQuitDao;
import com.tkb.elearning.model.ConsumerZone;
import com.tkb.elearning.service.JoinQuitService;

/**
 * 入會&退會公告Service實作類
 * @author Admin
 * @version 創建時間：2016-05-02
 */
public  class JoinQuitServiceImpl implements JoinQuitService{
     
	private JoinQuitDao joinQuitDao;
	/**
	 * 取得消費者專區資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param consumerZone
	 * @return List<ConsumerZone> 
	 **/
	public List<ConsumerZone>getJoinQuitList(int pageCount, int pageStart, ConsumerZone consumerZone){
		return joinQuitDao.getJoinQuitList(pageCount, pageStart, consumerZone);
	}
	
	/**
	 * 取得消費者專區總筆數
	 * @param consumerZone
	 * @return Integer
	 **/
	public Integer getCount(ConsumerZone consumerZone){
		
		return joinQuitDao.getCount(consumerZone);
	}
	
	/**
	 * 取得消費者專區
	 * @param consumerZone
	 **/
	public ConsumerZone getData(ConsumerZone consumerZone){
		
		return joinQuitDao.getData(consumerZone);
	}
	
	public void setJoinQuitDao(JoinQuitDao joinQuitDao){
		this.joinQuitDao = joinQuitDao;
	}
}
