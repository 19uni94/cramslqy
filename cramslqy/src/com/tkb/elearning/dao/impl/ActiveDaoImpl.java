package com.tkb.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.tkb.elearning.dao.ActiveDao;
import com.tkb.elearning.model.Active;

import sso.ojdbc.dao.impl.PagingDaoImpl;

public class ActiveDaoImpl extends PagingDaoImpl implements ActiveDao{

	@SuppressWarnings("unchecked")
	public List<Active> getList(int pageCount, int pageStart, Active active){
		
		List<Object> args = new ArrayList<Object>();
	    String sql = "SELECT * FROM active";
	    if(active.getActive_name() != null && !"".equals(active.getActive_name())){
	    	sql +="WHERE ACTIVE_NAME LIKE";
	    	args.add("%" + active.getActive_name() + "%");
	    }
	    sql += " ORDER BY ID LIMIT ?, ?";
	    
	    args.add(pageStart);//※注意pageStart和pageCount順序
	    args.add(pageCount);
	    
	    return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
	}
	
	public Integer getCount(Active active){
		
		List<Object> args = new ArrayList<Object>();
		String sql = "SELECT COUNT(*) FROM active";
		if(active.getActive_name() !=null && !"".equals(active.getActive_name())){
			sql += "WHERE ACTIVE_NAME LIKE";
			args.add("%" + active.getActive_name() + "%");
		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
	}
	
	public Active getData(Active active){
		
		String sql = "SELECT * FROM active WHERE ID = ?";
		return(Active)getJdbcTemplate().query(sql, new Object[]{active.getId()}, getRowMapper()).get(0);
	}
	
	public void add(Active active){
		
		String sql = "INSERT INTO active(CLASS_NO, ACTIVE_NAME, ACTIVE_DATE, BRIEF_INTRODUCTION, CREATE_DATE)"
				+ "VALUE(?, ?, ?, ?, NOW())";
		getJdbcTemplate().update(sql, new Object[]{active.getClass_no(), active.getActive_name(), active.getActive_date(), 
								active.getBrief_introduction()});
		
	}
	
	public void update(Active active){
		
		String sql = "UPDATE active SET CLASS_NO = ?, ACTIVE_NAME = ?, ACTIVE_DATE = ?, BRIEF_INTRODUCTION = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[]{active.getClass_no(), active.getActive_name(), active.getActive_date(), 
				active.getBrief_introduction()});
	}
	
	public void delete(Integer id){
		String sql = "DELETE FROM active WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] {id});
	}
	
	public Integer checkUsingPeriod(Active active) {
		String sql = "SELECT count(*) FROM active group by class_no = ? ";
		return getJdbcTemplate().queryForInt(sql, new Object[]{ active.getClass_no() });
	}
}
