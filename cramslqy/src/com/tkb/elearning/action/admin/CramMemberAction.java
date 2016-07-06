package com.tkb.elearning.action.admin;

import java.io.IOException;


import java.util.List;

import com.tkb.elearning.model.CramMember;
import com.tkb.elearning.service.CramMemberService;
import com.tkb.elearning.util.VerifyBaseAction;

public class CramMemberAction extends VerifyBaseAction{

private static final long serialVersionUID = 1L;
	
	private CramMemberService cramMemberService;	//最新消息服務
	private List<CramMember> cramMemberList;		//最新消息清單
	private CramMember cramMember;					//最新消息資料
	private int pageNo;								//頁碼
	private int[] deleteList;                       //刪除的會員清單
	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(cramMember == null) {
			cramMember = new CramMember();
		}
		
		pageTotalCount = cramMemberService.getCount(cramMember);
		pageNo = super.pageSetting(pageNo);
		cramMemberList = cramMemberService.getList(pageCount, pageStart, cramMember);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 * **/
	public String add(){
		
		cramMember = new CramMember();
		return "form";
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOExcetpion
	 * **/
	public String addSubmit() throws IOException{
		
		cramMemberService.add(cramMember);
		return "index";
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update(){
		
		cramMember = cramMemberService.getData(cramMember);
		return "form";
	}
	
	 /**
	 * 修改會員資料
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException{
	
		cramMemberService.update(cramMember);
		return "index";
	}
	
	/**
	 * 刪除會員資料
	 * @return 
	 **/
	public String delete() throws IOException {

		for(int id : deleteList) {
			cramMember.setId(id);
			cramMember = cramMemberService.getData(cramMember);
			cramMemberService.delete(id);
		}
		return "index";		
	}
    
    /**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		cramMember = cramMemberService.getData(cramMember);
		return "view";
		
	}

	public CramMemberService getCramMemberService() {
		return cramMemberService;
	}

	public void setCramMemberService(CramMemberService cramMemberService) {
		this.cramMemberService = cramMemberService;
	}

	public int[] getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(int[] deleteList) {
		this.deleteList = deleteList;
	}

	public List<CramMember> getCramMemberList() {
		return cramMemberList;
	}

	public void setCramMemberList(List<CramMember> cramMemberList) {
		this.cramMemberList = cramMemberList;
	}

	public CramMember getCramMember() {
		return cramMember;
	}

	public void setCramMember(CramMember cramMember) {
		this.cramMember = cramMember;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
