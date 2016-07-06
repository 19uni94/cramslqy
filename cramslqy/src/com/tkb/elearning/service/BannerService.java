package com.tkb.elearning.service;

import java.util.List;

import com.tkb.elearning.model.Banner;


/**
 * 最新消息Service介面接口
 * @author Admin
 * @version 創建時間：2016-04-15
 */
public interface BannerService {

	/**
	 * 取得Banner資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param banner
	 * @return List<Banner>
	 */
	public List<Banner> getList(int pageCount, int pageStart, Banner banner);
	
	/**
	 * 取得Banner清單_前台
	 * @return List<Banner>
	 * */
	public List<Banner>getFrontList();
	
	/**
	 * 取得Banner總筆數
	 * @param banner
	 * @return Integer
	 */
	public Integer getCount(Banner banner);
	
	/**
	 * 取得單筆Banner
	 * @param banner
	 * @return Banner
	 */
	public Banner getData(Banner banner);
	
	/**
	 * 新增Banner
	 * @param banner
	 */
	public void add(Banner banner);
	
	/**
	 * 修改Banner
	 * @param banner
	 */
	public void update(Banner banner);
		
	/**
	 * 刪除Banner
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 修改地區資料排序
	 * @param banner
	 */
	public void updateSort(Banner banner);
	
	/**
	 * 重新排序廣告
	 * @param banner
	 * */
	public void resetSort();
}
