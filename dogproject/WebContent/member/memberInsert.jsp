<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="회원가입"</script>

<div id="sub_vis_wrap" class="sub05 page01">
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
		  	<form action="${pageContext.request.contextPath}/MemberInsert.do" method="post" name="fwrite" id="fwrite">
			    <div class="bo_w_info write_div3 half">
			        <span>아이디</span>
			        <input type="text" name="id" value="" id="id" required="" class="frm_input required" placeholder="아이디">
				</div>
				<div class="bo_w_info write_div3 half">
			        <span>비밀번호</span>
			        <input type="password" name="pwd" id="pwd" required="" class="frm_input required" placeholder="비밀번호">
				</div>
				    		
				<div class="bo_w_info write_div3 half">
			            <span>회원이름</span>
			            <input type="text" name="name" value="" id="name" class="frm_input required" required="" placeholder="회원이름">
			    </div>
				    
				<div class="bo_w_info write_div2 half">
					<span>강아지 이름</span><input type="text" name="pname" value="" id="pname" class="frm_input required" required="" placeholder="강아지 이름">
				</div>
				
				<div class="bo_w_info write_div3 half">
			            <span>강아지 생일</span>
			            <input type="text" name="pbirth" value="" id="pbirth" class="frm_input required" required="" placeholder="강아지생일">
			    </div>
				    
				<div class="bo_w_info write_div2 half">
					<span>강아지 성별</span>
					<div style="margin-top:11.5px; padding-bottom:15px; font-size:0.9em">
							 &nbsp;&nbsp;<input type="radio" value ="f" name="pgender" class="frm_input2"/> 딸내미  &nbsp;&nbsp;
							 &nbsp;&nbsp;<input type="radio" value ="m" name="pgender" class="frm_input2"/> 아들내미
					</div>
					
				</div>
				
				<div class="clear"></div>
				<div class="wr_box_wrap">
					<span class="wr_t">강아지 사진</span>
					<div class="wr_c">
		    		    <div class="bo_w_flie write_div">
			  				<div class="file_wr write_div">
								<label for="bf_file_1" class="lb_icon" style="padding: 5px 5px;">첨부</label>
								<input type="file" name="pimage" id="bf_file_1" class="frm_file ">
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
	</div><!--inner -->
</div>


<%@include file="/common/footer.jsp" %>