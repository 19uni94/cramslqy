package com.tkb.elearning.action.admin;

import java.io.IOException;

import java.util.List;


import com.tkb.elearning.model.AboutWe;
import com.tkb.elearning.service.AboutWeService;
import com.tkb.elearning.util.VerifyBaseAction;

public class AboutWeAction extends VerifyBaseAction {
		
	private static final long serialVersionUID = 1L;
	
	private AboutWeService  aboutWeService;		//相關法規服務
	private List<AboutWe> aboutWeList;			//相關法規清單
	private AboutWe aboutWe;					//相關法規資料
	private int pageNo;							//頁碼
	private int[] deleteList;					//刪除的ID清單

	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(aboutWe == null) {
			aboutWe = new AboutWe();
		}
		
		pageTotalCount = aboutWeService.getCount(aboutWe);
		pageNo = super.pageSetting(pageNo);
		aboutWeList = aboutWeService.getList(pageCount, pageStart, aboutWe);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		aboutWe= new AboutWe();
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
				

		aboutWeService.add(aboutWe);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		aboutWe = aboutWeService.getData(aboutWe);
		return "form";
		
	}
	
	/**
	 * 修改最新消息
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException {
	
		aboutWeService.update(aboutWe);
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			aboutWe.setId(id);
			aboutWe = aboutWeService.getData(aboutWe);			
			aboutWeService.delete(id);
		}
		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		aboutWe=aboutWeService.getData(aboutWe);
		return "view";
		
	}

	public AboutWeService getAboutWeService() {
		return aboutWeService;
	}

	public void setAboutWeService(AboutWeService aboutWeService) {
		this.aboutWeService = aboutWeService;
	}

	public List<AboutWe> getAboutWeList() {
		return aboutWeList;
	}

	public void setAboutWeList(List<AboutWe> aboutWeList) {
		this.aboutWeList = aboutWeList;
	}

	public AboutWe getAboutWe() {
		return aboutWe;
	}

	public void setAboutWe(AboutWe aboutWe) {
		this.aboutWe = aboutWe;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int[] getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(int[] deleteList) {
		this.deleteList = deleteList;
	}	
	
}
