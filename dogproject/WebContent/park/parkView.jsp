<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="��å��"</script>

<div id="sub_vis_wrap" class="sub04 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0401 inner">
	<div class="inner" style="margin-bottom:10em">
	<input type="hidden" name="seq" value="${vo.seq}">
	
		<table width="100%" height="200px">
		<tr><td>�ȳ�</td></tr>
		<tr><td> ${vo.sname}</td></tr>
		</table>
		
	</div>
	</div>


<%@include file="/common/footer.jsp" %>