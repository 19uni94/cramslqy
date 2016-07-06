$(document).ready(function() {

	$(".navi_I > li:has(ul) > a").append('<div class="arrow-bottom"></div>');
	$(".navi_I > li ul li:has(ul) > a").append('<div class="arrow-right"></div>');
	
	$(".dropDown-1st").click(function() {
		$(this).next().slideToggle(300);
	});

	$('input[type="radio"]').parent("span").css({"float":"left"});
	$('input[type="checkbox"]').parent("span").css({"float":"left"});
	//navbar--------------------------------------------------------------
	$(".navi_II").hide();
	$(".fa-caret-right").parents("li").click(function() {
		$(".navi_I").hide();
		$(".navi_II").show();
	});
	$(".fa-caret-left").parents("li").click(function() {
		$(".navi_II").hide();
		$(".navi_I").show();
	});
	//showbox-------------------------------------------------------
	$(".fancybutton").click(function() {
		$("#fancyfunction").css({"top":"50%", "left":"50%","margin-top":"-200px","margin-left":"-240px"});
		$("#fancyfunction").show();
	});

	$(".closebtn").click(function() {
		$("#fancyfunction").hide();
	});
});