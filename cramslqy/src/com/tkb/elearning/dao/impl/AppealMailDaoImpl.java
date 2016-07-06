package com.tkb.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.tkb.elearning.dao.AppealMailDao;
import com.tkb.elearning.model.AppealMail;

import sso.ojdbc.dao.impl.PagingDaoImpl;

public class AppealMailDaoImpl extends PagingDaoImpl implements AppealMailDao{

		
		@SuppressWarnings("unchecked")
		public  List<AppealMail> getList(int pageCount, int pageStart, AppealMail appealMail){
			List<Object> args = new ArrayList<Object>();
			String sql = "SELECT * FROM appeal_mail WHERE 1=1 ";
					if(appealMail.getPd_name()!=null && !"".equals(appealMail.getPd_name())){
						sql += "AND PD_NAME LIKE ?";
						args.add("%" + appealMail.getPd_name() + "%");
					}
					sql += "ORDER BY ID DESC";
					return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		}
		

		public Integer getCount(AppealMail appealMail){
			
			List<Object> args = new ArrayList<Object>();
			String sql = "SELECT COUNT(*) FROM appeal_mail WHERE 1=1 ";
					if(appealMail.getPd_name()!=null && !"".equals(appealMail.getPd_name())){
						sql += "AND PD_NAME LIKE ?";
						args.add("%" + appealMail.getPd_name() + "%");
					}
					return getJdbcTemplate().queryForInt(sql, args.toArray());
		}
		

		public AppealMail getData(AppealMail appealMail){
			
		   String sql = "SELECT * FROM appeal_mail WHERE ID =?";
		   return(AppealMail)getJdbcTemplate().query(sql, new Object[]{appealMail.getId()}, getRowMapper()).get(0);
		}
			

		public void add(AppealMail appealMail){
			String sql = "INSERT INTO appeal_mail(PD_NAME, MAIL_ADDRESS1, MAIL_ADDRESS2, CREATE_DATE)VALUE(?, ?, ?, NOW())";
			getJdbcTemplate().update(sql, new Object[] {appealMail.getPd_name(), appealMail.getMail_address1(), appealMail.getMail_address2()});
		}
		

		public void update(AppealMail appealMail){
			String sql = "UPDATE appeal_mail SET PD_NAME = ?, MAIL_ADDRESS1 = ?, MAIL_ADDRESS2 = ? WHERE ID =?";
			getJdbcTemplate().update(sql, new Object[] { appealMail.getPd_name(), appealMail.getMail_address1(), appealMail.getMail_address2(), appealMail.getId()});
		}
		
		public void delete(Integer id){
			String sql = "DELETE FROM appeal_mail WHERE ID =?";
			
			getJdbcTemplate().update(sql, new Object[] {id});
		}
		
}
