<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

		<!-- 게시물 읽기 시작 { -->
		<article id="bo_v" style="width:100%">
		    <header>
		        <h2 id="bo_v_title">
		        	<span class="bo_v_tit">${board.title}</span>
		        </h2>
		    </header>
		    
		    <c:if test="${loginId == 'admin'}">
				<div class="btn_confirm write_div">
					<a href="BoardDelete.do?seq=${param.seq}" id="btn_submit" class="btn_submit btn fr" style="margin-left: 10px;">글삭제</a>
					<a href="BoardUpdateForm.do?seq=${param.seq}" id="btn_submit" class="btn_submit btn fr" style="margin-left: 10px;">글수정</a>
				</div>
			</c:if>
		
		    <section id="bo_v_info">
		        <h2>페이지 정보</h2>
		        <span class="sound_only">작성자</span> <strong><span class="sv_member">${board.id}</span></strong>
		        <span class="sound_only">댓글</span><strong><a href="#bo_vc"> <i class="fa fa-commenting-o" aria-hidden="true"></i>0건</a></strong>
		        <span class="sound_only">조회</span><strong><i class="fa fa-eye" aria-hidden="true"></i> ${board.cnt}회</strong>
		        <strong class="if_date"><span class="sound_only">작성일</span><i class="fa fa-clock-o" aria-hidden="true"></i> ${board.regdt}</strong>
		    </section>
		
		    <section id="bo_v_atc">
		        <h2 id="bo_v_atc_title">본문</h2>
		        <c:if test="${!board.filename.isEmpty() && board.filename != null}">
		        <div id="bo_v_img"><img src="./upload/img/${board.filename}"></div>
				</c:if>
				${board.content}
		    </section>
		    
		    <!-- 게시물 상단 버튼 시작 { -->
		    <div id="bo_v_top">
		        <ul class="bo_v_com">
	    	       <li><a href="BoardList.do" class="btn_b01 btn"><i class="fa fa-list" aria-hidden="true"></i> 목록</a></li>
	    	    </ul>
            </div>
		    <!-- } 게시물 상단 버튼 끝 -->

		<button type="button" class="cmt_btn"><i class="fa fa-commenting-o" aria-hidden="true"></i> 댓글목록</button>
		
		<!-- 댓글 시작 { -->   
		<section id="bo_vc">
			<h2>댓글목록</h2>
			<c:if test="${comments.isEmpty()}">
				<p id="bo_vc_empty">등록된 댓글이 없습니다.</p>		
			</c:if>
			<c:forEach items="${comments}" var="co">
			<article>
				<header style="z-index:2">
			    	<h2>${co.id}님의  댓글</h2>
			        <span class="guest">${co.id}</span>
			        <span class="sound_only">작성일</span>
			        <span class="bo_vc_hdinfo"><i class="fa fa-clock-o" aria-hidden="true"></i>
			        <time datetime="2020-05-29T11:32:00+09:00">${co.regdt}</time></span>
			    </header>
			
			<!-- 댓글 출력 -->
			<div class="cmt_contents">
				<p>${co.commentsO}</p>
				<c:if test="${loginId == co.id}">
			    <ul class="bo_vc_act">
					<li><a href="CommentsDelete.do?seq=${co.seq}&b_seq=${param.seq}" class="btn_b03">삭제</a></li>
				</ul>
				</c:if>
			</div>
			</article>
			</c:forEach>
		</section>
		<!-- } 댓글 끝 -->
		<!-- 댓글 쓰기 시작 { -->
		<aside id="bo_vc_w" class="bo_vc_w">
		    <h2>댓글쓰기</h2>
			<form name="fviewcomment" id="fviewcomment" action="BoardView.do?seq=${board.seq}" method="post">
			    <span class="sound_only">내용</span>
			        <textarea id="commentsO" name="commentsO" maxlength="10000" required class="required" title="내용" placeholder="댓글내용을 입력해주세요"></textarea>
			    <div class="bo_vc_w_wr">
			        <div class="btn_confirm">
			            <input type="submit" id="btn_submit" class="btn_submit" value="댓글등록">
			        </div>
			    </div>
			</form>
		</aside>
		
		<script>
		
		$(function() {            
		    /*댓글열기*/
		    $(".cmt_btn").click(function(){
		        $(this).toggleClass("cmt_btn_op");
		        $("#bo_vc").toggle();
		    });
		});
		</script>
		<!-- } 댓글 쓰기 끝 -->
		
		</article>
		<!-- } 게시판 읽기 끝 -->
		
		
	</div>
</div>



<%@include file="/common/footer.jsp" %>