
(function($){
	$(window).load(function(){
		$(".index_about_intro article").mCustomScrollbar({
			scrollButtons:{
				enable:true
			},
			scrollButtons:{ /*scroll buttons*/
				enable:false, /*scroll buttons support: boolean*/
				scrollType:"continuous", /*scroll buttons scrolling type: "continuous", "pixels"*/
				scrollSpeed:"auto", /*scroll buttons continuous scrolling speed: integer, "auto"*/
				scrollAmount:40 /*scroll buttons pixels scroll amount: integer (pixels)*/
			},
			autoHideScrollbar:true,
			theme:"dark-thin"
		});
	});
})(jQuery);