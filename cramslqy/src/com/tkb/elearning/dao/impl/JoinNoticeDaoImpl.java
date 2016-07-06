package com.tkb.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.tkb.elearning.dao.JoinNoticeDao;
import com.tkb.elearning.model.JoinNotice;

import sso.ojdbc.dao.impl.PagingDaoImpl;

public class JoinNoticeDaoImpl extends PagingDaoImpl implements JoinNoticeDao {
	
	
	@SuppressWarnings("unchecked")
	public List<JoinNotice> getList(int pageCount, int pageStart, JoinNotice joinNotice) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT * FROM join_notice ";
		
		if(joinNotice.getContent() != null && !"".equals(joinNotice.getContent())) {
			sql += " WHERE CONTENT LIKE ? ";
			args.add("%" + joinNotice.getContent() + "%");
		}
//		
		sql += " ORDER BY ID DESC LIMIT ?, ? ";
//		
////		sql = " SELECT * FROM "
////			+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
////			+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
//		
		args.add(pageStart);
		args.add(pageCount+1);
		
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		
	}
	
	public Integer getCount(JoinNotice joinNotice) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM join_notice ";
		
		if(joinNotice.getContent() != null && !"".equals(joinNotice.getContent())) {
			sql += " WHERE join_notice LIKE ? ";
			args.add("%" + joinNotice.getContent() + "%");
		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public JoinNotice getData(JoinNotice joinNotice) {
		
		String sql = " SELECT * FROM join_notice WHERE ID = ? ";
		return (JoinNotice)getJdbcTemplate().query(sql, new Object[]{ joinNotice.getId() }, getRowMapper()).get(0);
		
	}
		
	public void add(JoinNotice joinNotice) {
		
		String sql = "INSERT INTO join_notice(CONTENT, CREATE_DATE)VALUES(?, NOW())";
				 		
		getJdbcTemplate().update(sql, new Object[] {joinNotice.getContent()});
		
	}
	
	public void update(JoinNotice joinNotice) {
		
		String sql = " UPDATE join_notice SET CONTENT = ? WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { joinNotice.getContent(), joinNotice.getId()});
		
	}
	
	public void delete(Integer id ) {
		
		String sql = " DELETE FROM join_notice WHERE ID = ? ";
		getJdbcTemplate().update(sql, new Object[] { id });
	}
}
