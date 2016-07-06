package com.tkb.elearning.dao.impl;

import java.util.ArrayList;


import java.util.List;

import com.tkb.elearning.dao.CramMemberDao;
import com.tkb.elearning.model.CramMember;
import sso.ojdbc.dao.impl.PagingDaoImpl;

public class CramMemberDaoImpl extends PagingDaoImpl implements CramMemberDao{
	
		@SuppressWarnings("unchecked")
		public List<CramMember> getList(int pageCount, int pageStart, CramMember cramMember) {
				
				List<Object> args = new ArrayList<Object>();
				
				String sql = " SELECT * FROM cram_member ";
				
				if(cramMember.getCram_school() != null && !"".equals(cramMember.getCram_school())) {
					sql += " WHERE NAME LIKE ? ";
					args.add("%" + cramMember.getCram_school() + "%");
				}
				
				sql += " ORDER BY ID LIMIT ?, ? ";
				
		//		sql = " SELECT * FROM "
		//			+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
		//			+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
				
				args.add(pageStart);
				args.add(pageCount);
				
				return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
				
			}	
		
		public Integer getCount(CramMember cramMember){
			
			List<Object> args = new ArrayList<Object>();
			String sql = "Select COUNT(*) From cram_member";
			
			if(cramMember.getCram_school()!= null && "".equals(cramMember.getCram_school()) ){
				sql += "WHERE NAME LIKE ?";
				args.add("%" + cramMember.getCram_school() + "%");
				
			}
			return getJdbcTemplate().queryForInt(sql,args.toArray());
		}
		
		public CramMember getData(CramMember cramMember){
			
			String sql = "Select * From cram_member WHERE ID = ? ";
			
			return (CramMember)getJdbcTemplate().query(sql ,new Object[] {cramMember.getId()} ,
					getRowMapper()).get(0);
		}
		
		public void add(CramMember cramMember){
			
			String sql = "INSERT INTO cram_member(CRAM_SCHOOL, TELEPHONE, CELLPHONE, EMAIL, ADDRESS, " 
						+ " CREATE_DATE, UPDATE_DATE)VALUE( ?, ?, ?, ?, ?, NOW(), NOW())";
			
			getJdbcTemplate().update(sql,new Object[]{cramMember.getCram_school(), cramMember.getTelephone(),
					cramMember.getCellphone(), cramMember.getEmail() ,cramMember.getAddress()});
		}
		
		public void update(CramMember cramMember){
			
			String sql = "UPDATE cram_member SET CRAM_SCHOOL = ?, TELEPHONE = ?, "
							+ "CELLPHONE = ?, EMAIL = ? , ADDRESS = ?, UPDATE_DATE = NOW() WHERE ID = ?";
			
			getJdbcTemplate().update(sql, new Object[] {cramMember.getCram_school(), cramMember.getTelephone(), 
					cramMember.getCellphone(), cramMember.getEmail(), cramMember.getAddress(), cramMember.getId()});
		}
		
		public void delete(Integer id){
			
			String sql = "DELETE FROM cram_member WHERE ID = ?";
			
			getJdbcTemplate().update(sql, new Object[] { id });
			
		}
}
