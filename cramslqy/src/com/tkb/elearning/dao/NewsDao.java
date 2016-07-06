package com.tkb.elearning.dao;

import java.util.List;


import com.tkb.elearning.model.News;

/**
 * 最新消息Dao介面接口
 * @author Admin
 * @version 創建時間：2016-03-15
 */
public interface NewsDao {

	/**
	 * 取得News前台首頁清單
	 * @param news
	 * @return List<News>
	 */
	public List<News> getIndexList(News news);
	
	/**
	 * 取得前台News清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param news
	 * @param news
	 * @return List<News>
	 * */
	public List<News> getFrontList(int pageCount, int pageStart, News news);
	
	/**
	 * 取得最新消息資料清單(分頁)
	 * @param news
	 * @param pageCount
	 * @param pageStart
	 * @return List<News>
	 */
	public List<News> getList(int pageCount, int pageStart, News news);
	
	/**
	 * 取得最新消息總筆數
	 * @param news
	 * @return Integer
	 */
	public Integer getCount(News news);
	
	/**
	 * 取得前台最新消息總筆數
	 * @param news
	 * @return Integer
	 */
	public Integer getCount2(News news);
	
	/**
	 * 取得單筆最新消息
	 * @param news
	 * @return News
	 */
	public News getData(News news);
	
	/**
	 * 新增最新消息
	 * @param news
	 */
	public void add(News news);
	
	/**
	 * 修改最新消息
	 * @param news
	 */
	public void update(News news);
	
	/**
	 * 刪除最新消息
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 檢查首頁顯示是否超過10則
	 * */
	public Integer checkIndexNews(News news);
	
}
