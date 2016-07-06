package com.tkb.elearning.dao;

import java.util.List;

import com.tkb.elearning.model.AppealMail;

/**
 * 申訴專區Mail Dao介面街口
 * @author Admin
 * @version 創建時間:2016-05-30
 * */
public interface AppealMailDao {
	
	/**
	 * 取得申訴專區Mail清單
	 * @param appealMail
	 * @return List<AppealMail>
	 * */
	public  List<AppealMail> getList(int pageCount, int pageStart, AppealMail appealMail);
	
	/**
	 * 取得申訴專區Mail總筆數
	 * @param appealMail
	 * @return Integer
	 * */
	public Integer getCount(AppealMail appealMail);
	
	/**
	 * 取得單筆申訴專區Mail
	 * @param appealMail
	 * @return AppealMail
	 * */
	public AppealMail getData(AppealMail appealMail);
		
	/**
	 * 新增申訴專區Mail
	 * @param appealMail
	 * */
	public void add(AppealMail appealMail);
	
	/**
	 * 修改申訴專區Mail
	 * @param appealMail
	 * */
	public void update(AppealMail appealMail);
	
	/**
	 * 刪除申訴專區Mail
	 * @param id
	 * */
	public void delete(Integer id);

}
