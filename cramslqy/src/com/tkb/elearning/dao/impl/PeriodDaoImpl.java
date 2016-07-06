package com.tkb.elearning.dao.impl;

import java.util.ArrayList;


import java.util.List;

import com.tkb.elearning.dao.PeriodDao;
import com.tkb.elearning.model.Period;
import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 屆別管理Dao實作類
 * @author Admin
 * @version 創建時間：2016-04-18
 */
@SuppressWarnings("unchecked")
public class PeriodDaoImpl extends PagingDaoImpl implements PeriodDao {
	
	
	public List<Period> getList(int pageCount, int pageStart, Period period) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT * FROM period ";
		
		if(period.getPeriod_name() != null && !"".equals(period.getPeriod_name())) {
			sql += " WHERE PERIOD_NAME LIKE ? ";
			args.add("%" + period.getPeriod_name() + "%");
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
	
	public Integer getCount(Period period) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM period ";
		
		if(period.getPeriod_name() != null && !"".equals(period.getPeriod_name())) {
			sql += " WHERE PERIOD_NAME LIKE ? ";
			args.add("%" + period.getPeriod_name() + "%");
		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public Period getData(Period period) {
		
		String sql = " SELECT * FROM period WHERE ID = ? ";
		return (Period)getJdbcTemplate().query(sql, new Object[]{ period.getId() }, getRowMapper()).get(0);
		
	}
		
	public void add(Period period) {
		
		String sql = "INSERT INTO period( PERIOD_NAME, CLASS_NO, PERIOD_START, PERIOD_END, STATUS, CREATE_DATE)VALUES(?, ?, ?, ?, ?, NOW())";
				 		
		getJdbcTemplate().update(sql, new Object[] { period.getPeriod_name(), period.getClass_no(), period.getPeriod_start(), 
				period.getPeriod_end(), period.getStatus()});
		
	}
	
	public void update(Period period) {
		
		String sql = " UPDATE period SET PERIOD_NAME = ?, CLASS_NO = ?,  PERIOD_START = ?, PERIOD_END = ?, STATUS = ? WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { period.getPeriod_name(), period.getClass_no(),period.getPeriod_start(), 
				period.getPeriod_end(), period.getStatus(), period.getId() });
		
	}
	
	public void delete(Integer id ) {
		
		String sql = " DELETE FROM period WHERE ID = ? AND STATUS='未使用'";
		getJdbcTemplate().update(sql, new Object[] { id });
	}
	
	public List<Period> getPeriodList() {
		String sql = "SELECT * FROM period WHERE status='使用' ORDER BY id";
				//   + " ORDER BY updatedate DESC";
		return getJdbcTemplate().query(sql, getRowMapper());
	}
	
	/**
	 * 檢查屆別(數字)
	 */
	public Integer checkClassNo(Period period){
		String sql = "SELECT * FROM period WHERE class_no = ?";
		List<Period> list = getJdbcTemplate().query(sql, new Object[]{period.getClass_no()}, getRowMapper());
		return list.size() == 0 ? null : list.get(0).getClass_no();
	}
}