package com.tkb.elearning.action;



import java.util.List;


import com.tkb.elearning.model.AboutLaw;
import com.tkb.elearning.model.AllAssociation;
import com.tkb.elearning.model.Banner;
import com.tkb.elearning.model.ConsumerZone;
import com.tkb.elearning.model.MeetingMinutes;
import com.tkb.elearning.model.News;
import com.tkb.elearning.service.AboutLawService;
import com.tkb.elearning.service.AllAssociationService;
import com.tkb.elearning.service.BannerService;
import com.tkb.elearning.service.ConsumerZoneService;
import com.tkb.elearning.service.MeetingMinutesService;
import com.tkb.elearning.service.NewsService;


public class IndexAction extends ServiceAction{
	
	private static final long serialVersionUID = -8839850153743344197L;
	
	private BannerService bannerService;					//廣告Service
	private NewsService newsService;						//最新消息Service
	private ConsumerZoneService consumerZoneService;		//消費者專區Service	
	private AboutLawService aboutLawService;				//相關法規Service
	private MeetingMinutesService meetingMinutesService;	//會議紀錄Service
	private AllAssociationService allAssociationService;	//各區協會Service
	private List<Banner> bannerList;						//廣告陣列
	private List<News> newsIndexList;					    //前台首頁最新消息資料陣列
	private List<News> newsFrontList;					    //前台最新消息資料陣列
	private List<News> newsList;					   		//最新消息資料陣列
	private List<ConsumerZone> consumerZoneList;			//消費者專區陣列
	private List<AboutLaw> aboutLawList;					//相關法規陣列
	private List<MeetingMinutes> meetingMinutesList;		//會議紀錄陣列
	private List<AllAssociation> allAssociationList;		//各區協會資訊真列
	private News news;										//最新消息資料
	private Banner banner;									//Banner
	private ConsumerZone consumerZone;  					//消費者專區資料
	private AboutLaw aboutLaw;  							//相關法規資料
	private MeetingMinutes meetingMinutes;					//會議紀錄資料
	private AllAssociation allAssociation;					//各區協會資料
	private int pageNo;										//頁碼
	
	
	public String index(){
		
//		if(banner == null) {
//			banner = new Banner();
//		}
//		bannerList = bannerService.getList(pageCount, pageStart, banner);	
		
		if(news == null) {
			news = new News();
		}
//		pageTotalCount = newsService.getCount(news);
//		pageNo = super.pageSetting(pageNo);
		super.pageCount=10;
		newsIndexList = newsService.getIndexList(news);	
		
//		System.out.print(news.getId());
				
		return "cramslqy";
	
	}
	
	public String banner(){
	
		if(banner == null) {
			banner = new Banner();
		}
		bannerList = bannerService.getList(pageCount, pageStart, banner);	
		
		return"banner";
	}
	
	public String news(){
		
		if(news == null) {
			news = new News();
		}

		pageTotalCount = newsService.getCount2(news);
		pageNo = super.pageSetting(pageNo);
		newsFrontList = newsService.getFrontList(pageCount, pageStart, news);

		return "news"; 

	}	
	
	public String newsView(){
		
//		int id = Integer.getInteger("id");
//		news=new News();
//		news.setId(id);
		news = newsService.getData(news);
				
//		System.out.println(news.getTitle());
		
	    return"newsView";
	}

	public String consumerZone(){
		
		if(consumerZone == null) {
			consumerZone = new ConsumerZone();
		}
	
		pageTotalCount = consumerZoneService.getCount(consumerZone);
		pageNo = super.pageSetting(pageNo);
		consumerZoneList = consumerZoneService.getList(pageCount, pageStart, consumerZone);
		
		consumerZone=consumerZoneService.getData(consumerZone);
		
//		System.out.println(consumerZone.getId());
		
		return "consumerZone";
	}
	
	public String aboutLaw(){
		
		if(aboutLaw == null) {
			aboutLaw = new AboutLaw();
		}
	
		pageTotalCount = aboutLawService.getCount(aboutLaw);
		pageNo = super.pageSetting(pageNo);
		aboutLawList = aboutLawService.getList(pageCount, pageStart, aboutLaw);
		
		return "aboutLaw";
	}

