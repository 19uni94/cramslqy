package com.tkb.elearning.action;

import com.tkb.elearning.service.AboutLawService;
import com.tkb.elearning.service.AssociationMemberService;
import com.tkb.elearning.service.BannerService;
import com.tkb.elearning.service.CramCaseService;
import com.tkb.elearning.service.CramMemberService;
import com.tkb.elearning.service.MeetingMinutesService;
import com.tkb.elearning.service.ConsumerZoneService;
import com.tkb.elearning.service.NewsService;
import com.tkb.elearning.service.ZoneService;

import sso.struts2.FrontBaseAction;

public class ServiceAction extends FrontBaseAction{
	
	private static final long serialVersionUID = -7106093429503552786L;
	
	private BannerService bannerService;							//廣告服務
	private NewsService newsService;								//最新消息服務
	private AssociationMemberService associationMemberService; 		//協會成員服務
	private AboutLawService aboutLawService;						//相關法規服務
	private ZoneService zoneService;								//地區管理服務
    private CramMemberService cramMemberService;					//協會會員服務
    private ConsumerZoneService consumerZoneService;				//消費者專區服務
    private CramCaseService cramCaseService;						//補習糾紛案例服務
    private MeetingMinutesService meetingMinutesService;			//會議紀錄服務
    
    
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
	public AssociationMemberService getAssociationMemberService() {
		return associationMemberService;
	}
	public void setAssociationMemberService(AssociationMemberService associationMemberService) {
		this.associationMemberService = associationMemberService;
	}
	public AboutLawService getAboutLawService() {
		return aboutLawService;
	}
	public void setAboutLawService(AboutLawService aboutLawService) {
		this.aboutLawService = aboutLawService;
	}
	public ZoneService getQaService() {
		return zoneService;
	}
	public void setQaService(ZoneService zoneService) {
		this.zoneService = zoneService;
	}
	public CramMemberService getCramMemberService() {
		return cramMemberService;
	}
	public void setCramMemberService(CramMemberService cramMemberService) {
		this.cramMemberService = cramMemberService;
	}
	public ConsumerZoneService getConsumerZoneService() {
		return consumerZoneService;
	}
	public void setConsumerZoneService(ConsumerZoneService consumerZoneService) {
		this.consumerZoneService = consumerZoneService;
	}
	public CramCaseService getCramCaseService() {
		return cramCaseService;
	}
	public void setCramCaseService(CramCaseService cramCaseService) {
		this.cramCaseService = cramCaseService;
	}
	public MeetingMinutesService getMeetingMinutesService() {
		return meetingMinutesService;
	}
	public void setMeetingMinutesService(MeetingMinutesService meetingMinutesService) {
		this.meetingMinutesService = meetingMinutesService;
	}

}

