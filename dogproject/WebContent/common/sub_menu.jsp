<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="sub_menu_wrap sub_menu_pc">
	<div class="sub_menu_tit">
		<script>document.write(tit01);</script>
		<div class="btn"><span></span></div>
	</div>

	<ul class="sub_menu_box sub01 ">
		<li class="m1"><a href="javascript:GoPage('intro01')">인사말</a></li>
		<!-- <li class="m2"><a href="javascript:GoPage('intro02')">개요</a></li> -->
		<li class="m2"><a href="javascript:GoPage('intro03')">연혁</a></li>
		<li class="m3"><a href="javascript:GoPage('intro04')">CI소개</a></li>
		<li class="m4"><a href="javascript:GoPage('intro05')">인증서</a></li>
		<li class="m5"><a href="javascript:GoPage('intro06')">주요거래처</a></li>
		<li class="m6"><a href="javascript:GoPage('intro07')">오시는 길</a></li>
	</ul>

	<ul class="sub_menu_box sub02 ">
		<li class="m1"><a href="javascript:GoPage('process01')">원물관리</a></li>
		<li class="m2"><a href="javascript:GoPage('process02')">제조관리</a></li>
	</ul>

	<ul class="sub_menu_box sub03 ">
		<li class="m1"><a href="javascript:GoPage('product01')">소용량 컵과일</a></li>
		<li class="m2"><a href="javascript:GoPage('product02')">중용량 컵과일</a></li>
		<li class="m3"><a href="javascript:GoPage('product03')">대용량 컵과일</a></li>
	</ul>

	<ul class="sub_menu_box sub04 ">
		<li class="m1"><a href="javascript:GoPage('cs01')">공지사항</a></li>
		<li class="m2"><a href="javascript:GoPage('cs02')">언론보도</a></li>
		<li class="m3"><a href="javascript:GoPage('cs03')">고객문의</a></li>
		<li class="m4"><a href="javascript:GoPage('cs04')">주문ERP</a></li>
	</ul>

	<ul class="sub_menu_box sub05 ">
		<li class="m1"><a href="javascript:GoPage('mem01')">개인정보처리방침</a></li>
		<li class="m2"><a href="javascript:GoPage('mem02')">이메일무단수집거부</a></li>
	</ul>
</div>


<script>
	$(document).ready(function(){
		$('.sub_menu_tit').click(function(){
			$('.sub01 .sub_menu_box.sub01, .sub02 .sub_menu_box.sub02, .sub03 .sub_menu_box.sub03, .sub04 .sub_menu_box.sub04, .sub05 .sub_menu_box.sub05, .sub06 .sub_menu_box.sub06, .sub07 .sub_menu_box.sub07, .sub08 .sub_menu_box.sub08').slideToggle(200);
			if($(this).hasClass('on')){
				$(this).removeClass('on');
			}else{
				$(this).addClass('on');
			}	
		});
	});
</script>