package com.tkb.elearning.service.impl;

import java.util.List;


import com.tkb.elearning.dao.CramMemberDao;
import com.tkb.elearning.model.CramMember;
import com.tkb.elearning.service.CramMemberService;

public class CramMemberServiceImpl implements CramMemberService{

	private CramMemberDao cramMemberDao;
	
	public List<CramMember> getList(int pageCount, int pageStart, CramMember cramMember) {
		return cramMemberDao.getList(pageCount, pageStart, cramMember);
	}

	public Integer getCount(CramMember cramMember){
		return cramMemberDao.getCount(cramMember);
	}
	
	public CramMember getData(CramMember cramMember){
		
	    return cramMemberDao.getData(cramMember);	
	}
		
	public void add(CramMember cramMember){
		cramMemberDao.add(cramMember);
	}
	
	public void update(CramMember cramMember){
		cramMemberDao.update(cramMember);
	}
	
	public void delete(Integer id){
		cramMemberDao.delete(id);
	}
	
	public void setCramMemberDao(CramMemberDao cramMemberDao) {
		this.cramMemberDao = cramMemberDao;
	}
}
	
