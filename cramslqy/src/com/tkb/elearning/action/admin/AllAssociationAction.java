package com.tkb.elearning.action.admin;

import java.io.IOException;

import java.util.List;

import com.tkb.elearning.model.AllAssociation;
import com.tkb.elearning.model.Zone;
import com.tkb.elearning.service.AllAssociationService;
import com.tkb.elearning.service.ZoneService;
import com.tkb.elearning.util.VerifyBaseAction;

/**
 * 各區協會資訊Dao實作類
 * @author Admin
 * @version 創建時間：2016-04-22
 */
public class AllAssociationAction extends VerifyBaseAction {
	

	private static final long serialVersionUID = 1L;
	
	private ZoneService zoneService;							//地區管理服務
	private AllAssociationService allAssociationService;		//各區協會資訊服務
	private List<Zone> zoneList;								//地區管理清單
	private List<AllAssociation> allAssociationList;			//各區協會資訊清單
	private Zone zone;											//地區管理資料
	private AllAssociation allAssociation;						//各區協會資訊資料
	private int pageNo;											//頁碼
	private int[] deleteList;									//刪除的ID清單
	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(allAssociation == null) {
			allAssociation = new AllAssociation();
		}
		
		pageTotalCount = allAssociationService.getCount(allAssociation);
		pageNo = super.pageSetting(pageNo);
		allAssociationList = allAssociationService.getList(pageCount, pageStart, allAssociation);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		allAssociation= new AllAssociation();
		zoneList = zoneService.getZoneList();
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
				
		if(zone == null){
			zone = new Zone();
		}
		
		zone.setZone_name(allAssociation.getZone_name());	
		allAssociationService.add(allAssociation);
		
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		allAssociation = allAssociationService.getData(allAssociation);
		zoneList=zoneService.getZoneList();
		return "form";
		
	}
	
	/**
	 * 修改最新消息
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException {
	
		allAssociationService.update(allAssociation);
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			allAssociation.setId(id);
			allAssociation = allAssociationService.getData(allAssociation);			
			allAssociationService.delete(id);
		}
		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		allAssociation=allAssociationService.getData(allAssociation);
		return "view";
		
	}
	
	public ZoneService getZoneService() {
		return zoneService;
	}

	public void setZoneService(ZoneService zoneService) {
		this.zoneService = zoneService;
	}

	public AllAssociationService getAllAssociationService() {
		return allAssociationService;
	}

	public void setAllAssociationService(AllAssociationService allAssociationService) {
		this.allAssociationService = allAssociationService;
	}

	public List<Zone> getZoneList() {
		return zoneList;
	}

	public void setZoneList(List<Zone> zoneList) {
		this.zoneList = zoneList;
	}

	public List<AllAssociation> getAllAssociationList() {
		return allAssociationList;
	}

	public void setAllAssociationList(List<AllAssociation> allAssociationList) {
		this.allAssociationList = allAssociationList;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public AllAssociation getAllAssociation() {
		return allAssociation;
	}

	public void setAllAssociation(AllAssociation allAssociation) {
		this.allAssociation = allAssociation;
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
