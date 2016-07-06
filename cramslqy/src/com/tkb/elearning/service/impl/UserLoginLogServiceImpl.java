package com.tkb.elearning.service.impl;

import com.tkb.elearning.dao.UserLoginLogDao;
import com.tkb.elearning.model.UserLoginLog;
import com.tkb.elearning.service.UserLoginLogService;

/**
 * 使用者記錄Service實作類
 * @author Ken
 * @version 創建時間：2016-02-06
 */
public class UserLoginLogServiceImpl implements UserLoginLogService {

	private UserLoginLogDao userLoginLogDao;
	
	public void addUserLoginLog(UserLoginLog userLoginLog) {
		userLoginLogDao.addUserLoginLog(userLoginLog);
	}

	public void setUserLoginLogDao(UserLoginLogDao userLoginLogDao) {
		this.userLoginLogDao = userLoginLogDao;
	}
	
}
