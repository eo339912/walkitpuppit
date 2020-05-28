<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/common/header.jsp"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form name="fboardlist" id="fboardlist" action="./board_list_update.php" onsubmit="return fboardlist_submit(this);" method="post">
         
          </form>
           
             <!-- 게시판 검색 시작 { -->
          <fieldset id="bo_sch">
              <legend>게시물 검색</legend>      
              <form name="fsearch" method="get"><div align="center">	
<table border="1" >
	<tr><th>순번</th><th>아이디</th><th>제목</th><th>내용</th><th>사진</th><th>선택</th><th>날짜</th></tr>
	<c:forEach items="${list}" var="vo">
	<tr><td>${vo.seq} </td>
		<td>${vo.id}</td>
		<td>${vo.ftitle}</td>
		<td>${vo.fcontent}</td>
		<td>${vo.fpimage}</td>
		<td>${vo.fsselect}</td>
		<td>${vo.fregdt}</td>
		
	</c:forEach>
</table>
</div>
              <input type="text" name="stx" value="" required="" id="stx" class="sch_input" size="25" maxlength="20" placeholder="검색어를 입력해주세요">
              <button type="submit" value="검색" class="sch_btn"><i class="fa fa-search" aria-hidden="true"></i><span>검색</span></button>
              </form>
          </fieldset>
          <!-- } 게시판 검색 끝 -->   
      </div>
            
      <!-- } 게시판 목록 끝 -->
      </div>
</div>



<%@include file="/common/footer.jsp" %>