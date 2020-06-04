<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<!-- 게시판 목록 시작 { -->
		<div id="bo_list" style="width:100%" class="sub_board">
		    
		    <div class="tbl_head01 tbl_wrap">
		        <table style="text-align:center">
			        <caption>게시판 목록 </caption>
			        <thead>
			        <tr>
			            <th scope="col">제목</th>
			            <th scope="col">판매상태</th>
			            <th scope="col">작성일자</th>
			        </tr>
			        </thead>
			        <tbody>
						<c:forEach items="${mymlist}" var="vo">
							<tr> 					
								<td><a href="MarketViewForm.do?seq=${vo.seq}" class="bold" >${vo.title}${vo.ftitle}</a></td>
								<td><a>${vo.sselect}${vo.fsselect}</a></td>
								<td><a>${vo.regdt}${vo.fregdt}</a></td>						
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