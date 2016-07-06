package com.tkb.elearning.action.admin;

import java.io.IOException;
import java.util.List;

import com.tkb.elearning.model.Banner;
import com.tkb.elearning.service.BannerService;
import com.tkb.elearning.util.UploadUtil;
import com.tkb.elearning.util.VerifyBaseAction;

import sso.spring.DeployInfoUtil;

public class BannerAction extends VerifyBaseAction {

	private static final long serialVersionUID = 1L;
	
	private BannerService bannerService;	//Banner服務
	private List<Banner> bannerList;		//Banner清單
	private Banner banner;					//Banner資料
	private int pageNo;						//頁碼
	private String uploadImage;				//圖片檔案
	private String imageExtension;			//圖片副檔名
	private int[] deleteList;				//刪除的ID清單
	private String deleteImage;				//刪除的圖片(舊圖檔)
	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(banner == null) {
			banner = new Banner();
		}
		
		pageTotalCount = bannerService.getCount(banner);
		pageNo = super.pageSetting(pageNo);
		bannerList = bannerService.getList(pageCount, pageStart, banner);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		banner = new Banner();
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
		
		banner.setImage(UploadUtil.upload(DeployInfoUtil.getUploadFilePath() + "image/banner/" , 
				uploadImage, banner.getImage(), banner.getId(), imageExtension));

		bannerService.add(banner);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		banner = bannerService.getData(banner);
		return "form";
		
	}
	
	public String updateSort(){
		bannerService.updateSort(banner);
		return "index";
	}
	
	/**
	 * 重新排序Banner
	 * @return
	 * */
	public String resetSort(){
		bannerService.resetSort();
		return "index";
	}
	 /**
	 * 修改最新消息
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException {
		
		if(uploadImage != null) {
			UploadUtil.delete(DeployInfoUtil.getUploadFilePath() + "image/banner/" + deleteImage);
		}
		banner.setImage(UploadUtil.upload(DeployInfoUtil.getUploadFilePath() + "image/banner/" , uploadImage, 
				banner.getImage(), banner.getId(), imageExtension));
		bannerService.update(banner);
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			banner.setId(id);
			banner = bannerService.getData(banner);
			UploadUtil.delete(DeployInfoUtil.getUploadFilePath() + "image/banner/" + banner.getImage());
			bannerService.delete(id);
		}
		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){



		banner=bannerService.getData(banner);
		return "view";
		
	}

	public BannerService getBannerService() {
		return bannerService;
	}

	public void setBannerService(BannerService bannerService) {
		this.bannerService = bannerService;
	}

	public List<Banner> getBannerList() {
		return bannerList;
	}

	public void setBannerList(List<Banner> bannerList) {
		this.bannerList = bannerList;
	}

	public Banner getBanner() {
		return banner;
	}

	public void setBanner(Banner banner) {
		this.banner = banner;
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
