$(document).ready(function(){
	
	//設定頁面預設狀態	
	var num=0
	var clock
	$("#nav img:eq(0)").attr("src","../images/dot-green.png")

	//按鈕程式
	for(i=0;i<=9;i++){		
		$("#nav img:eq("+i+")").mouseover({id:i},function(e){
			num=e.data.id
			change()
			clearInterval(clock)
			clock=setInterval(auto,5000)
		})
	}
	
	//每格五秒自動換圖
	clock=setInterval(auto,5000)
	function auto(){
		num++
		if(num>9){
			num=0
		}
		change()
	}
	
	//大家共用的函數
	function change(){
		$("#nav img").attr("src","../images/dot-white.png")//div nav中所有圖變成白色
		$("#nav img:eq("+num+")").attr("src","../images/dot-green.png")//div nav中編號為num的圖變綠色
//		$("#banner img").stop()
//		$("#banner img").fadeOut(0,function(){//原圖消失後
//			$("#banner img").attr("src","${BASE_PATH}upload/image/banner/20160517161803000003.png")//換新圖
//			$("#banner img").fadeIn(400,function(){
//				$("#banner").css("background","url(${BASE_PATH}upload/image/banner/20160517161803000003.png")//換背景	
//			})//新圖出現
//		})	
	}	
	
})