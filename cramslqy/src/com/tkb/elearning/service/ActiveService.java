package com.tkb.elearning.service;

import java.util.List;


import com.tkb.elearning.model.Active;

/**
 * 活動訊息Service訊息介口
 * @author Admin
 * @version 創建時間:2016-04-26
 * */
public interface ActiveService {

	/**
	 * 取得活動訊息清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param active
	 * @return List<Active>
	 * */
	public List<Active> getList(int pageCount, int pageStart, Active active);
	
	/**
	 * 取得活動訊息總筆數
	 * @param active
	 * @return Active
	 * */
	public Integer getCount(Active avtive);
	
	/**
	 * 取得單筆活動訊息
	 * @param active
	 * */
	public Active getData(Active active);
	
	/**
	 * 新增活動訊息
	 * @param active
	 * */
	public void add(Active active);
	
	/**
	 * 修改活動訊息
	 * @param active
	 * */
	public void update(Active active);
	
	/**
	 * 刪除活動訊息
	 * @param id
	 * */
	public void delete(Integer id);
	
	/**
	 * 檢查屆別使用筆數
	 * @param movieData
	 * @return Integer
	 */
	public Integer checkUsingPeriod(Active active);
	
}
