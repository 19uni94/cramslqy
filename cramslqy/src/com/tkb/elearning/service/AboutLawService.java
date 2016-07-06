package com.tkb.elearning.service;

import java.util.List;

import com.tkb.elearning.model.AboutLaw;


/**
 * 相關法規Service介面接口
 * @author Admin
 * @version 創建時間：2016-03-15
 */
public interface AboutLawService {

	/**
	 * 取得相關法規資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param aboutLaw
	 * @return List<AboutLaw>
	 */
	public List<AboutLaw> getList(int pageCount, int pageStart, AboutLaw aboutLaw);
	
	/**
	 * 取得相關法規總筆數
	 * @param aboutLaw
	 * @return Integer
	 */
	public Integer getCount(AboutLaw aboutLaw);
	
	/**
	 * 取得單筆相關法規
	 * @param aboutLaw
	 * @return AboutLaw
	 */
	public AboutLaw getData(AboutLaw aboutLaw);
	
	/**
	 * 新增相關法規
	 * @param aboutLaw
	 */
	public void add(AboutLaw aboutLaw);
	
	/**
	 * 修改相關法規
	 * @param aboutLaw
	 */
	public void update(AboutLaw aboutLaw);
		
	/**
	 * 刪除相關法規
	 * @param id
	 */
	public void delete(Integer id);
	
}