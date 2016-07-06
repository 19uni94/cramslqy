package com.tkb.elearning.dao.impl;

import java.util.ArrayList;


import java.util.List;

import com.tkb.elearning.dao.NewsDao;
import com.tkb.elearning.model.News;

import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 最新消息Dao實作類
 * @author Admin
 * @version 創建時間：2016-03-14
 */
@SuppressWarnings("unchecked")
public class NewsDaoImpl extends PagingDaoImpl implements NewsDao {
	
	public List<News> getIndexList(News news){
		List<Object> args = new ArrayList<Object>();
		String sql = "SELECT * FROM news WHERE 1=1 ";
		
		if(news.getTitle() != null && !"".equals(news.getTitle())) {
			sql += " AND TITLE LIKE ? ";
			args.add("%" + news.getTitle() + "%");
		}
		sql += " AND INDEX_SHOW = '1' ORDER BY INDEX_SHOW DESC LIMIT 10; ";
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		
		}
	
	public List<News> getFrontList(int pageCount, int pageStart, News news){
		List<Object> args = new ArrayList<Object>();
		String sql = "SELECT * FROM news WHERE 1=1 ";
		
		if(news.getTitle() != null && !"".equals(news.getTitle())) {
			sql += " AND TITLE LIKE ? ";
			args.add("%" + news.getTitle() + "%");
		}
		sql += " AND DATEDIFF(NEWS_START,NOW())<=0 AND DATEDIFF(NEWS_END,NOW())>0; ";
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		
		}
	
	public List<News> getList(int pageCount, int pageStart, News news) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT * FROM news WHERE 1=1 ";
		
		if(news.getTitle() != null && !"".equals(news.getTitle())) {
			sql += " AND TITLE LIKE ? ";
			args.add("%" + news.getTitle() + "%");
		}
		
		if(news.getContent() != null && !"".equals(news.getContent())) {
			sql += " AND CONTENT LIKE ?";
			args.add("%" + news.getContent() + "%");
		}
		sql += " ORDER BY TOP DESC,INDEX_SHOW DESC,CREATE_DATE DESC,ID DESC LIMIT ?, ? ";
//		
////		sql = " SELECT * FROM "
////			+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
////			+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
//		
		args.add(pageStart);
		args.add(pageCount);

		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		
	}
	
	public Integer getCount(News news) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM news WHERE 1=1 ";
		
		if(news.getTitle() != null && !"".equals(news.getTitle())) {
			sql += "AND TITLE LIKE ? ";
			args.add("%" + news.getTitle() + "%");
		}
		
		if(news.getContent() != null && !"".equals(news.getContent())) {
			sql += " AND CONTENT LIKE ?";
			args.add("%" + news.getContent() + "%");
		}
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public Integer getCount2(News news) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM news WHERE 1=1";
		
		if(news.getTitle() != null && !"".equals(news.getTitle())) {
			sql += " AND TITLE LIKE ? ";
			args.add("%" + news.getTitle() + "%");
		}
		
		sql += " AND DATEDIFF(NEWS_START,NOW())<=0 AND DATEDIFF(NEWS_END,NOW())>0; ";
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public News getData(News news) {
		
		String sql = " SELECT * FROM news WHERE ID = ? ";
		return (News)getJdbcTemplate().query(sql, new Object[]{news.getId()}, getRowMapper()).get(0);
		
	}
		
	public void add(News news) {
		
		String sql = "INSERT INTO news( TITLE, NEWS_START,  NEWS_END, INDEX_SHOW, IMAGE, BRIEF_INTRODUCTION, CONTENT, "
				+ "TOP, CREATE_DATE, UPDATE_DATE)VALUES(?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW()) ";
		
		getJdbcTemplate().update(sql, new Object[] { news.getTitle(), news.getNews_start(), news.getNews_end(), news.getIndex_show(), 
				news.getImage(), news.getBrief_introduction(),  news.getContent(), news.getTop() });
		
	}
	
	public void update(News news) {
		
		String sql = " UPDATE news SET TITLE = ?, NEWS_START = ?, NEWS_END = ?, INDEX_SHOW = ?, IMAGE = ?, BRIEF_INTRODUCTION = ?, "
				+ "CONTENT = ?, TOP = ?, UPDATE_DATE = NOW() WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { news.getTitle(), news.getNews_start(), news.getNews_end(), news.getIndex_show(), 
				news.getImage(), news.getBrief_introduction(), news.getContent(), news.getTop(),  news.getId() });
		
	}
	
	public void delete(Integer id) {
		
		String sql = " DELETE FROM news WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { id });
		
	}
	
	public Integer checkIndexNews(News news){
		String sql = "SELECT COUNT(*) FROM news WHERE INDEX_SHOW = 1";
		return getJdbcTemplate().queryForInt(sql);
	}
	
}
