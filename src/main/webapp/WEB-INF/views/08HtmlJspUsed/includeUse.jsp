<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="/springlegacy/static/bootstrap5.1.3/css/bootstrap.css" />
<script src="/springlegacy/resources/jquery/jquery-3.6.0.js"></script>
</head>
<body>
<div class="container">
	<h2>JSP 파일 인클루드 하기</h2>
	<!-- 
	webapp 하위에 생성된 jsp 파일을 인클루드 할때에는 아래와 같이
	루트 경로를 사용하면 된다.
	 -->
	<%@include file="/randomNum.jsp" %>
	
	
	<h2>JSP파일 링크 걸기</h2>
	<!-- 
	링크 생성시에도 컨텍스트 루트 경로를 사용하면 된다.
	 -->
	<a href="<%=request.getContextPath()%>/randomNum.jsp">
		RandomNum.jsp 바로가기</a>
</div>
</body>
</html>
