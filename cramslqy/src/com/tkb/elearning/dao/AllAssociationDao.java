package com.tkb.elearning.dao;

import java.util.List;

import com.tkb.elearning.model.AllAssociation;

/**
 * 各區協會資訊Dao介面接口
 * @author Admin
 * @version 創建時間：2016-04-22
 */
public interface AllAssociationDao {
		
		/**
		 * 取得各區協會資訊清單(分頁)
		 * @param pageCount
		 * @param pageStart
		 * @param allAssociation
		 * @return List<AllAssociation>
		 * **/
		public List<AllAssociation> getList(int pageCount, int pageStart, AllAssociation allAssociation);
		
		/**
		 * 取得各區協會資訊筆數
		 * @param allAssociation
		 * @return AllAssociation
		 * **/
		public Integer getCount(AllAssociation allAssociation);
		
		/**
		 * 取得單筆各區協會資訊
		 * @param allAssociation
		 * @return AllAssociation
		 * */
		public AllAssociation getData(AllAssociation allAssociation);
		
		/**
		 * 新增各區協會資訊
		 * @param allAssociation
		 * */
		public void add(AllAssociation allAssociation);
		
		/**
		 * 修改各區協會資訊
		 * @param allAssociation
		 * */
		public void update(AllAssociation allAssociation);
		
		/**
		 * 刪除各區協會資訊
		 * @param id
		 * */
		public void delete(Integer id);
		
		/**
		 * 檢查地區名稱使用筆數
		 * @param allAssociation
		 * @return Integer
		 */
		public Integer checkUsingZone(AllAssociation allAssociation);

}
