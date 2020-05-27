$(document).ready(function () {

	//resize
	$(window).resize(function(){
		var width = parseInt($(this).width()+17); //parseint는 정수로 하기 위함
		if(width <= 1000){
			$('.sub01 .sub_menu_box.sub01, .sub02 .sub_menu_box.sub02, .sub03 .sub_menu_box.sub03, .sub04 .sub_menu_box.sub04, .sub05 .sub_menu_box.sub05, .sub06 .sub_menu_box.sub06, .sub07 .sub_menu_box.sub07, .sub08 .sub_menu_box.sub08').css("display","none");
			$('#gnb_mo .gnb_dp1_wrap .gnb_dp1>div').click(function(){
				$('.gnb_dp2_wrap').slideUp();
				$(this).nextAll('.gnb_dp2_wrap').stop().slideToggle();
			});
		}else{
			$('.sub01 .sub_menu_box.sub01, .sub02 .sub_menu_box.sub02, .sub03 .sub_menu_box.sub03, .sub04 .sub_menu_box.sub04, .sub05 .sub_menu_box.sub05, .sub06 .sub_menu_box.sub06, .sub07 .sub_menu_box.sub07, .sub08 .sub_menu_box.sub08').css("display","block");
		}
	}).resize();
	
	$('#gnb_pc .gnb_dp1').hover(function(){
		$('#hd_wrap').addClass('open');
		$('#hd_wrap').addClass('on');
		$('#hd_wrap .gnb_dp2_wrap').stop().slideDown();
	},function(){
		$('#hd_wrap').removeClass('open');
		$('#hd_wrap').removeClass('on');
		$('#hd_wrap .gnb_dp2_wrap').stop().slideUp();
	});
	
	$('#hd_wrap .hd_full').click(function(){
		if($(this).hasClass('on')){
			$('#hd_wrap').removeClass('on');
			$(this).removeClass('on');
			$('#gnb_mo').stop().slideUp();
		}else{
			$(this).addClass('on');
			$('#hd_wrap').addClass('on');
			$('#gnb_mo').stop().slideDown();
		}
	});

});  
