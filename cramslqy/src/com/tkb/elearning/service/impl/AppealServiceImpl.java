package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.AppealDao;
import com.tkb.elearning.model.Appeal;
import com.tkb.elearning.service.AppealService;

public class AppealServiceImpl implements AppealService{
	
	private AppealDao appealDao;
	
	/**
	 * 取得申訴專區資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param appeal
	 * @return List<Appeal>
	 * */
	public List<Appeal> getList(int pageCount, int pageStart, Appeal appeal){
		return appealDao.getList(pageCount, pageStart, appeal);
	}
	
	/**
	 * 取得申訴專區資料總筆數
	 * @param appeal
	 * @return Appeal
	 * */
	public Integer getCount(Appeal appeal){
		return appealDao.getCount(appeal);
	}
	
	/**
	 * 取得單筆申訴專區資料
	 * @param appeal
	 * */
	public Appeal getData(Appeal appeal){
		return appealDao.getData(appeal);
	}
	
	/**
	 * 新增申訴專區資料
	 * @param appeal
	 * */
	public void add(Appeal appeal){
		appealDao.add(appeal);
	}
	
	/**
	 * 修改申訴專區資料
	 * @param appeal
	 * */
	public void update(Appeal appeal){
		appealDao.update(appeal);
	}
	
	/**
	 * 刪除申訴專區資料
	 * @param id
	 * */
	public void delete(Integer id){
		appealDao.delete(id);
	}
	
//	/**
//	 * 檢查屆別使用筆數
//	 * @param movieData
//	 * @return Integer
//	 */
//	public Integer checkUsingPeriod(Appeal appeal);

	public void setAppealDao(AppealDao appealDao){
		this.appealDao = appealDao;
	}
}
