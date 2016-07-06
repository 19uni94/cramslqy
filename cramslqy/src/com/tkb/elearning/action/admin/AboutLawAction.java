package com.tkb.elearning.action.admin;

import java.io.IOException;
import java.util.List;

import com.tkb.elearning.model.AboutLaw;
import com.tkb.elearning.service.AboutLawService;
import com.tkb.elearning.util.UploadUtil;
import com.tkb.elearning.util.VerifyBaseAction;

import sso.spring.DeployInfoUtil;


public class AboutLawAction extends VerifyBaseAction {

	private static final long serialVersionUID = 1L;
	
	private AboutLawService  aboutLawService;	//相關法規服務
	private List<AboutLaw> aboutLawList;		//相關法規清單
	private AboutLaw aboutLaw;					//相關法規資料
	private int pageNo;							//頁碼
	private String uploadFile;					//文件檔案
	private String fileExtension;				//文件副檔名
	private int[] deleteList;					//刪除的ID清單
	private String deleteFile;					//刪除的文件(舊文件)
	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(aboutLaw == null) {
			aboutLaw = new AboutLaw();
		}
		
		pageTotalCount = aboutLawService.getCount(aboutLaw);
		pageNo = super.pageSetting(pageNo);
		aboutLawList = aboutLawService.getList(pageCount, pageStart, aboutLaw);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		aboutLaw = new AboutLaw();
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
				
		aboutLaw.setFile(UploadUtil.upload(DeployInfoUtil.getUploadFilePath() + "file/aboutLaw" ,
				   uploadFile, aboutLaw.getFile(), aboutLaw.getId(), fileExtension));
		aboutLawService.add(aboutLaw);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		aboutLaw = aboutLawService.getData(aboutLaw);
		return "form";
		
	}
	
	/**
	 * 修改相關法規
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException {
	
		if(uploadFile !=null){
			UploadUtil.delete(DeployInfoUtil.getUploadFilePath() + "file/aboutLaw/" + deleteFile);
		}
		
		aboutLaw.setFile(UploadUtil.upload(DeployInfoUtil.getUploadFilePath() + "file/aboutLaw" ,
				   uploadFile, aboutLaw.getFile(), aboutLaw.getId(), fileExtension));
		
		aboutLawService.update(aboutLaw);
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			aboutLaw.setId(id);
			aboutLaw = aboutLawService.getData(aboutLaw);			
			aboutLawService.delete(id);
		}
		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		aboutLaw=aboutLawService.getData(aboutLaw);
		return "view";
		
	}
	
	

	public AboutLawService getAboutLawService() {
		return aboutLawService;
	}

	public void setAboutLawService(AboutLawService aboutLawService) {
		this.aboutLawService = aboutLawService;
	}

	public List<AboutLaw> getAboutLawList() {
		return aboutLawList;
	}

	public void setAboutLawList(List<AboutLaw> aboutLawList) {
		this.aboutLawList = aboutLawList;
	}

	public AboutLaw getAboutLaw() {
		return aboutLaw;
	}

	public void setAboutLaw(AboutLaw aboutLaw) {
		this.aboutLaw = aboutLaw;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public int[] getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(int[] deleteList) {
		this.deleteList = deleteList;
	}

	public String getDeleteFile() {
		return deleteFile;
	}

	public void setDeleteFile(String deleteFile) {
		this.deleteFile = deleteFile;
	}

}
