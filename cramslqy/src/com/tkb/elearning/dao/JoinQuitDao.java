package com.tkb.elearning.dao;

import java.util.List;

import com.tkb.elearning.model.ConsumerZone;

/**
 * 入會&退會公告Dao
 * @author Admin
 * @version 創建時間：2016-05-02
 */
public interface JoinQuitDao {

	/**
	 * 取得入會&退會公告資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param consumerZone
	 * @return List<ConsumerZone> 
	 **/
	public List<ConsumerZone>getJoinQuitList(int pageCount, int pageStart, ConsumerZone consumerZone);
	
	/**
	 * 取得入會&退會公告總筆數
	 * @param consumerZone
	 * @return Integer
	 **/
	public Integer getCount(ConsumerZone consumerZone);
	
	/**
	 * 取得入會&退會公告
	 * @param consumerZone
	 **/
	public ConsumerZone getData(ConsumerZone consumerZone);
	
}
