<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="�α���"</script>

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
	    <!-- �Խù� �ۼ�/���� ���� { -->
    		<form action="${pageContext.request.contextPath}/MemberLogin.do" method="post" name="fwrite" id="fwrite">
			    <div class="bo_w_info write_div3 half1">
			        <span>���̵�</span>
			        <input type="text" name="id" value="" id="id" required="" class="frm_input required" placeholder="���̵�">
				</div>
				<div class="bo_w_info write_div3 half1">
			        <span>��й�ȣ</span>
			        <input type="password" name="pwd" id="pwd" required="" class="frm_input required" placeholder="��й�ȣ">
				</div>
				    		
				<div class="clear"></div>
				
		
			    <div class="btn_confirm write_div">
				        <input type="submit" value="�α���" id="btn_submit" accesskey="s" class="btn_submit btn" style="margin: 0 auto; display: block;">
			    </div>
		    </form>
	
		</section>
	<!-- } �Խù� �ۼ�/���� �� -->
	</div><!--inner -->
</div>


<%@include file="/common/footer.jsp" %>