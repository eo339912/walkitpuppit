<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="내가 쓴 마켓글"</script>

<div id="sub_vis_wrap" class="sub03 page02">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0101 inner">
	<div class="inner" style="margin-bottom:10em">
				<!-- 내정보 버튼 wrap -->
		<div class="myhistory">
			<div class="myBtnWrap">
				<div class="active"><a href="MymarketList.do?id=${loginId}">내가 쓴 글</a></div>
				<div><a href="MyreviewList.do?id=${loginId}">내가 쓴 후기글</a></div>
				<div><a href="MywalkTime.do?id=${loginId}">나의 산책 시간</a></div>
			</div>
		</div>
		
		<!-- 게시판 목록 시작 { -->
		<div id="bo_list" style="width:100%" class="sub_board">
		    
		    <div class="tbl_head01 tbl_wrap">
		        <table style="text-align:center">
			        <caption>게시판 목록 </caption>
			        <thead>
			        <tr>
			            <th scope="col">구분</th>
			            <th scope="col">제목</th>
			            <th scope="col">판매상태</th>
			            <th scope="col">작성일자</th>
			        </tr>
			        </thead>
			        <tbody>
						<c:forEach items="${mymlist}" var="vo">
							<tr> 		
								<td>
									<c:if test="${vo.title != null}">
										<p class="disti" style="background: #4280f3;">중고</p>
									</c:if>
									<c:if test="${vo.ftitle != null}">
										<p class="disti" style="background: #89b8ff;">무료</p>
									</c:if>
								</td>			
								<td><a href="MarketViewForm.do?seq=${vo.seq}" class="bold" >${vo.title}${vo.ftitle}</a></td>
								<td><a>${vo.sselect}${vo.fsselect}</a></td>
								
								<fmt:parseDate value="${vo.regdt}${vo.fregdt}" var="sdate" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
            					<fmt:formatDate pattern="yyyy-MM-dd" value="${sdate}" var="bd"/>	
            					
            					<td class="td_datetime">${bd}</td>			
							</tr>
						</c:forEach>
			        </tbody>
		        </table>
		    </div>
		    </div> 			
		</div>
				
		<!-- } 게시판 목록 끝 -->
		</div>




<%@include file="/common/footer.jsp" %>