package sso.struts2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionSupport;

import sso.spring.DeployInfoUtil;

/**
 * 基本控制類
 * @author Ken
 * @version 創建時間2016-01-25
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 1L;
	
	protected String BASE_PATH; 				//根目錄
	protected String BASE_SERVLETPATH;			//路徑
	protected String MSG;						//錯誤訊息
	protected int COMPETENEC;					//權限
	protected HttpServletRequest request;		//頁面需求
	protected HttpServletResponse response;		//頁面回應
	protected int pageCount = 10;				//每頁筆數
	protected int pageTotalCount;				//總筆數
	protected int totalPage;					//總頁數
	protected int pageStart;					//起始筆數
	
	protected int leftStartPage;				//左邊開始頁碼
	protected int leftEndPage;					//左邊結束頁碼
	protected int rightStartPage;				//右邊開始頁碼
	protected int rightEndPage;					//右邊結束頁碼
	protected int pageMaxNum = 5;				//只顯示的頁碼數量
	protected int leftPageNum;					//左邊頁碼數量
	protected int rightPageNum;					//右邊頁碼數量
	
	@Override
	public void validate(){
		//String path = request.getContextPath();
		BASE_PATH = DeployInfoUtil.getWebRoot();
		BASE_SERVLETPATH = request.getServletPath().substring(1);
	}
	
	public int pageSetting(int pageNo) {
		if (pageTotalCount % pageCount == 0) {
			totalPage = pageTotalCount / pageCount;
		} else {
			totalPage = (pageTotalCount / pageCount) + 1;
		}
		if (pageNo <= 0) {
			pageNo = 1;
		} else if (pageNo > totalPage) {
			pageNo = totalPage;
		}
		pageStart = ((pageNo-1) * pageCount);
		
		//左右邊頁碼起訖初始化
		leftStartPage = 1;
		leftEndPage = pageNo - 1;
		rightStartPage = pageNo + 1;
		rightEndPage = totalPage;
		
		//
		if(totalPage < pageMaxNum) {
			pageMaxNum = totalPage;
		}
		
		leftPageNum = 0;
		rightPageNum = pageMaxNum - 1;
		
		//當頁左右頁碼數量判斷
		if(pageNo > 1) {
			if(pageNo <= pageMaxNum/2) {
				leftPageNum = pageNo - 1;
				rightPageNum = pageMaxNum - pageNo;
			} else if((pageMaxNum%2 == 0 && totalPage-pageNo <= pageMaxNum/2-1) || (pageMaxNum%2 == 1 && totalPage-pageNo <= pageMaxNum/2)) {
				rightPageNum = totalPage - pageNo;
				leftPageNum = pageMaxNum-rightPageNum-1;
			} else{
				leftPageNum = pageMaxNum / 2;
				rightPageNum = (pageMaxNum%2 == 0) ? pageMaxNum/2-1 : pageMaxNum/2 ;
			}
		}
		
		//當頁左右頁碼起訖設定
		leftStartPage = pageNo - leftPageNum;
		leftEndPage = pageNo - 1;
		rightStartPage = pageNo + 1;
		rightEndPage = pageNo + rightPageNum;
		
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
	
	public void errMessage(){
		
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

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getLeftStartPage() {
		return leftStartPage;
	}

	public void setLeftStartPage(int leftStartPage) {
		this.leftStartPage = leftStartPage;
	}

	public int getLeftEndPage() {
		return leftEndPage;
	}

	public void setLeftEndPage(int leftEndPage) {
		this.leftEndPage = leftEndPage;
	}

	public int getRightStartPage() {
		return rightStartPage;
	}

	public void setRightStartPage(int rightStartPage) {
		this.rightStartPage = rightStartPage;
	}

	public int getRightEndPage() {
		return rightEndPage;
	}

	public void setRightEndPage(int rightEndPage) {
		this.rightEndPage = rightEndPage;
	}

	public int getPageMaxNum() {
		return pageMaxNum;
	}

	public void setPageMaxNum(int pageMaxNum) {
		this.pageMaxNum = pageMaxNum;
	}

	public int getLeftPageNum() {
		return leftPageNum;
	}

	public void setLeftPageNum(int leftPageNum) {
		this.leftPageNum = leftPageNum;
	}

	public int getRightPageNum() {
		return rightPageNum;
	}

	public void setRightPageNum(int rightPageNum) {
		this.rightPageNum = rightPageNum;
	}
	
}