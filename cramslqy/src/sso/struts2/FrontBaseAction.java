package sso.struts2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import sso.spring.DeployInfoUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基本控制類
 * @author dawnpioneer
 * 2014-06-10
 */
public class FrontBaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 1L;
	
	protected String BASE_PATH; 			//根目錄
	protected String BASE_SERVLETPATH;		//路徑
	protected String MSG;					//錯誤訊息
	protected int COMPETENEC;				//權限
	protected HttpServletRequest request;	//頁面需求
	protected HttpServletResponse response;	//頁面回應
	protected Map<String, Object> session;	//瀏覽器暫存
	protected int pageCount = 10;			//每頁筆數
	protected int pageTotalCount;			//總筆數
	protected int totalPage;				//總頁數
	protected int pageStart;				//起始筆數
	
	@Override
	public void validate(){
		BASE_PATH = DeployInfoUtil.getWebRoot();
		BASE_SERVLETPATH = request.getServletPath().substring(1);
		session = ActionContext.getContext().getSession();
	}
	
	/**
	 * 分頁
	 * @param pageNo
	 * @return
	 */
	public int pageSetting(int pageNo) {
		if (pageTotalCount % pageCount == 0) {
			totalPage = pageTotalCount / pageCount;
		} else {
			totalPage = (pageTotalCount / pageCount) + 1;
		}
		if (totalPage == 0) {
			totalPage = 1;
		}
		if (pageNo <= 0) {
			pageNo = 1;
		} else if (pageNo > totalPage) {
			pageNo = totalPage;
		}
		pageStart = (pageNo-1) * pageCount;
		return pageNo;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public String execute() throws Exception {
		return ERROR;
	}

	public String getBASE_PATH() {
		return BASE_PATH;
	}

	public void setBASE_PATH(String bASE_PATH) {
		BASE_PATH = bASE_PATH;
	}
	
	public String getBASE_SERVLETPATH() {
		return BASE_SERVLETPATH;
	}

	public void setBASE_SERVLETPATH(String bASE_SERVLETPATH) {
		BASE_SERVLETPATH = bASE_SERVLETPATH;
	}

	public String getMSG() {
		return MSG;
	}

	public void setMSG(String mSG) {
		MSG = mSG;
	}

	public int getCOMPETENEC() {
		return COMPETENEC;
	}

	public void setCOMPETENEC(int cOMPETENEC) {
		COMPETENEC = cOMPETENEC;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}