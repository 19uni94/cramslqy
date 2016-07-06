package com.tkb.elearning.action.admin;

import java.io.IOException;

import java.util.List;

import com.tkb.elearning.model.AllAssociation;
import com.tkb.elearning.model.Zone;
import com.tkb.elearning.service.AllAssociationService;
import com.tkb.elearning.service.ZoneService;
import com.tkb.elearning.util.VerifyBaseAction;

public class ZoneAction extends VerifyBaseAction {

private static final long serialVersionUID = 1L;
	
	private ZoneService zoneService;							//地區管理服務
	private AllAssociationService allAssociationService;		//各區協會服務
	private List<Zone> zoneList;								//地區管理清單
	private List<AllAssociation> allAssociationList;			//各區協會清單
	private Zone zone;											//地區管理資料
	private AllAssociation allAssociation;						//各區協會
	private int pageNo;											//頁碼
	private int[] deleteList;									//刪除的ID清單
	
	/**
	 * 清單頁面
	 * @return
	 */
	public String index() {
		
		if(zone == null) {
			zone = new Zone();
		}
		
		pageTotalCount = zoneService.getCount(zone);
		pageNo = super.pageSetting(pageNo);
		zoneList = zoneService.getList(pageCount, pageStart, zone);
		
		return "list";
		
	}
	
	/**
	 * 新增頁面
	 * @return
	 */
	public String add() {
		
		zone = new Zone();
		return "form";
		
	}
	
	/**
	 * 新增資料
	 * @return
	 * @throws IOException
	 */
	public String addSubmit() throws IOException {
					
		zoneService.add(zone);
		return "index";
		
	}
	
	/**
	 * 修改頁面
	 * @return
	 */
	public String update() {
		
		zone = zoneService.getData(zone);
		return "form";
		
	}
	/**
	 * 修改排序
	 * @return
	 */	
	public String updateSort() {
		
		zoneService.updateSort(zone);
		return "index";
		
	}
	
	/**
	 * 修改地區管理資料
	 * @return
	 * @throws IOException
	 */
	public String updateSubmit() throws IOException {
	
		zoneService.update(zone);
		return "index";
		
	}
	
	/**
	 * 刪除最新消息
	 * @return
	 */
	public String delete() throws IOException {

		for(int id : deleteList) {
			zone.setId(id);
			zone = zoneService.getData(zone);			
			zoneService.delete(id);
		}
		return "index";
		
	}
	
	/**
	 * 瀏覽頁面
	 * @return
	 */
	public String view(){
		
		zone = zoneService.getData(zone); 
			return	"view";
		
	}

	/**
	 * 修改排序最新消息
	 * @return
	 */
//	public String updateSort() {
//		zoneService.updateSort();
//		return "index";
//	}
	
	/**
	 * 檢查重複學校名稱
	 * @return
	 * @throws IOException 
	 */
	public void checkZonename() throws IOException {
		String zone_name = request.getParameter("zone_name");
		String msg = "";
		
		Zone zone = new Zone();
		zone.setZone_name(zone_name);
		String returnZonename = zoneService.checkZonename(zone);
		if(returnZonename == null) {
			msg = "true";
		} else {
			msg = "false";
		}
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(msg);
	}
	
	public void checkUsingZone() throws IOException {
		int zone_name = Integer.parseInt(request.getParameter("zone_name"));
		String checkmsg = "";
		Zone zone = new Zone();
		zone.setId(zone_name);
		zone=zoneService.getData(zone);
		AllAssociation allAssociation = new AllAssociation();
		allAssociation.setZone_name(zone.getZone_name());
		int returnZonename = allAssociationService.checkUsingZone(allAssociation);
		if(returnZonename == 0) {
			checkmsg = "true";
		} else {
			checkmsg = "false";
		}
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(checkmsg);
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
