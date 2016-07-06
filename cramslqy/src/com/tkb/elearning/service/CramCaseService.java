package com.tkb.elearning.service;

import java.util.List;

import com.tkb.elearning.model.CramCase;
import com.tkb.elearning.model.News;

/**
 * 最新消息Service介面接口
 * @author Admin
 * @version 創建時間：2016-03-24
 */
public interface CramCaseService {

	/**
	 * 取得補習糾紛案例資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param cramCase
	 * @return List<CramCase>
	 */
	public List<CramCase> getList(int pageCount, int pageStart, CramCase cramCase);
	
	/**
	 * 取得補習糾紛案例總筆數
	 * @param cramCase
	 * @return Integer
	 */
	public Integer getCount(CramCase cramCase);
	
	/**
	 * 取得單筆補習糾紛案例
	 * @param cramCase
	 * @return CramCase
	 */
	public CramCase getData(CramCase cramCase);
	
	/**
	 * 新增補習糾紛案例
	 * @param cramCase
	 */
	public void add(CramCase cramCase);
	
	/**
	 * 修改補習糾紛案例
	 * @param cramCase
	 */
	public void update(CramCase cramCase);
		
	/**
	 * 刪除補習糾紛案例
	 * @param id
	 */
	public void delete(Integer id);
	
}
