<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<link rel="stylesheet" href="/springlegacy/static/bootstrap-5.1.3/css/bootstrap.css" />
<script src="/springlegacy/resources/jquery/jquery-3.6.0.js"></script>
</head>
<body>
<div class="container">
	<h2>@RequestParam 어노테이션으로 파라미터 받기</h2>
	
	<ul>
		<li>이름: ${memberDTO.name }</li>
		<li>아이디: ${memberDTO.id }</li>
		<li>패스워드: ${memberDTO.pw }</li>
		<li>메세지: ${memberDTO.email }</li>
	</ul>
</div>
</body>
</html>