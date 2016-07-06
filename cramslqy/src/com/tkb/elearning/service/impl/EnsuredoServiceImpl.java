package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.EnsuredoDao;
import com.tkb.elearning.dao.NewsDao;
import com.tkb.elearning.model.Ensuredo;
import com.tkb.elearning.model.News;
import com.tkb.elearning.service.EnsuredoService;

public class EnsuredoServiceImpl implements EnsuredoService{

	private EnsuredoDao ensuredoDao;
	
	/**
	 * 取得品保資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param ensuredo
	 * @return List<Ensuredo>
	 */	
	public List<Ensuredo> getList(int pageCount, int pageStart, Ensuredo ensuredo){
		
		return ensuredoDao.getList(pageCount, pageStart, ensuredo);
	}
	
	/**
	 * 取得品保總筆數
	 * @param ensuredo
	 * @return Integer
	 */
	public Integer getCount(Ensuredo ensuredo){
		return ensuredoDao.getCount(ensuredo);
	}
	
	/**
	 * 取得單筆品保
	 * @param ensuredo
	 * @return Ensuredo
	 */
	public Ensuredo getData(Ensuredo ensuredo){
		return ensuredoDao.getData(ensuredo);
	}
	
	/**
	 * 新增品保
	 * @param ensuredo
	 */
	public void add(Ensuredo ensuredo){
		ensuredoDao.add(ensuredo);
	}
	
	/**
	 * 修改品保
	 * @param ensuredo
	 */
	public void update(Ensuredo ensuredo){
		ensuredoDao.update(ensuredo);
	}
		
	/**
	 * 刪除品保
	 * @param id
	 */
	public void delete(Integer id){
		ensuredoDao.delete(id);
	}
	
	public void setEnsuredoDao(EnsuredoDao ensuredoDao) {
		this.ensuredoDao = ensuredoDao;
	}
}
