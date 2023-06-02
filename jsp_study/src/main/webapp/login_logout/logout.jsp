<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//세션에 저장되어 있는 id 값 지우기
	session.removeAttribute("id");

%>

<script>
	alert("로그아웃이 되었습니다.");
	location.href = "index.jsp"
</script>


</body>
</html>