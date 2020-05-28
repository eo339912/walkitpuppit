<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="공지사항"</script>

<div id="sub_vis_wrap" class="sub04 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0401 inner">
	<div class="inner" style="margin-bottom:10em">
		<!-- 게시판 목록 시작 { -->
		<div id="bo_list" style="width:100%" class="sub_board">
			
			<!-- 게시판 검색 시작 { -->
		    <fieldset id="bo_sch">
		        <legend>게시물 검색</legend>		
		        <form name="searchfrm" method="get">
		        	<input name="p" value="1" type="hidden">
		        	<input type="text" name="title" value="" id="title" class="sch_input" size="25" maxlength="20" placeholder="제목을 입력해주세요">
		       		<button type="submit" value="검색" class="sch_btn"><i class="fa fa-search" aria-hidden="true"></i><span>검색</span></button>
		        </form>
		    </fieldset>
		    <!-- } 게시판 검색 끝 -->  
		
	
		    <div class="tbl_head01 tbl_wrap">
		        <table style="text-align:center">
			        <caption>게시판 목록</caption>
			        <thead>
			        <tr>
			            <th scope="col" width="15%">번호</th>
			            <th scope="col">제목</th>
			            <th scope="col" width="15%">글쓴이</th>
			            <th scope="col" width="15%">날짜  <i class="fa fa-sort" aria-hidden="true"></i></th>
			        </tr>
			        </thead>
			        <tbody>
			        	<c:forEach items="${board}" var="vo"  varStatus="status">
							<tr>
								<td class="td_num2"> ${((paging.page-1) * 5 + status.index+1)}</td>
					            <td class="td_subject" style="padding-left:0px">
				             	  	<div class="bo_tit">
				             	  		<a href="BoardView.do?seq=${vo.seq}">${vo.title}</a>
				             	  		<c:if test="${loginId == 'admin'}">
										    <div class="btn_confirm write_div">
										    	<a href="${pageContext.request.contextPath}/BoardDelete.do?seq=${vo.seq}" id="btn_submit" class="btn_submit btn fr" style="margin-left: 10px;">글삭제</a>
											</div>
										</c:if>
				             	  	</div>
								</td>
				            	<td class="td_name sv_use"><span class="sv_member">${vo.id}</span></td>
				                
				                <fmt:parseDate value="${vo.regdt}" var="sdate" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
            					<fmt:formatDate pattern="yyyy-MM-dd" value="${sdate}" var="bd"/>
				                
				                <td class="td_datetime">${bd}</td>
							</tr>
						</c:forEach>
			        </tbody>
		        </table>
		    </div>
		    
		    <c:if test="${loginId == 'admin'}">
		    <div class="btn_confirm write_div">
		    	<a href="${pageContext.request.contextPath}/BoardInsert.do" id="btn_submit" class="btn_submit btn fr" >글작성</a>
			</div>
			</c:if>
			
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