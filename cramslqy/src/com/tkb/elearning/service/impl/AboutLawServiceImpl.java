package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.AboutLawDao;
import com.tkb.elearning.model.AboutLaw;
import com.tkb.elearning.service.AboutLawService;


/**
 * 相關法規Service實作類
 * @author Admin
 * @version 創建時間：2016-03-15
 */
public class AboutLawServiceImpl implements AboutLawService {

	private AboutLawDao aboutLawDao;
	
	public List<AboutLaw> getList(int pageCount, int pageStart, AboutLaw aboutLaw) {
		return aboutLawDao.getList(pageCount, pageStart, aboutLaw);
	}
	
	public Integer getCount(AboutLaw aboutLaw) {
		return aboutLawDao.getCount(aboutLaw);
	}
	
	public AboutLaw getData(AboutLaw aboutLaw) {
		return aboutLawDao.getData(aboutLaw);
	}
	
	public void add(AboutLaw aboutLaw) {
		aboutLawDao.add(aboutLaw);
	}
	
	public void update(AboutLaw aboutLaw) {
		aboutLawDao.update(aboutLaw);
	}
	
	public void delete(Integer id) {
		aboutLawDao.delete(id);
	}

	public void setAboutLawDao(AboutLawDao aboutLawDao) {
		this.aboutLawDao = aboutLawDao;
	}
}
