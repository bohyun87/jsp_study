<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  <!-- 라이브러리파일 사용하기 위해 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>set, out</h3>
	<c:set var="product1" value="<h2>애플 아이폰</h2>" />
	<c:set var="product2" value="삼성 갤럭시 노트" />
	<c:set var="intArray" value="${[1,2,3,4,5]}" />
	
	<p>
		<c:out value="${product1}" default="not regusterd" escapeXml="true" />
	</p>
	<p>${product1}</p>
	<p>${intArray[2]}</p>
	
	<hr>
	
	<h3>배열 출력</h3>
	<ul>
		<!-- for(int num : intArray) -->
		<c:forEach var="num" varStatus="i" items="${intArray}">
			<li>${i.index} : ${num}</li>
		</c:forEach>
	</ul>
	
	<hr>
	
	<h3>if</h3>
	<c:set var="checkuot" value="false" />
	
	<c:if test="${checkuot}">
		<p>주문제품: ${product2}</p>
	</c:if>
		
	<c:if test="${!checkuot}">
		<p>체크아웃 상태가 아닙니다.</p>
	</c:if>
	
	<!-- product2의 값이 비어있지 않으면 -->
	<c:if test="${!empty product2}">
		<p>${product2} 가 이미 추가되었습니다.</p>
	</c:if>
	
	<hr>
	
	<h3>choose, when, otherwise</h3>
	<c:choose>
		<c:when test="${checkout}">
			<p>주문제품: ${product2}</p>
		</c:when>
		<c:otherwise>
			<p>체크아웃 상태가 아닙니다.</p>
		</c:otherwise>
	</c:choose>
	
	<hr>
	
	<h3>forTokens</h3>											    	<!-- varStatus 인덱스 -->
	<c:forTokens var="city" items="seoul|tokyo|new york|toronto" delims="|" varStatus="i"> 
	
		${city}
		<c:if test="${!i.last}">,</c:if> <!-- 마지막 인덱스가 아닐 경우에만 , 출력 -->
		
	</c:forTokens>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>