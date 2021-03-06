<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>



<script> var tit01=" 산책로"</script>

<div id="sub_vis_wrap" class="sub01 page${param.m}">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	
	<span><script>document.write(tit01);</script></span>
</div> 

<div id="sub_content_wrap"  class="sub0101 inner">
	<div class="inner" style="margin-bottom:10em">
		
		<!-- 게시물 읽기 시작 { -->
		<input type="hidden" name="seq" value="${param.seq}">
		
		<article id="bo_v" style="width:100%">
		    <header class="oh">
		        <h2 id="bo_v_title" class="fl">
		        	<span class="bo_v_tit">${park.spotnm} ${park.sname} <script>document.write(tit01);</script></span>
		        	
		        </h2>
		        
		     <div class="bo_vc_w_wr fr" style="margin-top: 39px;">
		       <ul class="bo_ul_san">
		       
		       		<c:if test="${walk.seq == null || walk.incheck == 0}">
		    	       <li><button type="button"  onclick="crayBtn1()" class="btn_b01 btn btn_add">입장하기</button></li>
		       		</c:if>
		       		<c:if test="${walk.seq != null && walk.incheck == 1}">
	    	       		<li><button type="button" onclick="location.href='ParkWalkOut.do?seq=${walk.seq}&p_seq=${param.seq}'" class="btn_b01 btn btn_add">퇴장하기</button></li>
	    	       	</c:if>
	    	    </ul>
            </div>
		    </header>
		    
		   
		   <section id="bo_v_info">
		     
		    </section>
		 
		
		    <section id="bo_v_atc">
		        <h2 id="bo_v_atc_title">본문</h2>
		       
		        <!-- 본문 내용 시작 { -->
		        <div id="bo_v_con">
		        	<p> 
		        		
		        		<div id="map" style="width: 100%; height: 470px;"></div>
                     
                     <script>
                     
                     function initMap() {
                     
                     var cairo = {lat: ${park.x}, lng: ${park.y}};
                     
                     var map = new google.maps.Map(document.getElementById('map'), {
                     
                     scaleControl: true,
                     
                     center: cairo,
                     
                     zoom: 15
                     
                     });
                     
                     var infowindow = new google.maps.InfoWindow;
                     
                     infowindow.setContent('<b>${park.sname}</b>');
                     
                     var marker = new google.maps.Marker({map: map, position: cairo});
                     
                     marker.addListener('click', function() {
                     
                     infowindow.open(map, marker);
                     
                     });
                     
                     }
                     
                     </script>
                     
                     <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBvylOLIuXFq3ovvcf-fqz--LNjKErfDVc&language=kor&callback=initMap"></script>
                        
		        		${park.sname}
		        	</p>
		        </div>
		         <!-- } 본문 내용 끝 -->
		    </section>
		
		<button type="button" class="cmt_btn"><i class="fa fa-commenting-o" aria-hidden="true"></i> 댓글목록</button>
		
				<!-- 댓글 시작 { -->   
		<section id="bo_vc">
			<h2>댓글목록</h2>
			<c:if test="${parkco.isEmpty()}">
				<p id="bo_vc_empty">등록된 댓글이 없습니다.</p>		
			</c:if>
			<c:forEach items="${parkco}" var="co">
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
				<p>${co.comments}</p>
				<c:if test="${loginId == co.id}">
			    <ul class="bo_vc_act">
					<li><a href="ParkcoDelete.do?seq=${co.seq}&pseq=${param.seq}" class="btn_b03">삭제</a></li>
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
			<form name="fviewcomment" id="fviewcomment" action="ParkView.do?seq=${park.seq}" method="post">
			    <span class="sound_only">내용</span>
			        <textarea id="comments" name="comments" maxlength="10000" required class="required" title="내용" placeholder="댓글내용을 입력해주세요"></textarea>
			    <div class="bo_vc_w_wr">
			        <div class="btn_confirm">
			            <input type="submit" id="btn_submit" class="btn_submit" value="댓글등록">
			        </div>
			    </div>
			</form>
		</aside>
		
		<div id="dialog-message" title="잠깐! 펫티켓 챙기셨나요?" style='display:none'>
		 	<p style="font-size:20px; font-weight:bold">① 반려견과 외출할 때에는 목줄·인식표를 착용해주세요!</p>
			※ 위반 시 과태료 : 1차 위반 20만원 / 2차 30만원 / 3차 50만원<br>
			<span style="font-size:15px;">
			목줄 등 안전조치를 위반하여 사람의 신체에 상해를 이르게 한 자 : 2년 이하의 징역 또는 2천만원 이하의 벌금<br>
			목줄 등 안전조치를 위반하여 사람을 사망에 이르게 한 자 : 3년 이하의 징역 또는 3천만원 이하의 벌금
			</span>
		<br><br>
			<p style="font-size:20px; font-weight:bold">② 쾌적한 산책문화를 위해 외출 시에는 배변봉투를 꼭 챙겨주세요!</p>
			※ 미수거 시 과태료 : 1차 위반 5만원 / 2차 7만원 / 3차 10만원
		</div>
		
		<script>
		function crayBtn1()
		{
			$('#dialog-message').dialog({
				modal: true, 
				buttons: {
					"입장하기": function() { $(this).dialog('close'); location.href='ParkWalkIn.do?p_seq=${param.seq}&sname=${park.sname}'},
					"취소": function() { $(this).dialog('close'); },
				}
			});
		}
		</script>
		
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