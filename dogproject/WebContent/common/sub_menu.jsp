<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sub_menu_wrap sub_menu_pc">
	<div class="sub_menu_tit">
		<script>document.write(tit01);</script>
		<div class="btn"><span></span></div>
	</div>

	<ul class="sub_menu_box sub01 ">
         <li class="gnb_dp2 m1"><a href="ParkList.do?spotnum=3470000&m=01">달서구</a></li>
         <li class="gnb_dp2 m2"><a href="ParkList.do?spotnum=3440000&m=02">남구</a></li>
         <li class="gnb_dp2 m3"><a href="ParkList.do?spotnum=3480000&m=03">달성군</a></li>
         <li class="gnb_dp2 m4"><a href="ParkList.do?spotnum=3420000&m=04">동구</a></li>
         <li class="gnb_dp2 m5"><a href="ParkList.do?spotnum=3450000&m=05">북구</a></li>
         <li class="gnb_dp2 m6"><a href="ParkList.do?spotnum=3430000&m=06">서구</a></li>
         <li class="gnb_dp2 m7"><a href="ParkList.do?spotnum=3460000&m=07">수성구</a></li>
         <li class="gnb_dp2 m8"><a href="ParkList.do?spotnum=3410000&m=08">중구</a></li>
	</ul>

	<ul class="sub_menu_box sub02 ">
         <li class="gnb_dp2 m1"><a href="MarketList.do">중고거래</a></li>
         <li class="gnb_dp2 m2"><a href="FmarketList.do">무료나눔</a></li>
         <li class="gnb_dp2 m3"><a href="ReviewList.do">후기게시판</a></li>
	</ul>

	<ul class="sub_menu_box sub03 ">
         <li class="gnb_dp2 m1"><a href="Mypage.do?id=${loginId}">마이페이지</a></li>
         <li class="gnb_dp2 m2"><a href="Myhistory.do?id=${loginId}">내 히스토리</a></li>
	</ul>

	<ul class="sub_menu_box sub04 ">
         <li class="gnb_dp2 m1"><a href="BoardList.do">공지사항</a></li>
	</ul>
	
	<ul class="sub_menu_box sub05 ">
        <li class="gnb_dp2 m1"><a href="MemberInsertForm.do">회원가입</a></li>
        <li class="gnb_dp2 m2"><a href="MemberLoginForm.do">로그인</a></li>
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