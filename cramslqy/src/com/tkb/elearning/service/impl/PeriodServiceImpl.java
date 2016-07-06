package com.tkb.elearning.service.impl;

import java.util.List;


import com.tkb.elearning.dao.PeriodDao;
import com.tkb.elearning.model.Period;
import com.tkb.elearning.service.PeriodService;

/**
 * 屆別管理Service實作類
 * @author Admin
 * @version 創建時間：2016-04-18
 */
public class PeriodServiceImpl implements PeriodService {

	private PeriodDao periodDao;	
	
//	public List<Session> getFrontList(){
//		return sessionDao.getFrontList();
//	}
		
	public List<Period> getList(int pageCount, int pageStart, Period period) {
		return periodDao.getList(pageCount, pageStart, period);
	}
	
	public Integer getCount(Period period) {
		return periodDao.getCount(period);
	}
	
	public Period getData(Period period) {
		return periodDao.getData(period);
	}

	public void add(Period period) {
		periodDao.add(period);
	}
	
	public void update(Period period) {
		periodDao.update(period);
	}
	
	public void delete(Integer id ) {
		periodDao.delete(id);
	}

	public List<Period> getPeriodList(){
		return periodDao.getPeriodList();
	}
	
	public Integer checkClassNo(Period period){
		return periodDao.checkClassNo(period);
	}
	
	public void setPeriodDao(PeriodDao periodDao) {
		this.periodDao = periodDao;
	}
}