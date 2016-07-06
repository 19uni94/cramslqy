package com.tkb.elearning.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.tkb.elearning.model.UserAccount;

import sso.struts2.BaseAction;

public class VerifyBaseAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private String ERROR_CODE;			//錯誤代碼
	protected UserAccount USER_DATA;	//使用者基本資料
//	protected List<Menu> MENU_LIST;		//MENU選單
	
	public void validate(){
		super.validate();
		Map<String, Object> session = ActionContext.getContext().getSession();
		boolean isAllow = false;
		//判斷是否登入與是否閒置太久
		if(!isAllow){
			if(session.get(Constants.SESSION_USER) == null){
				ERROR_CODE = SystemCode.ERROR_407;
				MSG = "閒置太長，系統已自動登出!";
				addFieldError("","MSG");
				isAllow = true;
			}else{
				USER_DATA = (UserAccount) session.get(Constants.SESSION_USER);
				COMPETENEC = USER_DATA.getAuthority();
			}
		}
	}

	public String getERROR_CODE() {
		return ERROR_CODE;
	}

	public void setERROR_CODE(String eRROR_CODE) {
		ERROR_CODE = eRROR_CODE;
	}

	public UserAccount getUSER_DATA() {
		return USER_DATA;
	}

	public void setUSER_DATA(UserAccount uSER_DATA) {
		USER_DATA = uSER_DATA;
	}
	
}
