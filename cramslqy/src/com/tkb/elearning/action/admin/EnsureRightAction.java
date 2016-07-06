package com.tkb.elearning.action.admin;

import java.io.IOException;
import java.util.List;

import com.tkb.elearning.model.EnsureRight;
import com.tkb.elearning.service.EnsureRightService;
import com.tkb.elearning.util.VerifyBaseAction;

public class EnsureRightAction extends VerifyBaseAction {

		private static final long serialVersionUID = 1L;
		
		private EnsureRightService ensureRightService;		//品保權益服務
		private List<EnsureRight> ensureRightList;			//品保權益清單
		private EnsureRight ensureRight;					//品保權益資料
		private int pageNo;									//頁碼
		private int[] deleteList;							//刪除的ID清單

		
		/**
		 * 清單頁面
		 * @return
		 */
		public String index() {
			
			if(ensureRight == null) {
				ensureRight = new EnsureRight();
			}
			
			pageTotalCount = ensureRightService.getCount(ensureRight);
			pageNo = super.pageSetting(pageNo);
			ensureRightList = ensureRightService.getList(pageCount, pageStart, ensureRight);
			
			return "list";
			
		}
		
		/**
		 * 新增頁面
		 * @return
		 */
		public String add() {
			
			ensureRight = new EnsureRight();
			return "form";
			
		}
		
		/**
		 * 新增資料
		 * @return
		 * @throws IOException
		 */
		public String addSubmit() throws IOException {
			
			
			ensureRightService.add(ensureRight);
			return "index";
			
		}
		
		/**
		 * 修改頁面
		 * @return
		 */
		public String update() {
			
			ensureRight = ensureRightService.getData(ensureRight);
			return "form";
			
		}
		
		 /**
		 * 修改最新消息
		 * @return
		 * @throws IOException
		 */
		public String updateSubmit() throws IOException {
			

			ensureRightService.update(ensureRight);
			return "index";
			
		}
		
		/**
		 * 刪除最新消息
		 * @return
		 */
		public String delete() throws IOException {

			for(int id : deleteList) {
				ensureRight.setId(id);
				ensureRight = ensureRightService.getData(ensureRight);
				ensureRightService.delete(id);
			}
			return "index";
			
		}
		
		/**
		 * 瀏覽頁面
		 * @return
		 */
		public String view(){
			
			ensureRight=ensureRightService.getData(ensureRight);
			System.out.println(ensureRight.getId());
			return "view";
			
		}

		public EnsureRightService getEnsureRightService() {
			return ensureRightService;
		}

		public void setEnsureRightService(EnsureRightService ensureRightService) {
			this.ensureRightService = ensureRightService;
		}

		public List<EnsureRight> getEnsureRightList() {
			return ensureRightList;
		}

		public void setEnsureRightList(List<EnsureRight> ensureRightList) {
			this.ensureRightList = ensureRightList;
		}

		public EnsureRight getEnsureRight() {
			return ensureRight;
		}

		public void setEnsureRight(EnsureRight ensureRight) {
			this.ensureRight = ensureRight;
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
