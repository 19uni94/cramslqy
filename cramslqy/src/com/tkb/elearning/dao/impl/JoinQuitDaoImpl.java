package com.tkb.elearning.dao.impl;

import java.util.ArrayList;


import java.util.List;

import com.tkb.elearning.dao.JoinQuitDao;
import com.tkb.elearning.model.ConsumerZone;


import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 入會&退會公告Dao實作類
 * @author Admin
 * @version 創建時間：2016-03-21
 */
public class JoinQuitDaoImpl extends PagingDaoImpl implements JoinQuitDao{

	@SuppressWarnings("unchecked")
	public List<ConsumerZone>getJoinQuitList(int pageCount, int pageStart, ConsumerZone consumerZone){
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = "SELECT * FROM consumer_zone WHERE 1=1 AND DISPLAY ='y'";
		
		if(consumerZone.getMember_no()!= null && "".equals(consumerZone.getCramschool_name())){
			sql += " AND MEMBER_NO LIKE ? ";
			args.add("%" + consumerZone.getMember_no() + "%");
		}
		if(consumerZone.getCramschool_name()!= null && "".equals(consumerZone.getCramschool_name())){
			sql += " AND CRAMSCHOOL_NAME LIKE ? ";
			args.add("%" + consumerZone.getCramschool_name() + "%");
		}
		sql += " ORDER BY ID LIMIT ?,?";
		
		args.add(pageStart);
		args.add(pageCount);
		
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
	}
	
	public Integer getCount(ConsumerZone consumerZone){
		
		List<Object> args = new ArrayList<Object>();
		String sql = "SELECT COUNT(*) FROM consumer_zone WHERE 1=1 AND DISPLAY ='y'";
		
		if(consumerZone.getCramschool_name()!=null && "".equals(consumerZone.getCramschool_name())){
			sql += "AND CRAMSCHOOL_NAME LIKE";
			args.add("%" + consumerZone.getCramschool_name() + "%");
		}
		return getJdbcTemplate().queryForInt(sql, args.toArray());
	}
	
	public ConsumerZone getData(ConsumerZone consumerZone){
		String sql = "SELECT * from consumer_zone WHERE ID = ?";
		return (ConsumerZone)getJdbcTemplate().query(sql, new Object[] {consumerZone.getId()}, getRowMapper()).get(0);
	}
}
