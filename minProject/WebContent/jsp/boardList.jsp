<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div align="center">
		<div>
			<h1>게시글 목록</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th>순번</th>
					<th>아이디</th>
					<th>타이틀</th>
					<th>작성일자</th>
					<th>file명</th>
				</tr>
				<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.seq}</td>
					<td>${vo.id}</td>
					<td>${vo.title}</td>
					<td>${vo.regDt}</td>
					<td>${vo.fileName}</td>
				</tr>
				</c:forEach>
			</table>
			
			<div>
				<button type="button" onclick="location.href='main.do'">홈으로</button>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>