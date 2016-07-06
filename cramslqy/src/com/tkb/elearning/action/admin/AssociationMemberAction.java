package com.tkb.elearning.action.admin;

import java.io.IOException;
import java.util.List;

import com.tkb.elearning.model.AssociationMember;
import com.tkb.elearning.service.AssociationMemberService;
import com.tkb.elearning.util.UploadUtil;
import com.tkb.elearning.util.VerifyBaseAction;

import sso.spring.DeployInfoUtil;

public class AssociationMemberAction extends VerifyBaseAction {

	private static final long serialVersionUID = 1L;
	
	private AssociationMemberService associationMemberService;	//協會成員服務
	private List<AssociationMember> associationMemberList;		//協會成員清單
	private AssociationMember associationMember;				//協會成員資料
	private int pageNo;											//頁碼
	private String uploadImage;									//圖片檔案
	private String imageExtension;								//圖片副檔名
	private int[] deleteList;									//刪除的ID清單
	private String deleteImage;									//刪除的圖片(舊圖檔)
	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(associationMember == null) {
		   associationMember = new AssociationMember();
		}
		
		pageTotalCount = associationMemberService.getCount(associationMember);
		pageNo = super.pageSetting(pageNo);
		associationMemberList = associationMemberService.getList(pageCount, pageStart, associationMember);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		associationMember = new AssociationMember();
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
		
		associationMember.setImage(UploadUtil.upload(DeployInfoUtil.getUploadFilePath() + "image/news/" , uploadImage, associationMember.getImage(), associationMember.getId(), imageExtension));
		associationMember.setCreate_by(USER_DATA.getAccount());
		associationMember.setUpdate_by(USER_DATA.getAccount());
		associationMemberService.add(associationMember);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		associationMember = associationMemberService.getData(associationMember);
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
		associationMember.setImage(UploadUtil.upload(DeployInfoUtil.getUploadFilePath() + "image/news/" , uploadImage, associationMember.getImage(), associationMember.getId(), imageExtension));
		associationMember.setUpdate_by(USER_DATA.getAccount());
		associationMemberService.update(associationMember);
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			associationMember.setId(id);
			associationMember = associationMemberService.getData(associationMember);
			UploadUtil.delete(DeployInfoUtil.getUploadFilePath() + "image/news/" + associationMember.getImage());
			associationMemberService.delete(id);
		}
		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		associationMember=associationMemberService.getData(associationMember);
		return "view";
		
	}

	public AssociationMemberService getAssociationMemberService() {
		return associationMemberService;
	}

	public void setAssociationMemberService(AssociationMemberService associationMemberService) {
		this.associationMemberService = associationMemberService;
	}

	public List<AssociationMember> getAssociationMemberList() {
		return associationMemberList;
	}

	public void setAssociationMemberList(List<AssociationMember> associationMemberList) {
		this.associationMemberList = associationMemberList;
	}

	public AssociationMember getAssociationMember() {
		return associationMember;
	}

	public void setAssociationMember(AssociationMember associationMember) {
		this.associationMember = associationMember;
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
