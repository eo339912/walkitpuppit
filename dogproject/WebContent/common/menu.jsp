<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="gnb_dp1_wrap">
   <!-- 산책로 -->
   <li class="gnb_dp1">
      <div><span>산책로</span></div>
      <ul class="gnb_dp2_wrap">
       <li class="gnb_dp2"><a href="ParkList.do?spotnum=3470000&m=01">달서구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnum=3440000&m=02">남구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnum=3480000&m=03">달성군</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnum=3420000&m=04">동구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnum=3450000&m=05">북구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnum=3430000&m=06">서구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnum=3460000&m=07">수성구</a></li>
         <li class="gnb_dp2"><a href="ParkList.do?spotnum=3410000&m=08">중구</a></li>
      </ul>
   </li>

   <!-- 퍼핏마켓 -->
   <li class="gnb_dp1">
      <div><span>퍼핏마켓</span></div>
      <ul class="gnb_dp2_wrap">
         <li class="gnb_dp2"><a href="MarketList.do">중고거래</a></li>
         <li class="gnb_dp2"><a  href="FmarketList.do">무료나눔</a></li>
         <li class="gnb_dp2"><a href="ReviewList.do">후기게시판</a></li>
      </ul>
   </li>
   
   <!-- 공지사항 -->
   <li class="gnb_dp1">
      <div><span>내 정보</span></div>
      <ul class="gnb_dp2_wrap">
         <li class="gnb_dp2"><a href="Mypage.do?id=${loginId}">마이페이지</a></li>
         <li class="gnb_dp2"><a href="MymarketList.do?id=${loginId}">내 히스토리</a></li>
      </ul>
   </li>

   <!-- 공지사항 -->
   <li class="gnb_dp1">
      <div><span>공지사항</span></div>
      <ul class="gnb_dp2_wrap">
         <li class="gnb_dp2"><a href="BoardList.do">공지사항</a></li>
      </ul>
   </li>


</ul>