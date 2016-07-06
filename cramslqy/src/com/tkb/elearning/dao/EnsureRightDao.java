package com.tkb.elearning.dao;

import java.util.List;

import com.tkb.elearning.model.EnsureRight;


/**
 * 品保Right Dao介面接口
 * @author Admin
 * @version 創建時間：2016-04-20
 */
public interface EnsureRightDao {

	/**
	 * 取得品保資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param ensureRight
	 * @return List<EnsureRight>
	 */	
	public List<EnsureRight> getList(int pageCount, int pageStart, EnsureRight ensureRight);
	
	/**
	 * 取得品保權益總筆數
	 * @param ensureRight
	 * @return Integer
	 */
	public Integer getCount(EnsureRight ensureRight);
	
	/**
	 * 取得單筆品保權益
	 * @param ensureRight
	 * @return EnsureRight
	 */
	public EnsureRight getData(EnsureRight ensureRight);
	
	/**
	 * 新增品保權益
	 * @param ensureRight
	 */
	public void add(EnsureRight ensureRight);
	
	/**
	 * 修改品保權益
	 * @param ensureRight
	 */
	public void update(EnsureRight ensureRight);
		
	/**
	 * 刪除品保權益
	 * @param id
	 */
	public void delete(Integer id);
	
}
