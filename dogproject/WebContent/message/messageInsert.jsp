<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="쪽지보내기"</script>

<div id="sub_vis_wrap" class="sub04 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0401 inner">
	<div class="inner" style="margin-bottom:10em"><!-- skin : basic_voc -->
		<section id="bo_w">
	    <!-- 게시물 작성/수정 시작 { -->
		  	<form action="MessageInsert.do" method="post" name="fwrite" id="fwrite">
		  		  <input type="hidden" name="seq" value="" id="seq" class="frm_input required" >
		  		   <div class="bo_w_info write_div3">
			        <span>보내는사람</span>			 
		  			 <input type="text" name="userid" value="${loginId}" id="userid" class="frm_input required" readonly>
				</div>
				
			    <div class="bo_w_info write_div3">
			        <span>받는사람</span>
			        <input type="text" name="m_id" value="" id="m_id" required="" class="frm_input full_input required" size="50" maxlength="255" placeholder="받는사람">
				</div>
				
				<div class="bo_w_tit write_div bo_w_info write_div2">
					<span>제목</span>
            		<input type="text" name="title" value="" id="title" required="" class="frm_input full_input required" size="50" maxlength="255" placeholder="제목">
				</div>
				
				
				<div class="write_div  bo_w_info write_div2">
					<span>내용</span>
			        <div style="" class="wr_content">
						<textarea id="contents" name="contents" maxlength="65536" style="width: 100%; height: 300px;"></textarea>
		            </div>
			    </div>
			    
			 
		
			    <div class="btn_confirm write_div">
				        <input type="submit" value="보내기" id="btn_submit" class="btn_submit btn fr">
			    </div>
		    </form>
	
		</section>
		<!-- } 게시물 작성/수정 끝 -->
		</div>
</div>


<%@include file="/common/footer.jsp" %>