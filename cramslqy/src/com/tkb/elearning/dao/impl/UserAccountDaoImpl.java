package com.tkb.elearning.dao.impl;

import java.util.List;

import com.tkb.elearning.dao.UserAccountDao;
import com.tkb.elearning.model.UserAccount;

import sso.ojdbc.dao.impl.PagingDaoImpl;

public class UserAccountDaoImpl extends PagingDaoImpl implements UserAccountDao {

	@SuppressWarnings({ "unchecked" })
	public UserAccount login(UserAccount userAccount){
		String sql = " SELECT * FROM user_account WHERE ALIVE = 1 "
				   + " AND ACCOUNT = ? AND PASSWORD = ? ";
		List<UserAccount> list = getJdbcTemplate().query(sql, new Object[]{ userAccount.getAccount(),
				userAccount.getPassword() }, getRowMapper());
		return list.size() == 0 ? null : list.get(0);
	}
	
	public Integer checkAccount(UserAccount userAccount) {
		String sql = " SELECT count(*) FROM user_account WHERE ALIVE = 1 "
				   + " AND ACCOUNT = ? ";
		return getJdbcTemplate().queryForInt(sql, new Object[]{ userAccount.getAccount() });
	}
	
	public Integer checkStatus(UserAccount userAccount) {
		String sql = " SELECT count(*) FROM user_account WHERE ALIVE = 1 "
				   + " AND STATUS = 1 AND ACCOUNT = ? ";
		return getJdbcTemplate().queryForInt(sql, new Object[]{ userAccount.getAccount() });
	}
	
}
