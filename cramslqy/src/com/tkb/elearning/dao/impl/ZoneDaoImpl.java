package com.tkb.elearning.dao.impl;

import java.util.ArrayList;


import java.util.List;

import com.tkb.elearning.dao.ZoneDao;
import com.tkb.elearning.model.Zone;

import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 地區資料Dao實作類
 * @author Admin
 * @version 創建時間：2016-02-09
 */
@SuppressWarnings("unchecked")
public class ZoneDaoImpl extends PagingDaoImpl implements ZoneDao {
	
	public List<Zone> getList(int pageCount, int pageStart, Zone zone) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT * FROM zone WHERE 1=1";
		
		if(zone.getZone_name() != null && !"".equals(zone.getZone_name())) {
			sql += " AND ZONE_NAME LIKE ? ";
			args.add("%" + zone.getZone_name() + "%");
		}
		
		sql += " ORDER BY SORT LIMIT ?, ? ";
		
//		sql += "ORDER BY SORT";
		
//		sql = " SELECT * FROM "
//			+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
//			+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
		
		args.add(pageStart);
		args.add(pageCount);
		
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		
	}
	
	public Integer getCount(Zone zone) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM zone WHERE 1=1";
		
		if(zone.getZone_name() != null && !"".equals(zone.getZone_name())) {
			sql += " AND ZONE_NAME LIKE ? ";
			args.add("%" + zone.getZone_name() + "%");
		}
//		if(zone.getSort()!=0 && !"".equals(zone.getSort())){
//			sql +=" AND SORT = ?";
//			args.add(zone.getSort());
//		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public Zone getData(Zone zone) {
		
		String sql = " SELECT * FROM zone WHERE ID = ? ";
		return (Zone)getJdbcTemplate().query(sql, new Object[]{ zone.getId() }, getRowMapper()).get(0);
		
	}
	
	public void add(Zone zone) {
		//修改排序
		String sql = "UPDATE zone SET SORT = SORT + 1 WHERE SORT >= ?";
		getJdbcTemplate().update(sql, new Object[]{ zone.getSort() });
		
		//新增
		sql="INSERT INTO zone( ZONE_NAME, SORT, STATUS, CREATE_DATE )VALUES(?, ?, ?, NOW()) ";
		
		getJdbcTemplate().update(sql, new Object[] { zone.getZone_name(), zone.getSort(), zone.getStatus()});
		
	}
	
	public void update(Zone zone) {
		
		sort(zone);
		
		String sql = " UPDATE zone SET ZONE_NAME = ?, SORT = ?, STATUS = ? WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { zone.getZone_name(), zone.getSort(), zone.getStatus(), 
				zone.getId() });
		
	}

	private void sort(Zone zone) {
		
		if(zone.getSort() == 0) {
			zone.setSort(1);
		}
		
		String sql = "SELECT COUNT(*) FROM zone WHERE SORT = ?";
		int count = getJdbcTemplate().queryForInt(sql, new Object[]{zone.getSort()});
		//若原有排序號碼已存在
		if (count > 0) {
			sql = "SELECT SORT FROM zone WHERE ID = ?";
			Zone oldZone = (Zone)getJdbcTemplate().query(sql, new Object[]{ zone.getId() }
			, getRowMapper()).get(0);
			if (zone.getSort() < oldZone.getSort()) {
				//將原有排序號碼與新排序號碼中間之號碼全部+1
				sql = "UPDATE zone SET SORT = SORT + 1 WHERE ? >= SORT AND SORT >= ? ";
				getJdbcTemplate().update(sql, new Object[]{ oldZone.getSort(), zone.getSort() });
			} else if (zone.getSort() > oldZone.getSort()){
				//將原有排序號碼與新排序號碼中間之號碼全部-1
				sql = "UPDATE zone SET SORT = SORT - 1 WHERE ? >= SORT AND SORT >= ? ";
				getJdbcTemplate().update(sql, new Object[]{ zone.getSort(), oldZone.getSort() });
			}			
		}
		sql = "UPDATE zone SET SORT = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[]{zone.getSort(), zone.getId()});
		
	}	
	
	public void updateSort(Zone zone) {
		
		sort(zone);
		
	}	
	
	public void delete(Integer id) {
		
		String sql = " DELETE FROM zone WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { id });
		
	}
	
	public void resetSort(){
		String sql = "SELECT COUNT(*) FROM zone";
		int count = getJdbcTemplate().queryForInt(sql);
		
		sql = "SELECT SORT FROM zone ORDER BY SORT ASC";
			
		for(int i=0; i<count; i++){
			Zone sortZone = (Zone)getJdbcTemplate().query(sql, getRowMapper()).get(i);
			String sql2 = "UPDATE zone SET SORT = ? WHERE SORT = ?";
			getJdbcTemplate().update(sql2, new Object[]{i+1, sortZone.getSort()});
		}
	}
	public String checkZonename(Zone zone) {
		String sql = "SELECT * FROM zone WHERE zone_name = ?";
		List<Zone> list = getJdbcTemplate().query(sql, new Object[]{ zone.getZone_name() }, getRowMapper());
		return list.size() == 0 ? null : list.get(0).getZone_name();
	}
	
	public List<Zone> getZoneList(){
		String sql = "SELECT * FROM zone WHERE STATUS ='1' ORDER BY ID";
		return getJdbcTemplate().query(sql, getRowMapper());
	}
}
