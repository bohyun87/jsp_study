<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1. 멤버변수나 선언이 필요한 경우  -->
	<%! /* !안에서는 변수나 메소드 자유롭게 기술 가능 */
		/* 변수 선언 */
		String[] members = {"김길동", "홍길동", "김사랑", "박사랑"};
		int num1 = 10;
		
		/* 메소드 */
		int calc(int num2) {
			return num1 + num2;
		}
	%>

	<h3>
		1.jsp 주석
		<!-- html주석: 화면에서는 안보이고 소스 보기에는 보임 -->
		<%-- jsp주석: 화면과 소스보기 둘다 안보임, 이클립스에서만 보임 --%>
	</h3>
	<h3>
		2. calc(10) 메소드 실행 결과:
		<%=calc(10)%>
	</h3>
	<h3>
		3. include: hello.jsp
		<%@ include file="../hello.jsp" %>
	</h3>
	<h3>4. 스크립트(배열 데이터 출력)</h3>
	<ul>
		<% for(String name: members) { %>
			<li><%=name%></li>
		<%} %>
	</ul>
</body>
</html>