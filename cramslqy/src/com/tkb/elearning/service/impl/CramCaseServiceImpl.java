package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.CramCaseDao;
import com.tkb.elearning.model.CramCase;
import com.tkb.elearning.service.CramCaseService;

public class CramCaseServiceImpl implements CramCaseService{

	private CramCaseDao  cramCaseDao;

	public List<CramCase> getList(int pageCount, int pageStart, CramCase cramCase){
		
		return cramCaseDao.getList(pageCount, pageStart, cramCase);
	}

	public Integer getCount(CramCase cramCase){		
		
		return cramCaseDao.getCount(cramCase);
	}

	public CramCase getData(CramCase cramCase){
		
		return cramCaseDao.getData(cramCase);
	}
	
	public void add(CramCase cramCase){
		
		cramCaseDao.add(cramCase);
	}

	public void update(CramCase cramCase){
		
		cramCaseDao.update(cramCase);
	}
		
	public void delete(Integer id){
		
		cramCaseDao.delete(id);
	}	
	public void setCramCaseDao(CramCaseDao cramCaseDao) {
		
		this.cramCaseDao = cramCaseDao;	
	}
	
}
