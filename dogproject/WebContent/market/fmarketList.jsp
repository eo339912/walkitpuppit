<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<<<<<<< HEAD
<script> var tit01="���ᳪ��"</script>
=======
<script> var tit02="무료나눔"</script>
>>>>>>> branch 'master' of https://github.com/eo339912/walkitpuppit.git

<div id="sub_vis_wrap" class="sub02 page01">
   <%@include file="/common/sub_vis.jsp"%>
   <jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
   <span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0201 inner">
   <div class="inner" style="margin-bottom:10em">
      <!-- 게시판 목록 시작 { -->
      <div id="bo_list" style="width:100%" class="sub_board">
        <form name="fboardlist" id="fboardlist" action="./board_list_update.php" onsubmit="return fboardlist_submit(this);" method="post">
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
                        <td class="td_num2"></td>
                        <td class="td_subject" style="padding-left:0px">
                            <div class="bo_tit"><a href="#">${vo.ftitle}</a></div>
                     </td>
                        <td class="td_name sv_use"><span class="sv_member">${vo.id}</span></td>
                         <td class="td_datetime">${vo.fregdt}</td>
                       </tr>
                       </c:forEach>
                 </tbody>
              </table>
          </div>
          </form>
           
             <!-- 게시판 검색 시작 { -->
          <fieldset id="bo_sch">
              <legend>게시물 검색</legend>      
              <form name="fsearch" method="get">
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