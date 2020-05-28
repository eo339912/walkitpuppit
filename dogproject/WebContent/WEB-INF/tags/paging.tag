<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="paging" type="co.yedam.app.common.Paging" %>
<%@ attribute name="jsfunc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pagination">
<ul>
<c:if test="${paging.startPage>1}">
	<li class="nbtn"><a href="javascript:${jsfunc}(${paging.startPage-1})">&laquo;</a>
</c:if>
<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i">
	<c:if test="${i != paging.page}">
		<li class="rdbtn"><a href="javascript:${jsfunc}(${i})">${i}</a>
	</c:if>
	<c:if test="${i == paging.page}">
		<li class="rdbtn active"><a href="javascript:${jsfunc}(${i})">${i}</a>
	</c:if>
</c:forEach>
<c:if test="${paging.endPage<paging.totalPageCount}">
	<li class="nbtn"><a href="javascript:${jsfunc}(${paging.endPage+1})">&raquo;</a>
</c:if>
</ul>
</div>