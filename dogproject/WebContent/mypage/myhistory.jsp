<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="내 히스토리"</script>

<div id="sub_vis_wrap" class="sub03 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<%@include file="/common/sub_menu.jsp"%>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit01);</script></span>
</div>

	<div id="sub_content_wrap"  class="sub0301 inner">
	<div class="inner" style="margin-bottom:10em">

		<!-- 내정보 버튼 wrap -->
		<div class="mySec mySec1 fl">
			<div class="myBtnWrap">
				<div><a href="MymarketList.do?id=${loginId}">내가 쓴 글</a></div>
				<div><a>내가 쓴 후기글</a></div>
				<div><a>공원 입장 시간</a></div>
			</div>
			</div>
			
	</div>
	</div>
			
		




	
<%@include file="/common/footer.jsp" %>