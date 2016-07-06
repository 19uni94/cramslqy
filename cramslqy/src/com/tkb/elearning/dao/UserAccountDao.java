package com.tkb.elearning.dao;

import com.tkb.elearning.model.UserAccount;

/**
 * 使用者Dao介面接口
 * @author Admin
 * @version 創建時間：2016-03-15
 */
public interface UserAccountDao {

	/**
	 * 驗證帳號密碼
	 * @param account
	 * @param password
	 * @return User
	 */
	public UserAccount login(UserAccount userAccount);
	
	/**
	 * 確認帳號是否存在
	 * @param userAccount
	 * @return Integer
	 */
	public Integer checkAccount(UserAccount userAccount);
	
	/**
	 * 確認帳號是否未鎖定
	 * @param userAccount
	 * @return
	 */
	public Integer checkStatus(UserAccount userAccount);
	
}
