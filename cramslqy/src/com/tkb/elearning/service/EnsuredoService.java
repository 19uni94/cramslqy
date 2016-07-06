package com.tkb.elearning.service;

import java.util.List;

import com.tkb.elearning.model.Ensuredo;
import com.tkb.elearning.model.News;

/**
 * 品保do Service介面接口
 * @author Admin
 * @version 創建時間：2016-04-20
 */
public interface EnsuredoService {
	
	/**
	 * 取得品保資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param ensuredo
	 * @return List<Ensuredo>
	 */	
	public List<Ensuredo> getList(int pageCount, int pageStart, Ensuredo ensuredo);
	
	/**
	 * 取得品保總筆數
	 * @param ensuredo
	 * @return Integer
	 */
	public Integer getCount(Ensuredo ensuredo);
	
	/**
	 * 取得單筆品保
	 * @param ensuredo
	 * @return Ensuredo
	 */
	public Ensuredo getData(Ensuredo ensuredo);
	
	/**
	 * 新增品保
	 * @param ensuredo
	 */
	public void add(Ensuredo ensuredo);
	
	/**
	 * 修改品保
	 * @param ensuredo
	 */
	public void update(Ensuredo ensuredo);
		
	/**
	 * 刪除品保
	 * @param id
	 */
	public void delete(Integer id);
}
