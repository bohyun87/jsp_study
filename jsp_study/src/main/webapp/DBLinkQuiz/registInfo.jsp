<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>고객목록</h2>
	<a href="/jsp_study/rcontrol2">[새로고침]</a>
	<hr>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
		</tr>
		<c:forEach var="r" items="${regist}">
			<tr>
				<td>${r.id}</td>
				<td>${r.name}</td>
				<td>${r.phone}</td>
			</tr>
		</c:forEach>		
	</table>
	
	<h2>고객 추가</h2>
	<hr>
	<form action="/jsp_study/rcontrol2?action=insert" method="post">
		<label>아이디</label><input type="text" name="id" /> <br />
		<label>이름</label><input type="text" name="name" /> <br />
		<label>지역</label><input type="text" name="address" /> <br />
		<label>등급</label><input type="text" name="grade" /> <br />
		<label>전화번호</label><input type="text" name="phone" /> <br />
		<button type="submit">추가</button>
	</form>
	
	
</body>
</html>