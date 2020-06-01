<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="${market.title}"</script>

<div id="sub_vis_wrap" class="sub02 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit02);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0401 inner">
	<div class="inner" style="margin-bottom:10em">
		<script src="http://foodfactory.webtro.kr/pg/js/viewimageresize.js"></script>
		
		<!-- 게시물 읽기 시작 { -->
		<input type="hidden" name="seq" value="${param.seq}">
		
		<article id="bo_v" style="width:100%">
		    <header>
		        <h2 id="bo_v_title">
		        	<span class="bo_v_tit">${market.title}</span>
		        	
		        </h2>
		    </header>
		    
		    <c:if test="${loginId == market.id}">
				    <div class="btn_confirm write_div">
				    	<a href="MarketDelete.do?seq=${param.seq}" id="btn_submit" class="btn_submit btn fr" style="margin-left: 10px;">글삭제</a>
					</div>
			</c:if>
		
		    <section id="bo_v_info">
		        <h2>페이지 정보</h2>
		        <span class="sound_only">작성자</span> <strong><span class="sv_member">${market.id}</span></strong>
		        <span class="sound_only">댓글</span><strong><a href="#bo_vc"> <i class="fa fa-commenting-o" aria-hidden="true"></i>0건</a></strong>
		        <span class="sound_only">조회</span><strong><i class="fa fa-eye" aria-hidden="true"></i> ${market.cnt}회</strong>
		        <span class="sound_only">판매물품: </span><strong>${market.fsell}헐</strong>
		        <span class="sound_only">가격:</span><strong> ${market.fprice}유</strong>
		        <strong class="if_date"><span class="sound_only">작성일</span><i class="fa fa-clock-o" aria-hidden="true"></i> ${market.regdt}</strong>
		    </section>
		
		    <section id="bo_v_atc">
		        <h2 id="bo_v_atc_title">본문</h2>
		        <div id="bo_v_img"></div>
				${market.content}
		        <!-- 본문 내용 시작 { -->
		        <div id="bo_v_con">
		        	<p>
		        		<img title=""  width="531"><br style="clear:both;">
		        		&nbsp;
		        	</p>
		        </div>
		         <!-- } 본문 내용 끝 -->
		    </section>
		
		    
		    
		    <!-- 게시물 상단 버튼 시작 { -->
		    <div id="bo_v_top">
		        <ul class="bo_v_left"></ul>
		        <ul class="bo_v_com">
	    	       <li><a href="MarkList.do" class="btn_b01 btn"><i class="fa fa-list" aria-hidden="true"></i> 목록</a></li>
	    	    </ul>
	            <!-- <ul class="bo_v_nb"><li class="btn_prv"><span class="nb_tit"><i class="fa fa-caret-up" aria-hidden="true"></i> 이전글</span><a href="./board.php?bo_table=comm01&amp;wr_id=133">[푸드팩토리] 코로나19 컵과일 후원_구미순천향병원_컵과일 700개</a> <span class="nb_date">20.03.20</span></li>
	         	   <li class="btn_next"><span class="nb_tit"><i class="fa fa-caret-down" aria-hidden="true"></i> 다음글</span><a href="./board.php?bo_table=comm01&amp;wr_id=131">[푸드팩토리] 코로나19 컵과일 후원_구미보건소_컵과일 100개</a>  <span class="nb_date">20.03.20</span></li>
	            </ul> -->
            </div>
		    <!-- } 게시물 상단 버튼 끝 -->
		

		<button type="button" class="cmt_btn"><i class="fa fa-commenting-o" aria-hidden="true"></i> 댓글목록</button>
		<!-- 댓글 시작 { -->
		<section id="bo_vc">
		    <h2>댓글목록</h2>
		        <p id="bo_vc_empty">등록된 댓글이 없습니다.</p>
		</section>
		<!-- } 댓글 끝 -->
		
		<!-- 댓글 쓰기 시작 { -->
		<aside id="bo_vc_w" class="bo_vc_w">
		    <h2>댓글쓰기</h2>
		<form name="fviewcomment" id="fviewcomment" action="" onsubmit="return fviewcomment_submit(this);" method="post" autocomplete="off">
		    <span class="sound_only">내용</span>
		        <textarea id="wr_content" name="wr_content" maxlength="10000" required="" class="required" title="내용" placeholder="댓글내용을 입력해주세요"></textarea>
		        <script>
				    $(document).on("keyup change", "textarea#wr_content[maxlength]", function() {
				        var str = $(this).val()
				        var mx = parseInt($(this).attr("maxlength"))
				        if (str.length > mx) {
				            $(this).val(str.substr(0, mx));
				            return false;
				        }
				    });
		    	</script>
		    <div class="bo_vc_w_wr">
		        <div class="btn_confirm">
		            <input type="submit" id="btn_submit" class="btn_submit" value="댓글등록">
		        </div>
		    </div>
		    </form></aside>
		
		<script>
		
		$(function() {            
		    //댓글열기
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