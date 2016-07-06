package com.tkb.elearning.action.admin;

import java.io.IOException;
import java.util.List;

import com.tkb.elearning.model.Ensuredo;
import com.tkb.elearning.service.EnsuredoService;
import com.tkb.elearning.util.VerifyBaseAction;


public class EnsuredoAction extends VerifyBaseAction {

	private static final long serialVersionUID = 1L;
	
	private EnsuredoService ensuredoService;	//最新消息服務
	private List<Ensuredo> ensuredoList;		//最新消息清單
	private Ensuredo ensuredo;					//最新消息資料
	private int pageNo;							//頁碼
	private int[] deleteList;					//刪除的ID清單

	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(ensuredo == null) {
			ensuredo = new Ensuredo();
		}
		
		pageTotalCount = ensuredoService.getCount(ensuredo);
		pageNo = super.pageSetting(pageNo);
		ensuredoList = ensuredoService.getList(pageCount, pageStart, ensuredo);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		ensuredo = new Ensuredo();
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
		
		
		ensuredoService.add(ensuredo);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		ensuredo = ensuredoService.getData(ensuredo);
		return "form";
		
	}
	
	 /**
	 * 修改最新消息
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException {
		

		ensuredoService.update(ensuredo);
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			ensuredo.setId(id);
			ensuredo = ensuredoService.getData(ensuredo);
			ensuredoService.delete(id);
		}
		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		ensuredo=ensuredoService.getData(ensuredo);
		System.out.println(ensuredo.getId());
		return "view";
		
	}

	public EnsuredoService getEnsuredoService() {
		return ensuredoService;
	}

	public void setEnsuredoService(EnsuredoService ensuredoService) {
		this.ensuredoService = ensuredoService;
	}

	public List<Ensuredo> getEnsuredoList() {
		return ensuredoList;
	}

	public void setEnsuredoList(List<Ensuredo> ensuredoList) {
		this.ensuredoList = ensuredoList;
	}

	public Ensuredo getEnsuredo() {
		return ensuredo;
	}

	public void setEnsuredo(Ensuredo ensuredo) {
		this.ensuredo = ensuredo;
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