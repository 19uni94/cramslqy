package com.tkb.elearning.action.admin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.tkb.elearning.model.UserAccount;
import com.tkb.elearning.model.UserLoginLog;
import com.tkb.elearning.service.UserAccountService;
import com.tkb.elearning.service.UserLoginLogService;
import com.tkb.elearning.util.Constants;
import com.tkb.elearning.util.DesEncrypt;

import sso.struts2.BaseAction;

/**
 * 後台登入
 * @author Ken
 * @version 創建時間：2016-01-25
 */
public class UserAccountAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	
	private UserAccountService userAccountService;
	private UserLoginLogService userLoginLogService;
	private UserAccount userAccount;

	/**
	 * 登入頁面
	 * @return
	 */
	public String login() {
		return "login";
	}
	
	/**
	 * 登入
	 * @return
	 */
	public String doLogin() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		userAccount.setPassword(DesEncrypt.desEncrypt(userAccount.getPassword()));
		UserLoginLog userLoginLog = new UserLoginLog();
		//帳號密碼錯誤
		if(userAccountService.login(userAccount) == null) {
			String errorMessage = "帳號或密碼輸入錯誤！";
			String message = "";
			//帳號存在且未被停權則記錄log並進行登入失敗處理
			if (userAccountService.checkAccount(userAccount) > 0) {
				if (userAccountService.checkStatus(userAccount) > 0) {
					userLoginLog.setStatus("登入失敗");
					loginLog(userLoginLog);
//					message = loginFail(session, user);
				} else {
					errorMessage = "此帳號已被停權！";
				}
			}
			addFieldError("", errorMessage);
			if (!"".equals(message)) {
				addFieldError("", message);
			}
		//帳號密碼正確
		} else {
//			System.out.println(userAccount.getAccount());
			userAccount = userAccountService.login(userAccount);
			if (userAccount.getStatus() == 0) {
				addFieldError("", "此帳號已被停權！");
			} else {
				//清除登入失敗紀錄、記錄使用者資訊
				session.put("loginFailCount", null);
				session.put(Constants.SESSION_USER, userAccount);
				COMPETENEC = userAccount.getAuthority();
				userLoginLog.setStatus("登入成功");
				loginLog(userLoginLog);
				return "index";
			}
		}
		
		return "login";
	}
	
	/**
	 * 登出
	 * @return
	 */
	public String doLogout(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove(Constants.SESSION_USER);
		return "login";
	}
	
	/**
	 * 登入紀錄
	 */
	public void loginLog(UserLoginLog userLoginLog) {
		userLoginLog.setAccount(userAccount.getAccount());
		userLoginLog.setIp(request.getRemoteAddr());
		userLoginLogService.addUserLoginLog(userLoginLog);
	}

	public UserAccountService getUserAccountService() {
		return userAccountService;
	}

	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	public UserLoginLogService getUserLoginLogService() {
		return userLoginLogService;
	}

	public void setUserLoginLogService(UserLoginLogService userLoginLogService) {
		this.userLoginLogService = userLoginLogService;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
}
