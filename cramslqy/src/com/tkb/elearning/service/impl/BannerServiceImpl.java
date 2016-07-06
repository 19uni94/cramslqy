package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.BannerDao;
import com.tkb.elearning.model.Banner;
import com.tkb.elearning.model.Zone;
import com.tkb.elearning.service.BannerService;


/**
 * BannerService實作類
 * @author Admin
 * @version 創建時間：2016-04-15
 */
public class BannerServiceImpl implements BannerService{

	private BannerDao bannerDao;
	
	public List<Banner> getList(int pageCount, int pageStart, Banner banner) {
		return bannerDao.getList(pageCount, pageStart, banner);
	}
	
	public List<Banner>getFrontList(){
		return bannerDao.getFrontList();
	}
	
	public Integer getCount(Banner banner) {
		return bannerDao.getCount(banner);
	}
	
	public Banner getData(Banner banner) {
		return bannerDao.getData(banner);
	}

	public void add(Banner banner) {
		bannerDao.add(banner);
	}
	
	public void update(Banner banner) {
		bannerDao.update(banner);
	}
	
	public void delete(Integer id) {
		bannerDao.delete(id);
	}
	
	public void updateSort(Banner banner){
		bannerDao.updateSort(banner);
	}
	
	public void resetSort(){
		bannerDao.resetSort();
	}

	public void setBannerDao(BannerDao bannerDao) {
		this.bannerDao = bannerDao;
	}
}
