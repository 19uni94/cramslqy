package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.AssociationMemberDao;
import com.tkb.elearning.model.AssociationMember;
import com.tkb.elearning.service.AssociationMemberService;


/**
 * 協會成員Service實作類
 * @author Admin
 * @version 創建時間：2016-03-15
 */
public class AssociationMemberServiceImpl implements AssociationMemberService {

	private AssociationMemberDao associationMemberDao;
	
	public List<AssociationMember> getList(int pageCount, int pageStart, AssociationMember associationMember) {
		return associationMemberDao.getList(pageCount, pageStart, associationMember);
	}
	
	public Integer getCount(AssociationMember associationMember) {
		return associationMemberDao.getCount(associationMember);
	}
	
	public AssociationMember getData(AssociationMember associationMember) {
		return associationMemberDao.getData(associationMember);
	}
	
	public void add(AssociationMember associationMember) {
		associationMemberDao.add(associationMember);
	}
	
	public void update(AssociationMember associationMember) {
		associationMemberDao.update(associationMember);
	}
	
	public void delete(Integer id) {
		associationMemberDao.delete(id);
	}

	public void setAssociationMemberDao(AssociationMemberDao associationMemberDao) {
		this.associationMemberDao = associationMemberDao;
	}
}