	public String aboutLawView(){
		
//		int id = Integer.getInteger("id");
//		news=new News();
//		news.setId(id);
		aboutLaw = aboutLawService.getData(aboutLaw);
				
//		System.out.println(aboutLaw.getTitle());
		
	    return"aboutLawView";
	}
	
	public String meetingMinutes(){
		
		if(meetingMinutes == null){
			meetingMinutes = new MeetingMinutes();
		}
		
		pageTotalCount = meetingMinutesService.getCount(meetingMinutes);
		pageNo=super.pageSetting(pageNo);
		meetingMinutesList = meetingMinutesService.getList(pageCount, pageStart, meetingMinutes);
		
		return "meetingMinutes";
	}
	
	public String meetingMinutesView(){
		
		meetingMinutes=meetingMinutesService.getData(meetingMinutes);
		
		return"meetingMinutesView";
	}
	
	public String allAssociation(){
		
		if(allAssociation ==null){
			allAssociation = new AllAssociation();
		}
		
		pageTotalCount = allAssociationService.getCount(allAssociation);
		pageNo=super.pageSetting(pageNo);
		allAssociationList=allAssociationService.getList(pageCount, pageStart, allAssociation);
		
		return "allAssociation";
	}
	
	public String search(){
		return "search";
	}
		
	
	public String about(){
		return "about";
	}
	
	public String cramCase(){
		return "cramCase";
	}
	
	public String qyEnsure(){
		return "qyEnsure";
	}	
		
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
		
	public List<News> getNewsIndexList() {
		return newsIndexList;
	}

	public void setNewsIndexList(List<News> newsIndexList) {
		this.newsIndexList = newsIndexList;
	}

	public List<News> getNewsFrontList() {
		return newsFrontList;
	}

	public void setNewsFrontList(List<News> newsFrontList) {
		this.newsFrontList = newsFrontList;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public Banner getBanner() {
		return banner;
	}

	public void setBanner(Banner banner) {
		this.banner = banner;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
	public BannerService getBannerService() {
		return bannerService;
	}

	public void setBannerService(BannerService bannerService) {
		this.bannerService = bannerService;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	
	public ConsumerZoneService getConsumerZoneService() {
		return consumerZoneService;
	}

	public void setConsumerZoneService(ConsumerZoneService consumerZoneService) {
		this.consumerZoneService = consumerZoneService;
	}	
	
	public AllAssociationService getAllAssociationService() {
		return allAssociationService;
	}
	public void setAllAssociationService(AllAssociationService allAssociationService) {
		this.allAssociationService = allAssociationService;
	}
	public List<Banner> getBannerList() {
		return bannerList;
	}

	public void setBannerList(List<Banner> bannerList) {
		this.bannerList = bannerList;
	}

	public List<ConsumerZone> getConsumerZoneList() {
		return consumerZoneList;
	}

	public void setConsumerZoneList(List<ConsumerZone> consumerZoneList) {
		this.consumerZoneList = consumerZoneList;
	}

	public List<AllAssociation> getAllAssociationList() {
		return allAssociationList;
	}
	
	public void setAllAssociationList(List<AllAssociation> allAssociationList) {
		this.allAssociationList = allAssociationList;
	}
	
	public AllAssociation getAllAssociation() {
		return allAssociation;
	}
	
	public void setAllAssociation(AllAssociation allAssociation) {
		this.allAssociation = allAssociation;
	}
	
	public ConsumerZone getConsumerZone() {
		return consumerZone;
	}

	public void setConsumerZone(ConsumerZone consumerZone) {
		this.consumerZone = consumerZone;
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

	public MeetingMinutesService getMeetingMinutesService() {
		return meetingMinutesService;
	}

	public void setMeetingMinutesService(MeetingMinutesService meetingMinutesService) {
		this.meetingMinutesService = meetingMinutesService;
	}

	public List<MeetingMinutes> getMeetingMinutesList() {
		return meetingMinutesList;
	}

	public void setMeetingMinutesList(List<MeetingMinutes> meetingMinutesList) {
		this.meetingMinutesList = meetingMinutesList;
	}

	public MeetingMinutes getMeetingMinutes() {
		return meetingMinutes;
	}

	public void setMeetingMinutes(MeetingMinutes meetingMinutes) {
		this.meetingMinutes = meetingMinutes;
	}
	
}
