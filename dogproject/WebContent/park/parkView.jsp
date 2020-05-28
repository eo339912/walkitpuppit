<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>



<script> var tit01=" 산책로"</script>

<div id="sub_vis_wrap" class="sub04 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span>${park.spotnm}</span></br></br>
	<span>${park.sname}<script>document.write(tit01);</script></span>
</div> 

<div id="sub_content_wrap"  class="sub0401 inner">
	<div class="inner" style="margin-bottom:10em">
		<script src="http://foodfactory.webtro.kr/pg/js/viewimageresize.js"></script>
		
		<!-- 게시물 읽기 시작 { -->
		<input type="hidden" name="seq" value="${param.seq}">
		
		<article id="bo_v" style="width:100%">
		    <header>
		        <h2 id="bo_v_title">
		        	<span class="bo_v_tit">${param.spotnm}</span>
		        	
		        </h2>
		    </header>
		    
		   
		   <section id="bo_v_info">
		     
		    </section>
		 
		
		    <section id="bo_v_atc">
		        <h2 id="bo_v_atc_title">본문</h2>
		        <div id="bo_v_img"></div>
				${board.content}
		        <!-- 본문 내용 시작 { -->
		        <div id="bo_v_con">
		        	<p> 
		        		
		        		<div id="map" style="width: 1000px; height: 470px;"></div>
                     
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
		        
		       
	    	       <li><button type="button" onclick="countDog()" class="btn_b01 btn">입장하기</button></li>
	    	    
            </div>

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
		<form name="fviewcomment" id="fviewcomment" action="ParkcoInsert.do" onsubmit="return fviewcomment_submit(this);" method="post" autocomplete="off">
		    <span class="sound_only">내용</span>
		        <textarea id="contents" name="contents" maxlength="10000" required="" class="required" title="내용" placeholder="댓글내용을 입력해주세요"></textarea>
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