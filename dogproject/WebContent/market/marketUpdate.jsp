<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="글쓰기"</script>

<div id="sub_vis_wrap" class="sub02 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0201 inner">
	<div class="inner" style="margin-bottom:10em"><!-- skin : basic_voc -->
				<section id="bo_w">
	    <!-- 게시물 작성/수정 시작 { -->
		  	<form action="MarketUpdate.do" method="post" name="fwrite" id="fwrite" enctype="multipart/form-data">
			    <div class="bo_w_info write_div3">
			        <span>아이디</span>
			        <input type="text" name="id" value="${loginId}" id="id" class="frm_input required" readonly>
				</div>
				
				<div class="bo_w_tit write_div bo_w_info write_div2">
					<span>제목</span>
            		<input type="text" name="title" value="${market.title}" id="title" required="" class="frm_input full_input required" size="50" maxlength="255" placeholder="제목">
				</div>
				
				<div class="bo_w_tit write_div bo_w_info write_div2">
				     <span>판매상태</span>
<div style="margin-top:11.5px; padding-bottom:15px; font-size:0.9em">
							 &nbsp;&nbsp;<input type="radio" value ="판매중" name="sselect" <c:if test="${fn:contains(market.sselect,'판매중')}">checked="checked"</c:if> class="frm_input2"/> 판매중  &nbsp;&nbsp;
							 &nbsp;&nbsp;<input type="radio" value ="판매완료" name="sselect" <c:if test="${fn:contains(market.sselect,'판매완료')}">checked="checked"</c:if> class="frm_input2"/> 판매완료
					</div>
				</div>
					
				<div class="bo_w_tit write_div bo_w_info write_div2">
				     <span>판매물품</span>
			<select name="sell"> 
			<option value="sell">==========선택=============</option>
			<option value="강아지  산책물품"
			<c:if test="${fn:contains(market.sell,'강아지 산책물품')}">selected="selected"</c:if>> 강아지  산책물품</option>
			<option value="강아지 옷"
			<c:if test="${fn:contains(market.sell,'강아지 옷')}">selected="selected"</c:if>> 강아지 옷  </option>
			<option value="강아지 생필품"
			<c:if test="${fn:contains(market.sell,'강아지 생필품')}">selected="selected"</c:if>> 강아지 생필품 </option>
			<option value="강아지  간식"
			<c:if test="${fn:contains(market.sell,'강아지  간식')}">selected="selected"</c:if>> 강아지  간식 </option>
			<option value="기타"
			<c:if test="${fn:contains(market.sell,'기타')}">selected="selected"</c:if>> 기타 </option>
			</select><br />
			
				</div>
				<div class="bo_w_tit write_div bo_w_info write_div2">
					<span>가격입력</span>
            		<input type="text" name="price" value="${market.price}" id="price" required="" class="frm_input full_input required" size="50" maxlength="255" placeholder="가격입력하세요">
				</div>
				
				<div class="write_div  bo_w_info write_div2">
					<span>내용</span>
			        <div style="" class="wr_content">
						<textarea id="content" name="content"  maxlength="65536" style="width: 100%; height: 300px;">${market.content}</textarea>
		            </div>
			    </div>
			    
			    
				<div class="clear"></div>
				<div class="wr_box_wrap">
					<span class="wr_t">첨부</span>
					<div class="wr_c">
		    		    <div class="bo_w_flie write_div">
			  				<div class="file_wr write_div">
								<label for="filename" class="lb_icon"><i class="fa fa-download" aria-hidden="true"></i></label>
								<input type="file" name="filename" id="filename" class="frm_file" value="${market.filename}">
			 				 </div>
						</div>
		    	  	</div>
				</div>
				<div class="clear"></div>
				
		
			    <div class="btn_confirm write_div">
				        <input type="submit" value="보내기" id="btn_submit" accesskey="s" class="btn_submit btn fr">
			    </div>
		    </form>
	
		</section>
		<!-- } 게시물 작성/수정 끝 -->
		</div>
</div>


<%@include file="/common/footer.jsp" %>