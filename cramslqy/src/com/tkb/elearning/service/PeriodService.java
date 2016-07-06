package com.tkb.elearning.service;

import java.util.List;

import com.tkb.elearning.model.Period;




/**
 * 屆別管理Service介面接口
 * @author Admin
 * @version 創建時間：2016-04-18
 */
public interface PeriodService {

//	/**
//	 * 取得前台News清單
//	 * @return List<News>
//	 */
//	public List<Session> getFrontList();
	
	/**
	 * 取得屆別管理資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param period
	 * @return List<Period>
	 */
	public List<Period> getList(int pageCount, int pageStart, Period period);
	
	/**
	 * 取得屆別管理資料筆數
	 * @param period
	 * @return Integer
	 */
	public Integer getCount(Period period);
	
	/**
	 * 取得單筆屆別管理
	 * @param period
	 * @return Period
	 */
	public Period getData(Period period);
	
	/**
	 * 新增屆別管理
	 * @param period
	 */
	public void add(Period period);
	
	/**
	 * 修改屆別管理
	 * @param period
	 */
	public void update(Period period);
		
	/**
	 * 刪除屆別管理
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 活動訊息&會議紀錄form下拉選單的list
	 */
	public List<Period> getPeriodList();
	
	/**
	 * 檢查屆別(數字)
	 */
	public Integer checkClassNo(Period period);
}