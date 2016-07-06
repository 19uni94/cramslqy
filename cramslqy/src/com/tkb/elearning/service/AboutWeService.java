package com.tkb.elearning.service;

import java.util.List;


import com.tkb.elearning.model.AboutWe;

/**
 * 關於我們Service介面接口
 * @author Admin
 * @version 創建時間：2016-04-21
 */
public interface AboutWeService {

	/**
	 * 取得關於我們資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param aboutWe
	 * @return List<AboutWe>
	 */
	public List<AboutWe> getList(int pageCount, int pageStart, AboutWe aboutWe);
	
	/**
	 * 取得關於我們總筆數
	 * @param aboutWe
	 * @return Integer
	 */
	public Integer getCount(AboutWe aboutWe);
	
	/**
	 * 取得單筆關於我們
	 * @param aboutWe
	 * @return AboutWe
	 */
	public AboutWe getData(AboutWe aboutWe);
	
	/**
	 * 新增關於我們
	 * @param aboutWe
	 */
	public void add(AboutWe aboutWe);
	
	/**
	 * 修改關於我們
	 * @param aboutWe
	 */
	public void update(AboutWe aboutWe);
		
	/**
	 * 刪除關於我們
	 * @param id
	 */
	public void delete(Integer id);
	
}