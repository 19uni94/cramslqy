package com.tkb.elearning.dao.impl;

import java.util.ArrayList;

import java.util.List;

import com.tkb.elearning.dao.CramCaseDao;
import com.tkb.elearning.model.CramCase;

import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 補習糾紛案例Dao實作類
 * @author Admin
 * @version 創建時間：2016-03-24
 */
public class CramCaseDaoImpl extends PagingDaoImpl implements CramCaseDao{

	@SuppressWarnings("unchecked")
	public List<CramCase> getList(int pageCount, int pageStart, CramCase cramCase){
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = "SELECT * FROM cram_case";
		
		if(cramCase.getCase_name()!=null && "".equals(cramCase.getCase_name())){
			sql += "WHERE CASE_NAME LIKE ?";
			args.add("%" + cramCase.getCase_name() + "%");
		}
		sql += " ORDER BY ID LIMIT ?, ? ";
		
//		sql = " SELECT * FROM "
//			+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
//			+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
		
		args.add(pageStart);
		args.add(pageCount);
		
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());		
	}
	
	public Integer getCount(CramCase cramCase) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM cram_case ";
		
		if(cramCase.getCase_name() != null && !"".equals(cramCase.getCase_name())) {
			sql += " WHERE CASE_NAME LIKE ? ";
			args.add("%" + cramCase.getCase_name() + "%");
		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public CramCase getData(CramCase cramCase) {
		
		String sql = " SELECT * FROM cram_case WHERE ID = ? ";
		return (CramCase)getJdbcTemplate().query(sql, new Object[]{ cramCase.getId() }, getRowMapper()).get(0);
		
	}
	
	public void add(CramCase cramCase) {
		
		String sql = "INSERT INTO cram_case( CASE_NAME, IMAGE, BRIEF_INTRODUCTION, CASE_CONTENT, "
				+ "CREATE_DATE, UPDATE_DATE)VALUES(?, ?, ?, ?, NOW(), NOW()) ";
		
		getJdbcTemplate().update(sql, new Object[] { cramCase.getCase_name(), cramCase.getImage(),cramCase.getBrief_introduction(), 
				cramCase.getCase_content()});
		
	}
	
	public void update(CramCase cramCase) {
		
		String sql = " UPDATE cram_case SET CASE_NAME = ?, IMAGE = ?, BRIEF_INTRODUCTION = ?, "
				+ "CASE_CONTENT = ?,  UPDATE_DATE = NOW() WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { cramCase.getCase_name(), cramCase.getImage(), 
				cramCase.getBrief_introduction(), cramCase.getCase_content(), cramCase.getId() });
		
	}
	
	public void delete(Integer id) {
		
		String sql = " DELETE FROM cram_case WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { id });
		
	}
	
}
