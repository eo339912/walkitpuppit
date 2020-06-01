<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="산책로"</script>

<div id="sub_vis_wrap" class="sub01 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span>
		<c:forEach items="${park}" end="0" var="vo">
			${vo.spotnm}
		</c:forEach>
		<script>document.write(tit01);</script>
	</span>
</div>

<div id="sub_content_wrap"  class="sub0101 inner">
	<div class="inner" style="margin-bottom:10em">
		<!-- 게시판 목록 시작 { -->
		<div id="bo_list" style="width:100%" class="sub_board">
		  <!-- 게시판 검색 시작 { -->
		    <fieldset id="bo_sch">
		        <legend>게시물 검색</legend>		
		        <form name="searchfrm" method="get">
		        	<input name="p" value="1" type="hidden">
		        	<input name="spotnum" value="${param.spotnum}" type="hidden">
		        	<input name="sname2" value="${param.sname}" type="hidden">
		        	<input type="text" name="sname" value="" id="sname" class="sch_input" size="25" maxlength="20" placeholder="장소를 입력해주세요">
		       		<button type="submit" value="검색" class="sch_btn"><i class="fa fa-search" aria-hidden="true"></i><span>검색</span></button>
		        </form>
		    </fieldset>
		    <!-- } 게시판 검색 끝 -->  
		    <div class="tbl_head01 tbl_wrap">
		    
			
		    
		        <table>
			        <caption>게시판 목록 </caption>
			        <thead>
			        <tr>
			            <th scope="col">공원이름</th>
			            <th scope="col">산책중인 강아지(수)</th>
			        </tr>
			        </thead>
			        <tbody>
						<c:forEach items="${park}" var="vo">
							<tr> 
						
								<td><a href="ParkViewForm.do?seq=${vo.seq}">${vo.sname}</a></td>
								<td><a href="#">${vo.senter}</a>
								
							</tr>
						</c:forEach>
			        </tbody>
		        </table>
		    </div>
		     
		     <script>
				function gopage(p){
					document.searchfrm.p.value = p;
					document.searchfrm.submit();
				}
			</script>
			<my:paging paging="${paging}" jsfunc="gopage"></my:paging>
			
		    
		</div>
				
		<!-- } 게시판 목록 끝 -->
		</div>
</div>



<%@include file="/common/footer.jsp" %>