<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>



<script> var tit01=" 산책로"</script>

<div id="sub_vis_wrap" class="sub01 page01">
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
		    <header>
		        <h2 id="bo_v_title">
		        	<span class="bo_v_tit">${park.spotnm} ${park.sname} <script>document.write(tit01);</script></span>
		        	
		        </h2>
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

		    <div class="bo_vc_w_wr">
		       <ul class="bo_ul_san">
		       
		       		<c:if test="${walk.seq != null && walk.incheck == 1}">
	    	       		<li><a href="ParkWalkOut.do?seq=${walk.seq}&p_seq=${param.seq}" onclick="delchk();">퇴장하기</a></li>
	    	       	</c:if>
	    	       	

					<c:if test="${walk.seq == null || walk.incheck == 0}">
		    	       <li><a href="ParkWalkIn.do?p_seq=${param.seq}" onclick="delchk2();">입장하기</a></li>
		       		</c:if>
	    	    </ul>
            </div>
			<script type="text/javascript">
						function delchk(){
       						return confirm("퇴장하시겠습니까?");
					}
						
						function delchk2(){
   							return confirm("배변봉투 준비 하셨나요 ?\n*애완동물 오물 미처리 시 10만원 과태료 부과* \n \n 목줄 착용 하셨나요?\n *1차 20만원, 2차 30만원, 3차 50만원 과태료 부과*\n\n");
				}
					</script>
					
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