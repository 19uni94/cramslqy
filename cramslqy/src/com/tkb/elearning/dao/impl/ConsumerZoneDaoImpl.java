package com.tkb.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.tkb.elearning.dao.ConsumerZoneDao;
import com.tkb.elearning.model.ConsumerZone;
import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 消費小幫手Dao實作類
 * @author Admin
 * @version 創建時間：2016-03-21
 */
@SuppressWarnings("unchecked")
public class ConsumerZoneDaoImpl extends PagingDaoImpl implements ConsumerZoneDao{
	
	public List<ConsumerZone>getList(int pageCount, int pageStart, ConsumerZone consumerZone){
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = "SELECT * FROM consumer_zone WHERE 1=1 ";
		
		if(consumerZone.getMember_no()!= null && "".equals(consumerZone.getMember_no())){
			sql += " AND MEMBER_NO LIKE ? ";
			args.add("%" + consumerZone.getMember_no() + "%");
		}
		
		sql += "ORDER BY ID DESC LIMIT ?,?";
		
		args.add(pageStart);
		args.add(pageCount);
		
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
	}
	
	public Integer getCount(ConsumerZone consumerZone){
		
		List<Object> args = new ArrayList<Object>();
		String sql = "SELECT COUNT(*) FROM consumer_zone WHERE 1=1 ";
		
		if(consumerZone.getMember_no()!= null && "".equals(consumerZone.getMember_no())){
			sql += " AND MEMBER_NO LIKE ? ";
			args.add("%" + consumerZone.getMember_no()+ "%");
		}		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
	}
	
	public ConsumerZone getData(ConsumerZone consumerZone){
		String sql = "SELECT * From consumer_zone WHERE ID = ?";
		return (ConsumerZone)getJdbcTemplate().query(sql, new Object[] {consumerZone.getId()}, getRowMapper()).get(0);
	}
	
	public void add(ConsumerZone consumerZone){
		
		String sql = "INSERT INTO consumer_zone(MEMBER_NO, CRAMSCHOOL_NAME, EIN, JOIN_QUIT_SHOW, JOIN_DATE, QUIT_DATE, "
				+ " FOUNDER, FOUNDER_NO, WEBSITE, ADDRESS, TELEPHONE, FAX, FOUND_DATE, EMAIL, DISPLAY, "
				+ "CREATE_DATE, UPDATE_DATE)VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW()) ";
		getJdbcTemplate().update(sql, new Object[] {consumerZone.getMember_no(), consumerZone.getCramschool_name(), 
				consumerZone.getEin(), consumerZone.getJoin_date(), consumerZone.getJoin_quit_show(),consumerZone.getQuit_date(), 
			    consumerZone.getFounder(),consumerZone.getFounder_no(), consumerZone.getWebsite(),consumerZone.getFax(),
				consumerZone.getAddress(), consumerZone.getTelephone(), consumerZone.getFound_date(),
				consumerZone.getEmail(), consumerZone.getDisplay()});
	}
	
	public void update(ConsumerZone consumerZone){
		
		String sql = "UPDATE consumer_zone SET MEMBER_NO = ?, CRAMSCHOOL_NAME = ?, EIN = ?,  JOIN_DATE = ?, JOIN_QUIT_SHOW = ?,"
				+ "QUIT_DATE = ?, FOUNDER = ?, FOUNDER_NO = ?, WEBSITE = ?, ADDRESS = ?,TELEPHONE = ?, FAX = ?, "
				+ "FOUND_DATE = ?, EMAIL = ?, DISPLAY = ?, UPDATE_DATE = NOW() WHERE ID = ?";
		
		getJdbcTemplate().update(sql, new Object[] { consumerZone.getMember_no(), consumerZone.getCramschool_name(), 
				consumerZone.getEin(), consumerZone.getJoin_date(), consumerZone.getJoin_quit_show(),consumerZone.getQuit_date(), 
				consumerZone.getFounder(),consumerZone.getFounder_no(), consumerZone.getWebsite(),
				consumerZone.getAddress(), consumerZone.getTelephone(), consumerZone.getFax(),
				consumerZone.getFound_date(), consumerZone.getEmail(), consumerZone.getDisplay(), consumerZone.getId()});
	} 	
	
	public void delete(Integer id){
		
		String sql = "Delete FROM consumer_zone WHERE ID = ?";
		
		getJdbcTemplate().update(sql, new Object[] {id});
	}
		
}
