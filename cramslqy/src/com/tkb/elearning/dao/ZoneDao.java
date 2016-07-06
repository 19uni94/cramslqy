package com.tkb.elearning.dao;

import java.util.List;

import com.tkb.elearning.model.Zone;

/**
 * 地區資料Dao介面接口
 * @author Admin
 * @version 創建時間：2016-03-11
 */
public interface ZoneDao {

	/**
	 * 取得地區資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param zone
	 * @return List<Zone>
	 */
	public List<Zone> getList(int pageCount, int pageStart, Zone zone);
	
	/**
	 * 取得地區資料總筆數
	 * @param zone
	 * @return Integer
	 */
	public Integer getCount(Zone zone);
	
	/**
	 * 取得單筆地區資料
	 * @param zone
	 * @return Zone
	 */
	public Zone getData(Zone zone);
	
	/**
	 * 新增地區資料
	 * @param qa
	 */
	public void add(Zone zone);

	/**
	 * 修改地區資料排序
	 * @param zone
	 */
	public void updateSort(Zone zone);
	
	/**
	 * 修改地區資料
	 * @param zone
	 */
	public void update(Zone zone);
	
	/**
	 * 刪除地區資料
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 重新排序地區資料
	 */
	public void resetSort();
	
	/**
	 * 檢查地區名稱
	 */
	public String checkZonename(Zone zone);
	
	/**
	 * 地區form下拉選單的list
	 */
	public List<Zone> getZoneList();
}
