package sso.spring;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 類說明:布署信息
 * @author Ken
 * @version 創建時間2016-01-25
 */
public class DeployInfo {
	private final static Log log = LogFactory.getLog(DeployInfo.class);

	private String uploadFilePath;		//檔案上傳位置
	private String fileServerHost;		//檔案伺服器路徑

	private String webRoot;				//伺服器網址
	private String webBase;				//伺服器實體路徑
	
	private String projectName;			//專案名稱
	
	private String desKey;				//加密金鑰
    private String desModeAndPadding;	//加密路徑
    
    private String from;				//email發送地址
    private String host;				//email服務smtp地址
    private String username;			//email帳戶
    private String password;			//email密碼
    
	private int adMaxSize;				//廣告大小
	
    public int getAdMaxSize() {
		return adMaxSize;
	}

	public void setAdMaxSize(int adMaxSize) {
		this.adMaxSize = adMaxSize;
	}

    public void echoDeployInfo() {
		InetAddress addr;
		try {
			log.info("elearning 部署信息");
			addr = InetAddress.getLocalHost();
			log.info("Web應用伺服器主機->" + addr.getHostName() + ":"
					+ addr.getHostAddress());
			log.info("檔上傳位置->" + uploadFilePath);
			log.info("文件訪問地址->" + fileServerHost);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesKey() {
		return desKey;
	}

	public void setDesKey(String desKey) {
		this.desKey = desKey;
	}

	public String getDesModeAndPadding() {
		return desModeAndPadding;
	}

	public void setDesModeAndPadding(String desModeAndPadding) {
		this.desModeAndPadding = desModeAndPadding;
	}

	public String getFileServerHost() {
		return fileServerHost;
	}

	public void setFileServerHost(String fileServerHost) {
		this.fileServerHost = fileServerHost;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUploadFilePath() {
		return uploadFilePath;
	}

	public void setUploadFilePath(String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	public String getWebRoot() {
		return webRoot;
	}

	public void setWebRoot(String webRoot) {
		this.webRoot = webRoot;
	}

	public String getWebBase() {
		return webBase;
	}

	public void setWebBase(String webBase) {
		this.webBase = webBase;
	}
}