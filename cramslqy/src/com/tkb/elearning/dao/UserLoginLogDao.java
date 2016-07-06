package com.tkb.elearning.dao;

import com.tkb.elearning.model.UserLoginLog;

/**
 * 使用者記錄Dao介面接口
 * @author Admin
 * @version 創建時間：2016-03-15
 */
public interface UserLoginLogDao {
	
	/**
	 * 記錄登入Log
	 * @param userLoginLog
	 */
	public void addUserLoginLog(UserLoginLog userLoginLog);

}