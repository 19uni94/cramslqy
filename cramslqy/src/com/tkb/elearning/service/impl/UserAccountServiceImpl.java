package com.tkb.elearning.service.impl;

import com.tkb.elearning.dao.UserAccountDao;
import com.tkb.elearning.model.UserAccount;
import com.tkb.elearning.service.UserAccountService;

/**
 * 使用者Service實作類
 * @author Admin
 * @version 創建時間：2016-03-15
 */
public class UserAccountServiceImpl implements UserAccountService {
	
	private UserAccountDao userAccountDao;
	
	public UserAccount login(UserAccount userAccount){
		return userAccountDao.login(userAccount);
	}
	
	public Integer checkAccount(UserAccount userAccount) {
		return userAccountDao.checkAccount(userAccount);
	}
	
	public Integer checkStatus(UserAccount userAccount) {
		return userAccountDao.checkStatus(userAccount);
	}

	public void setUserAccountDao(UserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

}
