<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>구구단 출력하기</h4>
<!-- GuGuDan gugudan = new GuGuDan(); -->
<jsp:useBean id="gugudan" class="ch07.com.dao.GuGuDan" />

<%
 	int arr[] = gugudan.process(5);

	for(int i=0; i<9; i++){
		out.println(5 + "*" + (i+1) + "=" + arr[i] + "<br>");
	}
%>

</body>
</html>