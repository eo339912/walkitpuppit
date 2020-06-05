<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="마이페이지"</script>

<div id="sub_vis_wrap" class="sub03 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<%@include file="/common/sub_menu.jsp"%>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0301 inner">
	<div class="inner" style="margin-bottom:10em">
		<!-- section1_내정보Wrap-->
		<div class="mySec mySec1 fl">
			<!-- 내정보 -->
			<div class="myInfo">
				<div class="myImg fl" style="background:url(./upload/img/${member.thumd}) no-repeat 50% 50%; background-size:cover">
					
				</div>
				<div class="myContents fr" >
					<span>${member.name}</span>
					<button class="fr" onclick="location.href='MypageUpdateForm.do'">Edit</button>
				</div>
			</div>
			<!-- 내정보 버튼 wrap -->
			<div class="myBtnWrap">
				<div><a href="MymarketList.do?id=${loginId}">내가 쓴 글</a></div>
				<div><a href="MyreviewList.do?id=${loginId}">내가 쓴 후기글</a></div>
				<div><a href="MywalkTime.do?id=${loginId}">나의 산책 시간</a></div>
			</div>	
		</div><!-- sec1 -->
		<!-- section2_messegeWrap-->
		<div class="mySec mySec2 fr">
			<span class="myHeader">Message</span>
			<div class="myMessage">
			 <table style="text-align:center">
			        <caption>게시판 목록</caption>
			        		<div class="myhistory">
			<div class="myBtnWrap">
				<input type="hidden" name="seq" value="${param.seq}" id="seq" class="frm_input required" >
				<div><a href="GetMessage.do?id=${loginId}">받은쪽지함</a></div>
				<div><a href="SendMessage.do?id=${loginId}">보낸쪽지함</a></div>	
				<div><a onclick="OpenWindow('${loginId}')"><i class="fa fa-commenting-o" aria-hidden="true" style="font-size:30px"></i></a></div>			
							
			</div>
		</div>
	        </table>
			</div>
		</div><!-- sec2 -->
		<div class="clear"></div>
		

		<!-- section3_dogInfo-->
		<!-- <div class="mySec3 dogInfo">
			<span class="myHeader">강아지정보</span>
			<div class="dogInfoWrap">
				<ul>
					<li>					
						<div class="dogInfo">
							<div class="dogImg fl"><img src=""></div>
							<p class="pname">강아지이름<span>female</span></p>
						</div>
						<div class="dogInfo2">
							<span>강아지종 | 시츄</span>
							<span class="fr">Age | 3살</span>
						</div>
					</li>
				</ul>
			</div>
		</div> --><!-- sec3 -->
	</div><!-- inner -->
</div>
	<script>


function OpenWindow(userid, seq) { 
      window.open("MessageInsertForm2.do?userid=" + userid, "_blank","top=50,left=50,width=816,height=750,resizable=yes,scrollbars=no");
}

</script>
	

<%@include file="/common/footer.jsp" %>