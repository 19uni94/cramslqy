package com.tkb.elearning.dao.impl;

import java.util.ArrayList;

import java.util.List;

import com.tkb.elearning.dao.AssociationMemberDao;
import com.tkb.elearning.model.AssociationMember;
import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 協會成員Dao實作類
 * @author Admin
 * @version 創建時間：2016-03-14
 */
@SuppressWarnings("unchecked")
public class AssociationMemberDaoImpl extends PagingDaoImpl implements AssociationMemberDao {
	
	public List<AssociationMember> getList(int pageCount, int pageStart, AssociationMember associationMember) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT * FROM association_member ";
		
		if(associationMember.getName() != null && !"".equals(associationMember.getName())) {
			sql += " WHERE NAME LIKE ? ";
			args.add("%" + associationMember.getName() + "%");
		}
		
		sql += " ORDER BY ID LIMIT ?, ? ";
		
//		sql = " SELECT * FROM "
//			+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
//			+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
		
		args.add(pageStart);
		args.add(pageCount);
		
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		
	}
	
	public Integer getCount(AssociationMember associationMember) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM association_member ";
		
		if(associationMember.getName() != null && !"".equals(associationMember.getName())) {
			sql += " WHERE NAME LIKE ? ";
			args.add("%" + associationMember.getName() + "%");
		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public AssociationMember getData(AssociationMember associationMember) {
		
		String sql = " SELECT * FROM association_member WHERE ID = ? ";
		return (AssociationMember)getJdbcTemplate().query(sql, new Object[]{ associationMember.getId() }, getRowMapper()).get(0);
		
	}
	
	public void add(AssociationMember associationMember) {
		
		String sql = " INSERT INTO association_member(NAME, IMAGE, BRIEF_INTRODUCTION, CONTENT, CREATE_BY, UPDATE_BY, "
				   + " CREATE_DATE, UPDATE_DATE)VALUES(?, ?, ?, ?, ?, ?, NOW(), NOW()) ";
		
		getJdbcTemplate().update(sql, new Object[] { associationMember.getName(),associationMember.getImage(), 
							associationMember.getBrief_introduction(), associationMember.getContent(),  
							associationMember.getCreate_by(), associationMember.getUpdate_by() });
		
	}
	
	public void update(AssociationMember associationMember) {
		
		String sql = " UPDATE association_member SET NAME = ?,  IMAGE = ?, BRIEF_INTRODUCTION = ?, CONTENT = ?,"
				   + " UPDATE_BY = ?, UPDATE_DATE = NOW() WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { associationMember.getName(), associationMember.getImage(),
							associationMember.getBrief_introduction(), associationMember.getContent(), 
							associationMember.getUpdate_by(), associationMember.getId() });
		
	}
	
	public void delete(Integer id) {
		
		String sql = " DELETE FROM association_member WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { id });
		
	}
	
}
