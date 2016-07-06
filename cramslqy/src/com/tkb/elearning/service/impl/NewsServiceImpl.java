package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.NewsDao;
import com.tkb.elearning.model.News;
import com.tkb.elearning.service.NewsService;

/**
 * 最新消息Service實作類
 * @author Admin
 * @version 創建時間：2016-03-15
 */
public class NewsServiceImpl implements NewsService {

	private NewsDao newsDao;
			
	public List<News> getIndexList(News news){
		return newsDao.getIndexList(news);
	}
	
	public List<News> getFrontList(int pageCount, int pageStart, News news){
		return newsDao.getFrontList(pageCount, pageStart, news);
	}
	
	public List<News> getList(int pageCount, int pageStart, News news) {
		return newsDao.getList(pageCount, pageStart, news);
	}
	
	public Integer getCount(News news) {
		return newsDao.getCount(news);
	}
	
	public Integer getCount2(News news) {
		return newsDao.getCount2(news);
	}
	
	public News getData(News news) {
		return newsDao.getData(news);
	}

	public void add(News news) {
		newsDao.add(news);
	}
	
	public void update(News news) {
		newsDao.update(news);
	}
	
	public void delete(Integer id) {
		newsDao.delete(id);
	}

	public Integer checkIndexNews(News news){
		return newsDao.checkIndexNews(news);
	}
	
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
}
	