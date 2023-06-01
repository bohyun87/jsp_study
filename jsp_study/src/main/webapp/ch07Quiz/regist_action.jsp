<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="ch07.Member" />
<!-- ↑ Member member = new Member -->
<jsp:setProperty property="*" name="member"/>
<!-- setProperty 하지 않으면 아래와 같이 모두 하나한 작성해야한다. -->
<!-- member.setEmail(request.getParameter("email")); -->
<!-- member.setPhone(request.getParameter("phone")); -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%out.println(member.result());%>

</body>
</html>