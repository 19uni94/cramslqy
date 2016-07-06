package com.tkb.elearning.service;

import java.util.List;

import com.tkb.elearning.model.Appeal;


/**
 * 申訴專區資料Service訊息介口
 * @author Admin
 * @version 創建時間:2016-05-03
 * */
public interface AppealService {

	/**
	 * 取得申訴專區資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param appeal
	 * @return List<Appeal>
	 * */
	public List<Appeal> getList(int pageCount, int pageStart, Appeal appeal);
	
	/**
	 * 取得申訴專區資料總筆數
	 * @param appeal
	 * @return Appeal
	 * */
	public Integer getCount(Appeal appeal);
	
	/**
	 * 取得單筆申訴專區資料
	 * @param appeal
	 * */
	public Appeal getData(Appeal appeal);
	
	/**
	 * 新增申訴專區資料
	 * @param appeal
	 * */
	public void add(Appeal appeal);
	
	/**
	 * 修改申訴專區資料
	 * @param appeal
	 * */
	public void update(Appeal appeal);
	
	/**
	 * 刪除申訴專區資料
	 * @param id
	 * */
	public void delete(Integer id);
	
//	/**
//	 * 檢查屆別使用筆數
//	 * @param movieData
//	 * @return Integer
//	 */
//	public Integer checkUsingPeriod(Appeal appeal);
	
}
