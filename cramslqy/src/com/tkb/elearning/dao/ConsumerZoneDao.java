package com.tkb.elearning.dao;

import java.util.List;

import com.tkb.elearning.model.ConsumerZone;

/**
 * 消費者專區Dao
 * @author Admin
 * @version 創建時間：2016-03-21
 */
public interface ConsumerZoneDao {

	/**
	 * 取得消費者專區資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param consumerZone
	 * @return List<ConsumerZone> 
	 **/
	public List<ConsumerZone>getList(int pageCount, int pageStart, ConsumerZone consumerZone);
	
	/**
	 * 取得消費者專區總筆數
	 * @param consumerZone
	 * @return Integer
	 **/
	public Integer getCount(ConsumerZone consumerZone);
	
	/**
	 * 取得消費者專區
	 * @param consumerZone
	 **/
	public ConsumerZone getData(ConsumerZone consumerZone);
	
	/**
	 *新增消費者專區
	 *@param consumerZone 
	 **/
	public void add(ConsumerZone consumerZone);
	
	/**
	 *修改消費者專區資訊
	 *@param consumerZone 
	 **/
	public void update(ConsumerZone consumerZone);
	
	/**
	 *刪除消費者小幫手資訊
	 *@param id
	 **/
	public void delete(Integer id);
}
