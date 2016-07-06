package sso.spring;

/**
 * 類說明：布署環境信息
 * @author Ken
 * @version 創建時間：2016-01-25
 */
public class DeployInfoUtil {
	
	/**
	 * 取得檔案上傳位置
	 * @return
	 */
	public static String getUploadFilePath(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getUploadFilePath();
	}
	
	/**
	 * 取得檔案路徑
	 * @return
	 */
	public static String getFileServerHost(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getFileServerHost();
	}
	
	/**
	 * 取得專案名稱
	 * @return
	 */
	public static String getProjectName(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getProjectName();
	}
	
	/**
	 * 取得加密金鑰
	 * @return
	 */
	public static String getDesKey(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getDesKey();
	}
	
	/**
	 * 取得加密路徑
	 * @return
	 */
	public static String getDesModeAndPadding(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getDesModeAndPadding();
	}
	
	/**
	 * 取得發送地址
	 * @return
	 */
	public static String getEmailFrom(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getFrom();
	}
	
	/**
	 * 取得服務smtp
	 * @return
	 */
	public static String getEmailHost(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getHost();
	}
	
	/**
	 * 取得帳戶
	 * @return
	 */
	public static String getUsername(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getUsername();
	}
	
	/**
	 * 取得密碼
	 * @return
	 */
	public static String getPassword(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getPassword();
	}
	
	/**
	 * 取得廣告最大大小
	 * @return
	 */
	public static int getAdMaxSize(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getAdMaxSize();
	}
	
	/**
	 * 取得伺服器路徑
	 * @return
	 */
	public static String getWebRoot(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getWebRoot();
	}
	
	/**
	 * 取得伺服器實體路徑
	 * @return
	 */
	public static String getWebBase(){
		return ((DeployInfo)SpringContextUtil.getApplicationContext().getBean("deployInfo")).getWebBase();
	}
}