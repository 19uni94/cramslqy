package com.tkb.elearning.service.impl;

import java.util.List;


import com.tkb.elearning.dao.AboutWeDao;
import com.tkb.elearning.model.AboutWe;
import com.tkb.elearning.service.AboutWeService;

public class AboutWeServiceImpl implements AboutWeService{

	private AboutWeDao aboutWeDao;
	
	/**
	 * 取得關於我們資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param aboutWe
	 * @return List<AboutWe>
	 */
	public List<AboutWe> getList(int pageCount, int pageStart, AboutWe aboutWe){
		
		return aboutWeDao.getList(pageCount, pageStart, aboutWe);
	}
	
	/**
	 * 取得關於我們總筆數
	 * @param aboutWe
	 * @return Integer
	 */
	public Integer getCount(AboutWe aboutWe){
		return aboutWeDao.getCount(aboutWe);
	}
	
	/**
	 * 取得單筆關於我們
	 * @param aboutWe
	 * @return AboutWe
	 */
	public AboutWe getData(AboutWe aboutWe){
		return aboutWeDao.getData(aboutWe);
	}
	
	/**
	 * 新增關於我們
	 * @param aboutWe
	 */
	public void add(AboutWe aboutWe){
		aboutWeDao.add(aboutWe);
	}
	
	/**
	 * 修改關於我們
	 * @param aboutWe
	 */
	public void update(AboutWe aboutWe){
		aboutWeDao.update(aboutWe);
	}
		
	/**
	 * 刪除關於我們
	 * @param id
	 */
	public void delete(Integer id){
		aboutWeDao.delete(id);
	}
	
	public void setAboutWeDao(AboutWeDao aboutWeDao) {
		this.aboutWeDao = aboutWeDao;
	}
}
