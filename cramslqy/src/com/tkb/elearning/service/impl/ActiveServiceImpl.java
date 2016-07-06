package com.tkb.elearning.service.impl;

import java.util.List;


import com.tkb.elearning.dao.ActiveDao;
import com.tkb.elearning.model.Active;
import com.tkb.elearning.service.ActiveService;

/**
* 活動訊息Service實作類
* @author Admin
* @version 創建時間：2016-04-26
*/
public class ActiveServiceImpl implements ActiveService{
     
	private ActiveDao activeDao; 
	/**
	 * 取得活動訊息清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param active
	 * @return List<Active>
	 * */
	public List<Active> getList(int pageCount, int pageStart, Active active){
		return activeDao.getList(pageCount, pageStart, active);
	}
	
	/**
	 * 取得活動訊息總筆數
	 * @param active
	 * @return Active
	 * */
	public Integer getCount(Active avtive){
		return activeDao.getCount(avtive);
	}
	
	/**
	 * 取得單筆活動訊息
	 * @param active
	 * */
	public Active getData(Active active){
		return activeDao.getData(active);
	}
	
	/**
	 * 新增活動訊息
	 * @param active
	 * */
	public void add(Active active){
		activeDao.add(active);
	}
	
	/**
	 * 修改活動訊息
	 * @param active
	 * */
	public void update(Active active){
		activeDao.update(active);
	}
	
	/**
	 * 刪除活動訊息
	 * @param id
	 * */
	public void delete(Integer id){
		activeDao.delete(id);
	}
	
	public Integer checkUsingPeriod(Active active) {
		return activeDao.checkUsingPeriod(active);
	}
	
	public void setActiveDao(ActiveDao activeDao){
		this.activeDao = activeDao;
	}
	
}
