package com.tkb.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.tkb.elearning.dao.EnsureRightDao;
import com.tkb.elearning.model.EnsureRight;

import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 品保權益 Dao實作類
 * @author Admin
 * @version 創建時間：2016-04-20
 */
public class EnsureRightDaoImpl extends PagingDaoImpl implements EnsureRightDao {
	
	
	@SuppressWarnings("unchecked")
	public List<EnsureRight> getList(int pageCount, int pageStart, EnsureRight ensureRight) {
	
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT * FROM ensure_right ";
	
		if(ensureRight.getRight_title() != null && !"".equals(ensureRight.getRight_title())) {
			sql += " WHERE RIGHT_TITLE LIKE ? ";
			args.add("%" + ensureRight.getRight_title() + "%");
		}
		//
		sql += " ORDER BY ID DESC LIMIT ?, ? ";
		//
		////sql = " SELECT * FROM "
		////	+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
		////	+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
		//
		args.add(pageStart);
		args.add(pageCount+1);
		
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		
	}
	
		public Integer getCount(EnsureRight ensuredo) {
		
			List<Object> args = new ArrayList<Object>();
			
			String sql = " SELECT COUNT(*) FROM ensure_do ";
		
			if(ensuredo.getRight_title() != null && !"".equals(ensuredo.getRight_title())) {
				sql += " WHERE RIGHT_TITLE LIKE ? ";
				args.add("%" + ensuredo.getRight_title() + "%");
		}
		
			return getJdbcTemplate().queryForInt(sql, args.toArray());
		
		}
		
		public EnsureRight getData(EnsureRight ensureRight) {
		
		String sql = " SELECT * FROM ensure_right WHERE ID = ? ";
		return (EnsureRight)getJdbcTemplate().query(sql, new Object[]{ensureRight.getId()}, getRowMapper()).get(0);
		
		}
		
		public void add(EnsureRight ensureRight) {
		
		String sql = "INSERT INTO ensure_right( RIGHT_TITLE, RIGHT_CONTENT, CREATE_DATE)VALUES(?, ?, NOW()) ";
		
		getJdbcTemplate().update(sql, new Object[] { ensureRight.getRight_title() ,ensureRight.getRight_content() });
		
		}
		
		public void update(EnsureRight ensureRight) {
		
		String sql = " UPDATE ensure_do SET RIGHT_TITLE = ?, RIGHT_CONTENT = ? WHERE ID = ?" ;
		
		getJdbcTemplate().update(sql, new Object[] { ensureRight.getRight_title(),  ensureRight.getRight_content(), ensureRight.getId() });
		
		}
		
		public void delete(Integer id) {
		
		String sql = " DELETE FROM ensure_right WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { id });
		
		}
}