package com.tkb.elearning.dao.impl;

import java.util.ArrayList;

import java.util.List;

import com.tkb.elearning.dao.BannerDao;
import com.tkb.elearning.model.Banner;

import sso.ojdbc.dao.impl.PagingDaoImpl;

public class BannerDaoImpl extends PagingDaoImpl implements BannerDao{

	@SuppressWarnings("unchecked")
	public List<Banner> getList(int pageCount, int pageStart, Banner banner) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT * FROM banner ";
		
		if(banner.getImg_name() != null && !"".equals(banner.getImg_name())) {
			sql += " WHERE IMG_NAME LIKE ? ";
			args.add("%" + banner.getImg_name() + "%");
		}
//		
		sql += " ORDER BY SORT ASC LIMIT ?, ? ";
//		
////		sql = " SELECT * FROM "
////			+ " (SELECT a.*, ROWNUM rn FROM( " + sql +")a "
////			+ " WHERE ROWNUM <= ?) WHERE rn >= ? ";
//		
		args.add(pageStart);
		args.add(pageCount+1);
		
		return getJdbcTemplate().query(sql, args.toArray(), getRowMapper());
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Banner>getFrontList(){
		String sql = "SELECT * FROM banner WHERE 1=1"
				+"ORDER BY CREATE_DATE DESC, CREATE_DATE LIMIT 5,0";
		return getJdbcTemplate().query(sql, getRowMapper());
	}
	
	public Integer getCount(Banner banner) {
		
		List<Object> args = new ArrayList<Object>();
		
		String sql = " SELECT COUNT(*) FROM banner ";
		
		if(banner.getImg_name() != null && !"".equals(banner.getImg_name())) {
			sql += " WHERE IMG_NAME LIKE ? ";
			args.add("%" + banner.getImg_name() + "%");
		}
		
		return getJdbcTemplate().queryForInt(sql, args.toArray());
		
	}
	
	public Banner getData(Banner banner) {
		
		String sql = " SELECT * FROM banner WHERE ID = ? ";
		return (Banner)getJdbcTemplate().query(sql, new Object[]{banner.getId()}, getRowMapper()).get(0);
		
	}
		
	public void add(Banner banner) {
		
		String sql = "INSERT INTO banner( TYPE, TITLE, IMAGE, IMG_NAME, URL, SORT, INDEX_SHOW, START_DATE, END_DATE,"
				+ " CREATE_DATE, UPDATE_DATE)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW()) ";
		
		getJdbcTemplate().update(sql, new Object[] { banner.getType(), banner.getTitle(),banner.getImage(), banner.getImg_name(), 
				banner.getUrl(), banner.getSort(), banner.getIndex_show(), banner.getStart_date(), banner.getEnd_date() });
		
	}
	
	public void update(Banner banner) {
		
		String sql = " UPDATE banner SET TYPE = ?, TITLE = ?, IMAGE = ?, IMG_NAME = ?, URL = ?, SORT = ?, INDEX_SHOW = ?,"
				+ "START_DATE = ?, END_DATE = ?, UPDATE_DATE = NOW() WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] {banner.getType(), banner.getTitle(), banner.getImage(), 
				banner.getImg_name(), banner.getUrl(), banner.getSort(), banner.getIndex_show(), banner.getStart_date(), 
				banner.getEnd_date(), banner.getId() });
		
	}
	
	private void sort(Banner banner) {
		
		if(banner.getSort() == 0) {
			banner.setSort(1);
		}
		
		String sql = "SELECT COUNT(*) FROM banner WHERE SORT = ?";
		int count = getJdbcTemplate().queryForInt(sql, new Object[]{banner.getSort()});
		//若原有排序號碼已存在
		if (count > 0) {
			sql = "SELECT SORT FROM banner WHERE ID = ?";
			Banner oldZone = (Banner)getJdbcTemplate().query(sql, new Object[]{ banner.getId() }
			, getRowMapper()).get(0);
			if (banner.getSort() < oldZone.getSort()) {
				//將原有排序號碼與新排序號碼中間之號碼全部+1
				sql = "UPDATE banner SET SORT = SORT + 1 WHERE ? >= SORT AND SORT >= ? ";
				getJdbcTemplate().update(sql, new Object[]{ oldZone.getSort(), banner.getSort() });
			} else if (banner.getSort() > oldZone.getSort()){
				//將原有排序號碼與新排序號碼中間之號碼全部-1
				sql = "UPDATE banner SET SORT = SORT - 1 WHERE ? >= SORT AND SORT >= ? ";
				getJdbcTemplate().update(sql, new Object[]{ banner.getSort(), oldZone.getSort() });
			}			
		}
		sql = "UPDATE banner SET SORT = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[]{banner.getSort(), banner.getId()});
		
	}	
	
	public void updateSort(Banner banner) {
		
		sort(banner);
		
	}	
	
	public void resetSort(){
		String sql = "SELECT COUNT(*) FROM banner";
		int count = getJdbcTemplate().queryForInt(sql);
		
		sql = "SELECT SORT FROM banner ORDER BY SORT ASC";
			
		for(int i=0; i<count; i++){
			Banner sortBanner = (Banner)getJdbcTemplate().query(sql, getRowMapper()).get(i);
			String sql2 = "UPDATE zone SET SORT = ? WHERE SORT = ?";
			getJdbcTemplate().update(sql2, new Object[]{i+1, sortBanner.getSort()});
		}
	}
		
	public void delete(Integer id) {
		
		String sql = " DELETE FROM banner WHERE ID = ? ";
		
		getJdbcTemplate().update(sql, new Object[] { id });
		
	}
	
}
