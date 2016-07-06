package com.tkb.elearning.dao;

import java.util.List;

import com.tkb.elearning.model.JoinNotice;

/**
 * 加入會員須知Dao介面接口
 * @author Admin
 * @version 創建時間：2016-04-25
 */
public interface JoinNoticeDao {
		
		/**
		 * 加入會員須知清單(分頁)
		 * @param pageCount
		 * @param pageStart
		 * @param joinNotice
		 * @return List<JoinNotice>
		 * **/
		public List<JoinNotice> getList(int pageCount, int pageStart, JoinNotice joinNotice);
		
		/**
		 * 取得加入會員須知筆數
		 * @param joinNotice
		 * @return JoinNotice
		 * **/
		public Integer getCount(JoinNotice joinNotice);
		
		/**
		 * 取得單筆加入會員須知
		 * @param joinNotice
		 * @return JoinNotice
		 * */
		public JoinNotice getData(JoinNotice joinNotice);
		
		/**
		 * 新增加入會員須知
		 * @param joinNotice
		 * */
		public void add(JoinNotice joinNotice);
		
		/**
		 * 修改加入會員須知
		 * @param joinNotice
		 * */
		public void update(JoinNotice joinNotice);
		
		/**
		 * 刪除加入會員須知
		 * @param id
		 * */
		public void delete(Integer id);

}
