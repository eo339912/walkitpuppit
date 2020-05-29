<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="로그인"</script>

<div id="sub_vis_wrap" class="sub05 page02">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0401 inner inner_580">
	<div class="inner inner_580" style="margin-bottom:10em"><!-- skin : basic_voc -->
		<section id="bo_w">
	    <!-- 게시물 작성/수정 시작 { -->
    		<form action="MemberLogin.do" method="post" name="fwrite" id="fwrite">
			    <div class="bo_w_info write_div3 half1">
			        <span>아이디</span>
			        <input type="text" name="id" value="" id="id" required="" class="frm_input required" placeholder="아이디">
				</div>
				<div class="bo_w_info write_div3 half1">
			        <span>비밀번호</span>
			        <input type="password" name="pwd" id="pwd" required="" class="frm_input required" placeholder="비밀번호">
				</div>
				    		
				<div class="clear"></div>
				
		
			    <div class="btn_confirm write_div">
				        <input type="submit" value="로그인" id="btn_submit" accesskey="s" class="btn_submit btn" style="margin: 0 auto; display: block;">
			    </div>
		    </form>
	
		</section>
	<!-- } 게시물 작성/수정 끝 -->
	</div><!--inner -->
</div>


<%@include file="/common/footer.jsp" %>