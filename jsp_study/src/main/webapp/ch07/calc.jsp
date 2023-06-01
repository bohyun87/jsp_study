<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Calculator calc = new Calculator(); 

	 calc.setN1(request.getParameter("n1"));  => private 필드라서 n1 이 아니라 setN1 으로 가져옴
	 calc.setN1(request.getParameter("n2"));
	 calc.setOp(request.getParameter("op"));  
-->
<jsp:useBean id="calc" class="ch07.Calculator" />  <!-- 태그사이에 아무내용 없으면 종료태그 생략가능 -->
<!-- calcFrom.htlm 에서 입력 받은
	 값 모두를 Calculator 클래스의 알맞는 필드에 넣어준다.
-->

<!-- Property: 값  / setProperty: 값을 넣어준다 -->
<jsp:setProperty property="*" name="calc"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	결과: <%=calc.calc() %>  <!-- calc(Calculator)클래스 의 calc 메소드 -->

</body>
</html>