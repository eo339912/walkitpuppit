<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jsp"%>

	 <div class="tbl_head01 tbl_wrap">
		<script> var tit01="${param.sname} 산책로"</script>
	
	
	<div class="sub_tit_wrap">
		<span><script>document.write(tit01);</script></span>
	</div>

	<table style="text-align:center">
		<tr>
			<th>접속아이디</th>
			<th>공원입장 시간</th>
			<th>메세지 보내기</th>
		</tr>
		<c:forEach items="${walkList}" var="list">
			<tr>
				<td>${list.id}</td>
				<td>${list.inpark}</td>
				<td><a onclick="OpenWindow('${list.id}', ${param.seq})"><i class="fa fa-commenting-o" aria-hidden="true" style="font-size:30px"></i></a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	<script>
function OpenWindow(mid, seq) { 
      window.open("MessageInsertForm.do?mid=" + mid + "&seq=" + seq, "_self","top=50,left=50,width=816,height=750,resizable=yes,scrollbars=no");
}
</script>

</body>
</html>