package com.tkb.elearning.service.impl;

import java.util.List;

import com.tkb.elearning.dao.ConsumerZoneDao;
import com.tkb.elearning.model.ConsumerZone;
import com.tkb.elearning.service.ConsumerZoneService;

public class ConsumerZoneServiceImpl implements ConsumerZoneService{

	private ConsumerZoneDao consumerZoneDao;
	
	/**
	 * 取得消費者專區資料清單(分頁)
	 * @param pageCount
	 * @param pageStart
	 * @param customerHelp
	 * @return List<customerHelp> 
	 **/
	public List<ConsumerZone>getList(int pageCount, int pageStart, ConsumerZone consumerZone){
		return consumerZoneDao.getList(pageCount, pageStart, consumerZone);
	}
	
	/**
	 * 取得消費者專區總筆數
	 * @param customerHelp
	 * @return Integer
	 **/
	public Integer getCount(ConsumerZone consumerZone){
		return consumerZoneDao.getCount(consumerZone);
	}
	
	/**
	 * 取得消費者專區
	 * @param customerHelp
	 **/
	public ConsumerZone getData(ConsumerZone consumerZone){
		return consumerZoneDao.getData(consumerZone);
	}
	
	/**
	 *新增消費者專區
	 *@param customerHelp 
	 **/
	public void add(ConsumerZone consumerZone){
		consumerZoneDao.add(consumerZone);
	}
	
	/**
	 *修改消費者專區資料
	 *@param customerHelp 
	 **/
	public void update(ConsumerZone consumerZone){
		consumerZoneDao.update(consumerZone);
	}
	
	/**
	 *刪除消費者專區資料
	 *@param id
	 **/
	public void delete(Integer id){
		consumerZoneDao.delete(id);
	}
	
	public void setConsumerZoneDao(ConsumerZoneDao consumerZoneDao){
		this.consumerZoneDao = consumerZoneDao;
	}
}
