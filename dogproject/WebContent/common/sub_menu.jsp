<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sub_menu_wrap sub_menu_pc">
	<div class="sub_menu_tit">
		<script>document.write(tit01);</script>
		<div class="btn"><span></span></div>
	</div>

	<ul class="sub_menu_box sub01 ">
         <li class="gnb_dp2"><a href="ParkList.do?spotnm=3470000">달서구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnm=3440000">남구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnm=3480000">달성군</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnm=3420000">동구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnm=3450000">북구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnm=3430000">서구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnm=3460000">수성구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnm=3410000">중구</a></li>
	</ul>

	<ul class="sub_menu_box sub02 ">
         <li class="gnb_dp2"><a href="MarketList.do">중고거래</a></li>
         <li class="gnb_dp2"><a href="FmarketList.do">무료나눔</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('process01')">후기게시판</a></li>
	</ul>

	<ul class="sub_menu_box sub03 ">
         <li class="gnb_dp2"><a href="javascript:GoPage('product01')">마이페이지</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('product01')">내 히스토리</a></li>
	</ul>

	<ul class="sub_menu_box sub04 ">
         <li class="gnb_dp2"><a href="BoardList.do">공지사항</a></li>
	</ul>
	
	<ul class="sub_menu_box sub05 ">
        <li class="gnb_dp2"><a href="MemberInsertForm.do">회원가입</a></li>
        <li class="gnb_dp2"><a href="MemberLoginForm.do">로그인</a></li>
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