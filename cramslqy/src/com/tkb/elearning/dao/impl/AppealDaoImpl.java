package com.tkb.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.tkb.elearning.dao.AppealDao;
import com.tkb.elearning.model.Appeal;

import sso.ojdbc.dao.impl.PagingDaoImpl;


public class AppealDaoImpl extends PagingDaoImpl implements AppealDao{
	
	@SuppressWarnings("unchecked")
	public List<Appeal> getList(int pageCount, int pageStart, Appeal appeal){
		
		List<Object> args = new ArrayList<Object>();
	    String sql = "SELECT * FROM appeal";
	    if(appeal.getTransactor() != null && !"".equals(appeal.getTransactor())){
	    	sql +="WHERE TRANSACTOR LIKE";
	    	args.add("%" + appeal.getTransactor() + "%");
	    }
	    sql += " ORDER BY ID LIMIT ?, ?";
	    
	    args.add(pageStart);//※注意pageStart和pageCount順序
	    args.add(pageCount);
	    
	    return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
	}
	
	public Integer getCount(Appeal appeal){
		
		List<Object> args = new ArrayList<Object>();
		String sql = "SELECT COUNT(*) FROM appeal";
		if(appeal.getTransactor() !=null && !"".equals(appeal.getTransactor())){
			sql += "WHERE TRANSACTOR LIKE";
			args.add("%" + appeal.getTransactor() + "%");
		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
	}
	
	public Appeal getData(Appeal appeal){
		
		String sql = "SELECT * FROM appeal WHERE ID = ?";
		return(Appeal)getJdbcTemplate().query(sql, new Object[]{appeal.getId()}, getRowMapper()).get(0);
	}
	
	public void add(Appeal appeal){
		
		String sql = "INSERT INTO appeal(TRANSACTOR, HANDLE_DATE, HANDLE_CONTENT)"
				+ "VALUE(?, NOW(), ?)";
		getJdbcTemplate().update(sql, new Object[]{appeal.getTransactor(), appeal.getHandle_date(), appeal.getHandle_content()});
		
	}
	
	public void update(Appeal appeal){
		
		String sql = "UPDATE appeal SET TRANSACTOR = ?, HANDLE_DATE, HANDLE_CONTENT = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[]{appeal.getTransactor(), appeal.getHandle_date(), appeal.getHandle_content()});
	}
	
	public void delete(Integer id){
		String sql = "DELETE FROM appeal WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] {id});
	}
	
//	public Integer checkUsingPeriod(Active active) {
//		String sql = "SELECT count(*) FROM active WHERE class_no = ? ";
//		return getJdbcTemplate().queryForInt(sql, new Object[]{ active.getClass_no() });
//	}

}
