<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8");
	   //request 객체에 들어있는 데이터의 한글깨짐 방지 
	%>
	<!-- 실행시키면 page_control_end.jsp 에서 요청받아서 웹페이지에 보여주지만 주소는 forward_action.jsp 로 나타남  -->
	<!-- ★★★★주소 안바뀜★★★★ -->
	<jsp:forward page="page_control_end.jsp">
		<jsp:param value="010-2222-2222" name="tel"/>
	</jsp:forward>

</body>
</html>