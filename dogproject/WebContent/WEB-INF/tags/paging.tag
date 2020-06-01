<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="paging" type="co.dog.wp.common.Paging" %>
<%@ attribute name="jsfunc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pagination pg_wrap">
<ul>

<c:if test="${paging.startPage>1}">
	<li><a href="javascript:${jsfunc}(${paging.startPage-1})" class="pg_page pg_start">이전</a>
</c:if>
<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i">
	<c:if test="${i != paging.page}">
		<li><a href="javascript:${jsfunc}(${i})" class="pg_page">${i}</a>
	</c:if>
	<c:if test="${i == paging.page}">
		<li class="active pg_current">${i}
	</c:if>
</c:forEach>
<c:if test="${paging.endPage<paging.totalPageCount}">
	<li><a href="javascript:${jsfunc}(${paging.endPage+1})" class="pg_page pg_end">다음</a>
</c:if>
</ul>
</div>