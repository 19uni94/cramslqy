/**
 * List基本功能
 * @autohr Ken
 * @version 創建時間：2016-02-12
 */

$(function(){
	
	//搜尋
	searchQuery = function() {

		check = true;
		if (check) {
			$("#mainForm").submit();
		}
		
	},
	
	//修改排序
	updateSort = function(id) {
		
		$("#id").val(id);
		$("#sort").val($("#sort" + id).val());
		$("#mainForm").attr("action", "updateSort");
		$("#mainForm").submit();
		
	},
	
	//重新排序
	resetSort = function() {
		
		if(confirm("您是否要重新排序?")) {
			$("#mainForm").attr("action", "resetSort");
			$("#mainForm").submit();
		}
		
	},
	
	actionControl = function(action) {
		
		$("#mainForm").attr("action", action);
		$("#mainForm").submit();
		
	},
	
	//顯示控制
	displayControl = function(Obj, action) {
		
		if(action == "hide") {
			Obj.hide();
		} else {
			Obj.show();
		}
		
	}
	
	//刪除
	deleteData = function(msg) {
		
		if($("input[name='deleteList']:checked").length <= 0) {
			alert("請選擇要刪除的資料！");
			return false;
		}
		if(typeof(msg) == "undefined") {
			if(window.confirm("您真的確定要刪除嗎？")) {
				var frm = $("#mainForm").attr("action", "delete");
				frm.submit();
			}
		} else {
			if(window.confirm(msg)) {
				var frm = $("#mainForm").attr("action", "delete");
				frm.submit();
			}
		}
		
	}
	
	//全選
	var check = false;
	checkAll = function() {
		
		if(!check) {
			$(":checkbox[name='deleteList']").each(function() {
				this.checked = true;
			});
			check = true;
		} else {
			$(":checkbox[name='deleteList']").each(function() {
				this.checked = false;
			});
			check = false;
		}
		
	}
	
	
});