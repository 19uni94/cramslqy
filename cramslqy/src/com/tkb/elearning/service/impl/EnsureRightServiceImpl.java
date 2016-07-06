package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.EnsureRightDao;
import com.tkb.elearning.model.EnsureRight;
import com.tkb.elearning.service.EnsureRightService;



public class EnsureRightServiceImpl implements EnsureRightService{

	private EnsureRightDao ensureRightDao;
	
	/**
	 * 取得品保權益資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param ensureRight
	 * @return List<EnsureRight>
	 */	
	public List<EnsureRight> getList(int pageCount, int pageStart, EnsureRight ensureRight){
		
		return ensureRightDao.getList(pageCount, pageStart, ensureRight);
	}
	
	/**
	 * 取得品保權益總筆數
	 * @param ensuredo
	 * @return Integer
	 */
	public Integer getCount(EnsureRight ensureRight){
		return ensureRightDao.getCount(ensureRight);
	}
	
	/**
	 * 取得單筆品保權益
	 * @param ensureRight
	 * @return EnsureRight
	 */
	public EnsureRight getData(EnsureRight ensureRight){
		return ensureRightDao.getData(ensureRight);
	}
	
	/**
	 * 新增品保權益
	 * @param ensureRight
	 */
	public void add(EnsureRight ensureRight){
		ensureRightDao.add(ensureRight);
	}
	
	/**
	 * 修改品保權益
	 * @param ensuredo
	 */
	public void update(EnsureRight ensureRight){
		ensureRightDao.update(ensureRight);
	}
		
	/**
	 * 刪除品保權益
	 * @param id
	 */
	public void delete(Integer id){
		ensureRightDao.delete(id);
	}
	
	public void setEnsureRightDao(EnsureRightDao ensureRightDao) {
		this.ensureRightDao = ensureRightDao;
	}
}
