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
	request.setCharacterEncoding("UTF-8"); /* 한글 데이터 받아올 때 글자 깨짐 방지 */
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String loginChk = request.getParameter("loginChk");
	
	//원래는 데이터를 db에서 가져와야 되는데 아직 연결하는 법 모르니까
	//기존의 사용자 id,pw(db에서 가져왔다고 가정한다.)
	String dbId= "user", dbPw = "1234";
	
	if(dbId.equals(id)) {
		if(dbPw.equals(pw)) {
		  //로그인 작업 -> 세션값 생성,  보안성이 중시되는 데이터를 세션에 저장
		  session.setAttribute("id", id);  //사용자가 입력한 id (key, value)
		  
		  //(쿠키)사용자가 아이디 저장 체크여부 / 쿠키도 해시맵처럼 key가 같으면 중복저장 안됨,  보안성X
		  if(loginChk != null) { //체크한 경우
			Cookie c = new Cookie("loginChk", "Y"); //쿠키 생성(key, value), ("loginChk", "Y") <= 생성자
			c.setMaxAge(60 * 50); //50분 동안 쿠키에 값 저장 (초 * 분)
			c.setPath("/");  // 쿠키 적용 경로
			 
			response.addCookie(c);
		  } else {
			Cookie c = new Cookie("loginChk", "N"); //쿠키 생성(key, value), ("loginChk", "N") <= 생성자
			c.setMaxAge(60 * 50); //50분 동안 쿠키에 값 저장 (초 * 분)
			c.setPath("/");  // 쿠키 적용 경로
			
			response.addCookie(c);
		  }
	%>
	
	<script>
		alert("인증되었습니다.");
		location.href = "main.jsp";
	</script>
	
	<%			
		} else {
	%>		
	<!-- ↑ 자바  / ↓ 알림창 때문에 자바스크립트 써야되서 분리 -->
			
	<script>
		alert("비밀번호가 다릅니다.");
		location.href = "index.jsp";
	</script>
		
	<!-- ↓ 자바 -->
	<%		
		}		
	} else {
	%>
	<!-- ↑ 자바 -->
		
	<script>
		alert("아이디가 다릅니다.");
		location.href = "index.jsp";
	</script>	
	
	<!-- ↓ 자바 -->
	<%		
	}	
%>

</body>
</html>