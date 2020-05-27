<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<header id="hd_wrap">
	<div class="hd_logo">
		<a href="/">
			<img class="pc" src="${pageContext.request.contextPath}/images/common/hd_logo.png"  alt="" />
			<img class="mo" src="${pageContext.request.contextPath}/images/common/hd_logo_on.png"  alt="" />
		</a>
	</div>

	<div id="gnb_pc" class="hd_menu">
		<%@include file="/common/menu.jsp"%>
	</div>

	<a class="hd_btn" href="javascript:GoPage('cs03')">제품문의하기</a>

	<div class="hd_full mo">
		<span></span>
	</div>
</header>

<div id="gnb_mo" class="mo_menu">
<%@include file="/common/menu.jsp"%>
</div>
