package com.tkb.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.tkb.elearning.dao.EnsuredoDao;
import com.tkb.elearning.model.Ensuredo;

import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
	 * 品保do Dao實作類
	 * @author Admin
	 * @version 創建時間：2016-04-20
	 */
@SuppressWarnings("unchecked")
public class EnsuredoDaoImpl extends PagingDaoImpl implements EnsuredoDao {
				
	
		public List<Ensuredo> getList(int pageCount, int pageStart, Ensuredo ensuredo) {
			
			List<Object> args = new ArrayList<Object>();
			
			String sql = " SELECT * FROM ensure_do ";
			
			if(ensuredo.getDo_title() != null && !"".equals(ensuredo.getDo_title())) {
				sql += " WHERE DO_TITLE LIKE ? ";
				args.add("%" + ensuredo.getDo_title() + "%");
			}
//			
			sql += " ORDER BY ID DESC LIMIT ?, ? ";
//			
////			sql = " SELECT * FROM "
////				+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
////				+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
//			
			args.add(pageStart);
			args.add(pageCount+1);
			
			return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
			
		}
		
		public Integer getCount(Ensuredo ensuredo) {
			
			List<Object> args = new ArrayList<Object>();
			
			String sql = " SELECT COUNT(*) FROM ensure_do ";
			
			if(ensuredo.getDo_title() != null && !"".equals(ensuredo.getDo_title())) {
				sql += " WHERE TITLE LIKE ? ";
				args.add("%" + ensuredo.getDo_title() + "%");
			}
			
			return getJdbcTemplate().queryForInt(sql, args.toArray());
			
		}
		
		public Ensuredo getData(Ensuredo ensuredo) {
			
			String sql = " SELECT * FROM ensure_do WHERE ID = ? ";
			return (Ensuredo)getJdbcTemplate().query(sql, new Object[]{ensuredo.getId()}, getRowMapper()).get(0);
			
		}
			
		public void add(Ensuredo ensuredo) {
			
			String sql = "INSERT INTO ensure_do( DO_TITLE, DO_CONTENT, CREATE_DATE)VALUES(?, ?, NOW()) ";
			
			getJdbcTemplate().update(sql, new Object[] { ensuredo.getDo_title() ,ensuredo.getDo_content() });
			
		}
		
		public void update(Ensuredo ensuredo) {
			
			String sql = " UPDATE ensure_do SET DO_TITLE = ?, DO_CONTENT = ? WHERE ID = ?" ;
			
			getJdbcTemplate().update(sql, new Object[] { ensuredo.getDo_title(),  ensuredo.getDo_content(), ensuredo.getId() });
			
		}
		
		public void delete(Integer id) {
			
			String sql = " DELETE FROM ensure_do WHERE ID = ? ";
			
			getJdbcTemplate().update(sql, new Object[] { id });
			
		}

}
