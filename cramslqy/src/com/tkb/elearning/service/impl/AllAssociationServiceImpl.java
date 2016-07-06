package com.tkb.elearning.service.impl;

import java.util.List;


import com.tkb.elearning.dao.AllAssociationDao;
import com.tkb.elearning.model.AllAssociation;
import com.tkb.elearning.service.AllAssociationService;

public class AllAssociationServiceImpl implements AllAssociationService{
	
	private AllAssociationDao allAssociationDao;
	
	/**
	 * 取得各區協會資訊清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param allAssociation
	 * @return List<AllAssociation>
	 * **/
	public List<AllAssociation> getList(int pageCount, int pageStart, AllAssociation allAssociation){
		
		return allAssociationDao.getList(pageCount, pageStart, allAssociation);
	}
	
	/**
	 * 取得各區協會資訊筆數
	 * @param allAssociation
	 * @return AllAssociation
	 * **/
	public Integer getCount(AllAssociation allAssociation){
		
		return allAssociationDao.getCount(allAssociation);
	}
	
	/**
	 * 取得單筆各區協會資訊
	 * @param allAssociation
	 * @return AllAssociation
	 * */
	public AllAssociation getData(AllAssociation allAssociation){
		return allAssociationDao.getData(allAssociation);
	}
	
	/**
	 * 新增各區協會資訊
	 * @param allAssociation
	 * */
	public void add(AllAssociation allAssociation){
		allAssociationDao.add(allAssociation);
	}
	
	/**
	 * 修改各區協會資訊
	 * @param allAssociation
	 * */
	public void update(AllAssociation allAssociation){
	    allAssociationDao.update(allAssociation);
	}
	
	/**
	 * 刪除各區協會資訊
	 * @param id
	 * */
	public void delete(Integer id){
		allAssociationDao.delete(id);
	}

	public void setAllAssociationDao(AllAssociationDao allAssociationDao){
		this.allAssociationDao = allAssociationDao;
	}
	
	public Integer checkUsingZone(AllAssociation allAssociation){
		return allAssociationDao.checkUsingZone(allAssociation);
	}
	
}
