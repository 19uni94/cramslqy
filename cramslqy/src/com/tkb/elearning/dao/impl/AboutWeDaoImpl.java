package com.tkb.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;


import com.tkb.elearning.dao.AboutWeDao;
import com.tkb.elearning.model.AboutWe;

import sso.ojdbc.dao.impl.PagingDaoImpl;

public class AboutWeDaoImpl extends PagingDaoImpl implements AboutWeDao {
	
	@SuppressWarnings("unchecked")
	public List<AboutWe> getList(int pageCount, int pageStart, AboutWe aboutWe) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT * FROM about_we ";
		
		if(aboutWe.getTitle() != null && !"".equals(aboutWe.getTitle())) {
			sql += " WHERE TITLE LIKE ? ";
			args.add("%" + aboutWe.getTitle() + "%");
		}
		
		sql += " ORDER BY ID LIMIT ?, ? ";
		
//		sql = " SELECT * FROM "
//			+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
//			+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
		
		args.add(pageStart);
		args.add(pageCount);
		
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		
	}
	
	public Integer getCount(AboutWe aboutWe) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM about_we ";
		
		if(aboutWe.getTitle() != null && !"".equals(aboutWe.getTitle())) {
			sql += " WHERE TITLE LIKE ? ";
			args.add("%" + aboutWe.getTitle() + "%");
		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public AboutWe getData(AboutWe aboutWe) {
		
		String sql = " SELECT * FROM about_we WHERE ID = ? ";
		return (AboutWe)getJdbcTemplate().query(sql, new Object[]{ aboutWe.getId() }, getRowMapper()).get(0);
		
	}
	
	public void add(AboutWe aboutWe) {
		
		String sql = " INSERT INTO about_we(TITLE, CONTENT,  CREATE_DATE)VALUES(?, ?, NOW()) ";
		
		getJdbcTemplate().update(sql, new Object[] { aboutWe.getTitle(), aboutWe.getContent()});
		
	}
	
	public void update(AboutWe aboutWe) {
		
		String sql = " UPDATE about_we SET TITLE = ?, CONTENT = ? WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { aboutWe.getTitle(), aboutWe.getContent(), aboutWe.getId() });
		
	}
	
	public void delete(Integer id) {
		
		String sql = " DELETE FROM about_we WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { id });
		
	}
	
}
