package com.tkb.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.tkb.elearning.dao.AllAssociationDao;
import com.tkb.elearning.model.AllAssociation;

import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 各區協會資訊Dao實作類
 * @author Admin
 * @version 創建時間：2016-04-22
 */
public class AllAssociationDaoImpl extends PagingDaoImpl implements AllAssociationDao {
	
	
	@SuppressWarnings("unchecked")
	public List<AllAssociation> getList(int pageCount, int pageStart, AllAssociation allAssociation) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT * FROM all_Association WHERE 1=1";
		
		if(allAssociation.getTelephone() != null && !"".equals(allAssociation.getTelephone())) {
			sql += " AND ZONE LIKE ? ";
			args.add("%" + allAssociation.getTelephone() + "%");
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
	
	public Integer getCount(AllAssociation allAssociation) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM all_association WHERE 1=1 ";
		
		if(allAssociation.getTelephone() != null && !"".equals(allAssociation.getTelephone())) {
			sql += " AND ZONE LIKE ? ";
			args.add("%" + allAssociation.getTelephone() + "%");
		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public AllAssociation getData(AllAssociation allAssociation) {
		
		String sql = " SELECT * FROM all_association WHERE ID = ? ";
		return (AllAssociation)getJdbcTemplate().query(sql, new Object[]{ allAssociation.getId() }, getRowMapper()).get(0);
		
	}
		
	public void add(AllAssociation allAssociation) {
		
		String sql = "INSERT INTO all_association(ZONE_NAME, ASSOCIATION_NAME, ADDRESS, MAP_URL, TELEPHONE, FAX, EMAIL, "
				+ "WEBSITE, REMARK, CREATE_DATE)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
				 		
		getJdbcTemplate().update(sql, new Object[] { allAssociation.getTelephone(), allAssociation.getAssociation_name(), 
				allAssociation.getAddress(), allAssociation.getMap_url(), allAssociation.getTelephone(), allAssociation.getFax(),
				allAssociation.getEmail(), allAssociation.getWebsite(), allAssociation.getRemark()});
		
	}
	
	public void update(AllAssociation allAssociation) {
		
		String sql = " UPDATE all_association SET ZONE_NAME = ?, ASSOCIATION_NAME = ?,  ADDRESS = ?, TELEPHONE = ?, "
				+ "FAX = ?, EMAIL = ?, WEBSITE = ?, REMARK = ? WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { allAssociation.getZone_name(), 
				allAssociation.getAssociation_name(), allAssociation.getAddress(),
				 allAssociation.getTelephone(), allAssociation.getFax(), 
				allAssociation.getEmail(), allAssociation.getWebsite(), 
				allAssociation.getRemark(), allAssociation.getId()});
		
	}
	
	public void delete(Integer id ) {
		
		String sql = " DELETE FROM all_association WHERE ID = ? ";
		getJdbcTemplate().update(sql, new Object[] { id });
	}
	
	public Integer checkUsingZone(AllAssociation allAssociation){
		String sql = "SELECT count(*) FROM all_association WHERE zone_name = ?";
		return getJdbcTemplate().queryForInt(sql, new Object[]{allAssociation.getZone_name()});
	}
}
