<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit02="무료나눔"</script>

<div id="sub_vis_wrap" class="sub02 page02">
   <%@include file="/common/sub_vis.jsp"%>
   <jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
   <span><script>document.write(tit02);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0202 inner">
   <div class="inner" style="margin-bottom:10em">
      <!-- 게시판 목록 시작 { -->
      <div id="bo_list" style="width:100%" class="sub_board">
       <!-- 게시판 검색 시작 { -->
          <fieldset id="bo_sch">
              <legend>게시물 검색</legend>      
              <form name="fsearch" method="get">
              <input name="p" value="1" type="hidden">
              <input type="text" name="id" value="" required="" id="id" class="sch_input" size="25" maxlength="20" placeholder="검색어를 입력해주세요">
              <button type="submit" value="검색" class="sch_btn"><i class="fa fa-search" aria-hidden="true"></i><span></span></button>
              </form>
          </fieldset>
          <!-- } 게시판 검색 끝 -->   
          <div class="tbl_head01 tbl_wrap">
              <table style="text-align:center;">
                 <caption>게시판 목록</caption>
                 <thead>
                 <tr>
                     <th scope="col" width="15%">순번</th>
                     <th scope="col" width="15%">상품</th>
                     <th scope="col">제목</th>
                     <th scope="col"  width="8%">상태</th>
                     <th scope="col" width="15%">글쓴이</th>
                     <th scope="col" width="20%">작성일자 <i class="fa fa-sort" aria-hidden="true"></i></th>
                 </tr>
                 </thead>
                 <tbody>
                 <c:forEach items="${list}" var="vo" varStatus="status">
                    <tr>
                       <td class="td_num2">${((paging.page-1) * 5 + status.index+1)}</td>
                          <td>
                        	<c:if test="${!vo.filename.isEmpty() && vo.filename != null}">
					       	 <div id="bo_v_img"><img src="./upload/img/${vo.filename}"></div>
					</c:if>
                        </td>
                        <td class="td_subject" style="padding-left:0px; position:relative">
                        <div class="bo_tit" style="display: inline;"><a href="FmarketViewForm.do?seq=${vo.seq}">${vo.ftitle}</a></div>
                            
                            <c:if test="${loginId == vo.id}">
										    <div class="btn_confirm write_div" style="display: inline;">
										    	<a href="MarketDelete.do?seq=${vo.seq}" id="btn_submit" class="btn_submit btn fr"  style="position: absolute;right: 0;"><i class="fa fa-trash" aria-hidden="true"></i></a>
											</div>
											</c:if>
                     </td>
                        <td><div class="bo_tit">
<<<<<<< HEAD
								<c:if test="${vo.fsselect == '판매중'}">
									<p class="disti" style="background-color:#4280f3;">판매중</p>
								</c:if>
								<c:if test="${vo.fsselect == '판매완료'}">
									<p class="disti" style="background-color:#89b8ff;">판매완료</p>
								</c:if>
=======
									<c:if test="${vo.fsselect == '나눔중'}">
										<p class="disti" style="background: #d0dce5;">나눔중</p>
									</c:if>
									<c:if test="${vo.fsselect == '나눔완료'}">
										<p class="disti" style="background: #9fbaca;">나눔완료</p>
									</c:if>
>>>>>>> branch 'master' of https://github.com/eo339912/walkitpuppit.git
                        </div></td>
                        <td class="td_name sv_use"><span class="sv_member">${vo.id}</span></td>
                         <td class="td_datetime">${vo.fregdt}</td>
                       </tr>
                       </c:forEach>
                 </tbody>
              </table>
              
          </div>
          <ul class="btn_confirm write_div">
    	    <li class="btn_submit btn fr"><a href="FmarketInsertForm.do"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 글쓰기</a></li>
			</ul>
 		<script>
				function gopage(p){
					document.fsearch.p.value = p;
					document.fsearch.submit();
				}
			</script>
			<my:paging paging="${paging}" jsfunc="gopage"></my:paging>
      </div>
            
      <!-- } 게시판 목록 끝 -->
      </div>
</div>



<%@include file="/common/footer.jsp" %>