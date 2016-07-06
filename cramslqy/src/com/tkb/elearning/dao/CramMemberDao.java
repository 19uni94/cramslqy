package com.tkb.elearning.dao;

import java.util.List;

import com.tkb.elearning.model.CramMember;

/**
 * 協會會員Dao介面接口
 * @author Admin
 * @version 創建時間：2016-03-16
 */
public interface CramMemberDao {

	/**
	 * 取得協會會員資料清單(分頁)
	 * @param cramMember
	 * @param pageCount
	 * @param pageStart
	 * @return List<CramMember>
	 */
	public List<CramMember> getList(int pageCount, int pageStart, CramMember cramMember);
	
	/**
	 * 取得協會會員總筆數
	 * @param cramMember
	 * @return Integer
	 **/
	public Integer getCount(CramMember cramMember);
	
	/**
	 * 取得協會會員資料
	 * @param cramMember
	 * @return CramMember
	 **/
	public CramMember getData(CramMember cramMember);
	
	/**
	 * 新增協會會員資料
	 * @param cramMember
	 * **/
	public void add(CramMember cramMember);
	
	/**
	 * 修改協會會員資料
	 * @param cramMember
	 * **/
	public void update(CramMember cramMember);
	
	/**
	 * 刪除協會會員資料
	 * @param id
	 * **/
	public void delete(Integer id);
}

