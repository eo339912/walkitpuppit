<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

    
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>

<script> var tit01="무료나눔"</script>

<div id="sub_vis_wrap" class="sub02 page02">
   <%@include file="/common/sub_vis.jsp"%>
   <jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
   <span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0202 inner">
   <div class="inner" style="margin-bottom:10em">
      <!-- 게시판 목록 시작 { -->
      <div id="bo_list" style="width:100%" class="sub_board">
        <!-- 게시판 검색 시작 { -->
          <fieldset id="bo_sch">
              <legend>게시물 검색</legend>      
              <form name="fsearch" method="get">
              <input type="text" name="stx" value="" required id="stx" class="sch_input" size="25" maxlength="20" placeholder="검색어를 입력해주세요">
              <button type="submit" value="검색" class="sch_btn"><i class="fa fa-search" aria-hidden="true"></i><span>검색</span></button>
              </form>
          </fieldset>
          <!-- } 게시판 검색 끝 -->  
      
          <div class="tbl_head01 tbl_wrap">
              <table>
                 <caption>게시판 목록</caption>
                 <thead>
                 <tr>
                     <th scope="col" width="15%">순번</th>
                     <th scope="col">제목</th>
                     <th scope="col" width="15%">글쓴이</th>
                     <th scope="col" width="15%">작성일자 <i class="fa fa-sort" aria-hidden="true"></i></th>
                 </tr>
                 </thead>
                 <tbody>
                 <c:forEach items="${market}" var="vo">
                    <tr>
                        <td class="td_num2">${((paging.page-1) * 5 + status.index+1)}</td>
                        <td class="td_subject" style="padding-left:0px">
                            <div class="bo_tit"><a href="${vo.seq}">${vo.ftitle}</a></div>
                     </td>
                        <td class="td_name sv_use"><span class="sv_member">${vo.id}</span></td>
                         <td class="td_datetime">${vo.fregdt}</td>
                         <c:if test="${loginId == 'admin'}">
										    <div class="btn_confirm write_div">
										    	<a href="MarketDelete.do?seq=${vo.seq}" id="btn_submit" class="btn_submit btn fr" style="margin-left: 10px;">글삭제</a>
											</div>
										</c:if>
				    
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
		    <a href="FmarketInsert.do" id="btn_submit" class="btn_submit btn fr" >글작성</a>
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