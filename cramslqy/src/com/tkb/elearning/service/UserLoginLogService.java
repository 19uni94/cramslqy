package com.tkb.elearning.service;

import com.tkb.elearning.model.UserLoginLog;

/**
 * 使用者記錄Service介面接口
 * @author Admin
 * @version 創建時間：2016-03-15
 */
public interface UserLoginLogService {

	/**
	 * 記錄登入Log
	 * @param userLoginLog
	 */
	public void addUserLoginLog(UserLoginLog userLoginLog);
	
}
