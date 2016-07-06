package com.tkb.elearning.service;

import java.util.List;

import com.tkb.elearning.model.AssociationMember;

/**
 * 協會成員Service介面接口
 * @author Admin
 * @version 創建時間：2016-03-15
 */
public interface AssociationMemberService {

	/**
	 * 取得協會成員資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param associationMember
	 * @return List<AssociationMember>
	 */
	public List<AssociationMember> getList(int pageCount, int pageStart, AssociationMember associationMember);
	
	/**
	 * 取得協會成員總筆數
	 * @param associationMember
	 * @return Integer
	 */
	public Integer getCount(AssociationMember associationMember);
	
	/**
	 * 取得單筆協會成員
	 * @param associationMember
	 * @return AssociationMember
	 */
	public AssociationMember getData(AssociationMember associationMember);
	
	/**
	 * 新增協會成員
	 * @param associationMember
	 */
	public void add(AssociationMember associationMember);
	
	/**
	 * 修改協會成員
	 * @param associationMember
	 */
	public void update(AssociationMember associationMember);
		
	/**
	 * 刪除協會成員
	 * @param id
	 */
	public void delete(Integer id);
	
}
