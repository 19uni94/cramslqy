package com.tkb.elearning.action.admin;

import java.io.IOException;
import java.util.List;

import com.tkb.elearning.model.News;
import com.tkb.elearning.service.NewsService;
import com.tkb.elearning.util.UploadUtil;
import com.tkb.elearning.util.VerifyBaseAction;

import sso.spring.DeployInfoUtil;

/**
 * 最新消息Action
 * @author Ken
 * @version 創建時間：2016-02-09
 */
public class NewsAction extends VerifyBaseAction {

	private static final long serialVersionUID = 1L;
	
	private NewsService newsService;	//最新消息服務
	private List<News> newsList;		//最新消息清單
	private News news;					//最新消息資料
	private int pageNo;					//頁碼
	private String uploadImage;			//圖片檔案
	private String imageExtension;		//圖片副檔名
	private int[] deleteList;			//刪除的ID清單
	private String deleteImage;			//刪除的圖片(舊圖檔)
	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(news == null) {
			news = new News();
		}
		
		pageTotalCount = newsService.getCount(news);
		pageNo = super.pageSetting(pageNo);
		newsList = newsService.getList(pageCount, pageStart, news);
	
		System.out.println(news.getTitle());
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		news = new News();		
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
		
		news.setImage(UploadUtil.upload(DeployInfoUtil.getUploadFilePath() + "image/news/" , 
				uploadImage, news.getImage(), news.getId(), imageExtension));
		newsService.add(news);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		news = newsService.getData(news);
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
		news.setImage(UploadUtil.upload(DeployInfoUtil.getUploadFilePath() + "image/news/" , uploadImage, 
				news.getImage(), news.getId(), imageExtension));
		newsService.update(news);
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			news.setId(id);
			news = newsService.getData(news);
			UploadUtil.delete(DeployInfoUtil.getUploadFilePath() + "image/news/" + news.getImage());
			newsService.delete(id);
		}
		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		news=newsService.getData(news);

		return "view";
		
	}
	
	public void checkIndexNews() throws IOException{
		
		int index_show = Integer.parseInt(request.getParameter("index_show"));
		String msg = "";
		
		News news = new News();
		news.setId(index_show);
		int returnIndexNews = newsService.checkIndexNews(news);
		if(returnIndexNews < 10){
			msg = "true";
		} else {
			msg = "false";
		}
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(msg);
		}
		

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
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
