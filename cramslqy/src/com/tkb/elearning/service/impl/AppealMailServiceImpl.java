package com.tkb.elearning.service.impl;

import java.util.List;


import com.tkb.elearning.dao.AppealMailDao;
import com.tkb.elearning.model.AppealMail;
import com.tkb.elearning.service.AppealMailService;

/**
 * 申訴專區Mail實作類
 * @author Admin
 * @version 創建時間:2016-05-30
 * */
public class AppealMailServiceImpl implements AppealMailService{
	
	private AppealMailDao appealMailDao;
	
	/**
	 * 取得申訴專區Mail清單
	 * @param appealMail
	 * @return List<AppealMail>
	 * */
	public  List<AppealMail> getList(int pageCount, int pageStart, AppealMail appealMail){
		return appealMailDao.getList(pageCount, pageStart, appealMail);
	}
	
	/**
	 * 取得申訴專區Mail總筆數
	 * @param appealMail
	 * @return Integer
	 * */
	public Integer getCount(AppealMail appealMail){
		return appealMailDao.getCount(appealMail);
	}
	
	/**
	 * 取得單筆申訴專區Mail
	 * @param appealMail
	 * @return AppealMail
	 * */
	public AppealMail getData(AppealMail appealMail){
		return appealMailDao.getData(appealMail);
	}
		
	/**
	 * 新增申訴專區Mail
	 * @param appealMail
	 * */
	public void add(AppealMail appealMail){
		appealMailDao.add(appealMail);
	}
	
	/**
	 * 修改申訴專區Mail
	 * @param appealMail
	 * */
	public void update(AppealMail appealMail){
		appealMailDao.update(appealMail);
	}
	
	/**
	 * 刪除申訴專區Mail
	 * @param id
	 * */
	public void delete(Integer id){
		appealMailDao.delete(id);
	}
	
	public void setAppealMailDao(AppealMailDao appealMailDao){
		this.appealMailDao = appealMailDao;
	}
}
