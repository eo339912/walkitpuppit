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
				<div class="myImg fl">
					<img src="./upload/img/${member.thumd}">
				</div>
				<div class="myContents fr" >
					<span>${member.name}</span>
					<button class="fr" onclick="location.href='MypageUpdateForm.do'">Edit</button>
				</div>
			</div>
			<!-- 내정보 버튼 wrap -->
			<div class="myBtnWrap">
				<div><a>내가 쓴 글</a></div>
				<div><a>내가 쓴 후기글</a></div>
				<div><a>공원 입장 시간</a></div>
			</div>	
		</div><!-- sec1 -->
		<!-- section2_messegeWrap-->
		<div class="mySec mySec2 fr">
			<span class="myHeader">Message</span>
			<div class="myMessage">
			 <table style="text-align:center">
			        <caption>게시판 목록</caption>
			        <thead>
			        <tr>
			            <th scope="col" width="20%">보낸사람</th>
			            <th scope="col">제목</th>
			            <th scope="col" width="30%">날짜  <i class="fa fa-sort" aria-hidden="true"></i></th>
			        </tr>
			        </thead>
			        <tbody>
			        	<c:forEach items="${message}" var="message"  varStatus="status">
							<tr>
					            <td class="td_subject" style="padding-left:0px">
				             	  	<div class="bo_tit">${message.userid}</div>
								</td>
				            	<td class="td_name sv_use"><span class="sv_member">
				            		<a onclick="OpenWindow(${message.seq})">${message.title}</a>
				            		</span></td>
				                
				                <fmt:parseDate value="${message.regdt}" var="sdate" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
            					<fmt:formatDate pattern="yyyy-MM-dd" value="${sdate}" var="bd"/>
				               
				                <td class="td_datetime">${bd}</td>
							</tr>
						</c:forEach>
			        </tbody>
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
function OpenWindow(seq) { 
      window.open("MessageViewForm.do?seq=" + seq, "_blank","top=50,left=50,width=816,height=750,resizable=yes,scrollbars=no");
}
</script>
	

<%@include file="/common/footer.jsp" %>