<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="산책로"</script>

<div id="sub_vis_wrap" class="sub04 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap" class="sub0101 inner">
	<div class="inner">

	<table border="1">
		<tr><th>공원이름</th><th>산책중(명)</th></tr>
		<c:forEach items="${park}" var="vo">
			<tr>
				<td>${vo.sname}</td>
				<td>${vo.senter}</td>

			</tr>
		</c:forEach>
	</table>
	
</div>

</div>
<%@include file="/common/footer.jsp" %>