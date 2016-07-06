package com.tkb.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.tkb.elearning.dao.AboutLawDao;
import com.tkb.elearning.model.AboutLaw;

import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 相關法規Dao實作類
 * @author Admin
 * @version 創建時間：2016-03-14
 */
public class AboutLawDaoImpl extends PagingDaoImpl implements AboutLawDao {
	
	@SuppressWarnings("unchecked")
	public List<AboutLaw> getList(int pageCount, int pageStart, AboutLaw aboutLaw) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT * FROM about_law ";
		
		if(aboutLaw.getTitle() != null && !"".equals(aboutLaw.getTitle())) {
			sql += " WHERE TITLE LIKE ? ";
			args.add("%" + aboutLaw.getTitle() + "%");
		}
		
		sql += " ORDER BY ID LIMIT ?, ? ";
		
//		sql = " SELECT * FROM "
//			+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
//			+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
		
		args.add(pageStart);
		args.add(pageCount);
		
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		
	}
	
	public Integer getCount(AboutLaw aboutLaw) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM about_law ";
		
		if(aboutLaw.getTitle() != null && !"".equals(aboutLaw.getTitle())) {
			sql += " WHERE TITLE LIKE ? ";
			args.add("%" + aboutLaw.getTitle() + "%");
		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public AboutLaw getData(AboutLaw aboutLaw) {
		
		String sql = " SELECT * FROM about_law WHERE ID = ? ";
		return (AboutLaw)getJdbcTemplate().query(sql, new Object[]{ aboutLaw.getId() }, getRowMapper()).get(0);
		
	}
	
	public void add(AboutLaw aboutLaw) {
		
		String sql = " INSERT INTO about_law(TITLE, CONTENT,  FILE, "
				   + " CREATE_DATE, UPDATE_DATE)VALUES(?, ?, ?, NOW(), NOW()) ";
		
		getJdbcTemplate().update(sql, new Object[] { aboutLaw.getTitle(),
				aboutLaw.getContent(), aboutLaw.getFile() });
		
	}
	
	public void update(AboutLaw aboutLaw) {
		
		String sql = " UPDATE about_law SET TITLE = ?,CONTENT = ?, "
				   + " FILE = ?, UPDATE_DATE = NOW() WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { aboutLaw.getTitle(), aboutLaw.getContent(), 
		aboutLaw.getFile(), aboutLaw.getId() });
		
	}
	
	public void delete(Integer id) {
		
		String sql = " DELETE FROM about_law WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { id });
		
	}
	
}

