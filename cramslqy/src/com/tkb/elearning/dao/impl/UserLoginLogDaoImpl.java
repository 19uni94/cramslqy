package com.tkb.elearning.dao.impl;

import com.tkb.elearning.dao.UserLoginLogDao;
import com.tkb.elearning.model.UserLoginLog;

import sso.ojdbc.dao.impl.PagingDaoImpl;

/**
 * 使用者記錄Dao實作類
 * @author Ken
 * @version 創建時間：2016-03-15
 */
public class UserLoginLogDaoImpl extends PagingDaoImpl implements UserLoginLogDao {
	
	public void addUserLoginLog(UserLoginLog userLoginLog) {
		String sql = " INSERT INTO user_login_log(ACCOUNT, IP, STATUS, CREATE_DATE) "
				   + " VALUES(?, ?, ?, NOW()) ";
		getJdbcTemplate().update(sql, new Object[]{ userLoginLog.getAccount()
				, userLoginLog.getIp(), userLoginLog.getStatus()});
	}

}