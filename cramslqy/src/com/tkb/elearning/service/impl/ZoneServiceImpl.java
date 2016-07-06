package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.ZoneDao;
import com.tkb.elearning.model.News;
import com.tkb.elearning.model.Zone;
import com.tkb.elearning.service.ZoneService;

public class ZoneServiceImpl implements ZoneService{

	private ZoneDao zoneDao;
	
	public List<Zone> getList(int pageCount, int pageStart, Zone zone){
		return zoneDao.getList(pageCount, pageStart, zone);
	}
	
	/**
	 * 取得地區資料總筆數
	 * @param zone
	 * @return Integer
	 */
	public Integer getCount(Zone zone){
		return zoneDao.getCount(zone);
	}
	
	/**
	 * 取得單筆地區資料
	 * @param Q&A
	 * @return Q&A
	 */
	public Zone getData(Zone zone){
		return zoneDao.getData(zone);
	}
	
	/**
	 * 新增地區資料
	 * @param zone
	 */
	public void add(Zone zone){
		zoneDao.add(zone);
	}
		
	/**
	 * 修改地區資料排序
	 * @param news
	 */
	public void updateSort(Zone zone){
		zoneDao.updateSort(zone);
	}	
	
	/**
	 * 修改地區資料
	 * @param zone
	 */
	public void update(Zone zone){
		zoneDao.update(zone);
	}
		
	/**
	 * 刪除地區資料
	 * @param id
	 */
	public void delete(Integer id){
		zoneDao.delete(id);
	}

	/**
	 * 重新排序地區資料
	 */
	public void resetSort() {
		 zoneDao.resetSort();
	}
	
	/**
	 * 檢查地區名稱
	 */
	public String checkZonename(Zone zone){
		return zoneDao.checkZonename(zone);
	}
	
	/**
	 * 地區form下拉選單的list
	 */
	public List<Zone> getZoneList(){
		return zoneDao.getZoneList();
	}
	
	public void setZoneDao(ZoneDao zoneDao) {
		this.zoneDao = zoneDao;
	}
}
