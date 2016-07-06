package com.tkb.elearning.action.admin;

import java.io.IOException;
import java.util.List;

import com.tkb.elearning.model.CramCase;
import com.tkb.elearning.service.CramCaseService;
import com.tkb.elearning.util.UploadUtil;
import com.tkb.elearning.util.VerifyBaseAction;

import sso.spring.DeployInfoUtil;

/**
 * 補習糾紛案例Action
 * @author Admin
 * @version 創建時間：2016-03-24
 */
public class CramCaseAction extends VerifyBaseAction {

	private static final long serialVersionUID = 1L;
	
	private CramCaseService cramCaseService;	//補習糾紛案例服務
	private List<CramCase> cramCaseList;		//補習糾紛案例清單
	private CramCase cramCase;					//補習糾紛案例資料
	private int pageNo;							//頁碼
	private String uploadImage;					//圖片檔案
	private String imageExtension;				//圖片副檔名
	private int[] deleteList;					//刪除的ID清單
	private String deleteImage;					//刪除的圖片(舊圖檔)
	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(cramCase == null) {
			cramCase = new CramCase();
		}
		
		pageTotalCount = cramCaseService.getCount(cramCase);
		pageNo = super.pageSetting(pageNo);
		cramCaseList = cramCaseService.getList(pageCount, pageStart, cramCase);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		cramCase = new CramCase();
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
		
		cramCase.setImage(UploadUtil.upload(DeployInfoUtil.getUploadFilePath() + "image/news/" , uploadImage, cramCase.getImage(), cramCase.getId(), imageExtension));
		cramCaseService.add(cramCase);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		cramCase = cramCaseService.getData(cramCase);
		return "form";
		
	}
	
	 /**
	 * 修改最新消息
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException {
		
		if(uploadImage != null) {
			UploadUtil.delete(DeployInfoUtil.getUploadFilePath() + "image/news/" + deleteImage);
		}
		cramCase.setImage(UploadUtil.upload(DeployInfoUtil.getUploadFilePath() + "image/news/" , uploadImage, cramCase.getImage(), cramCase.getId(), imageExtension));
		cramCaseService.update(cramCase);
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			cramCase.setId(id);
			cramCase = cramCaseService.getData(cramCase);
			UploadUtil.delete(DeployInfoUtil.getUploadFilePath() + "image/news/" + cramCase.getImage());
			cramCaseService.delete(id);
		}
		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		cramCase=cramCaseService.getData(cramCase);
		return "view";
		
	}

	public CramCaseService getCramCaseService() {
		return cramCaseService;
	}

	public void setCramCaseService(CramCaseService cramCaseService) {
		this.cramCaseService = cramCaseService;
	}

	public List<CramCase> getCramCaseList() {
		return cramCaseList;
	}

	public void setCramCaseList(List<CramCase> cramCaseList) {
		this.cramCaseList = cramCaseList;
	}

	public CramCase getCramCase() {
		return cramCase;
	}

	public void setCramCase(CramCase cramCase) {
		this.cramCase = cramCase;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(String uploadImage) {
		this.uploadImage = uploadImage;
	}

	public String getImageExtension() {
		return imageExtension;
	}

	public void setImageExtension(String imageExtension) {
		this.imageExtension = imageExtension;
	}

	public int[] getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(int[] deleteList) {
		this.deleteList = deleteList;
	}

	public String getDeleteImage() {
		return deleteImage;
	}

	public void setDeleteImage(String deleteImage) {
		this.deleteImage = deleteImage;
	}
	
	}