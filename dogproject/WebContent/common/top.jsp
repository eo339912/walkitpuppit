<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	
	
	<c:if test="${loginId == null}">
	<a class="hd_btn" href="MemberLogin.do">로그인</a>
	<a class="hd_btn" href="MemberInsert.do" style="right: 102px;">회원가입</a>
	</c:if>
	<c:if test="${loginId != null}">
	<a class="hd_btn" href="MemberLogout.do">로그아웃</a>
	</c:if>
	
	<div class="hd_full mo">
		<span></span>
	</div>
</header>

<div id="gnb_mo" class="mo_menu">
<%@include file="/common/menu.jsp"%>
</div>
