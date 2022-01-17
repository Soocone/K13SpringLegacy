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
	<h2>@RequestMapping 어노테이션</h2>
	
	<h3>@ModelAttribute 어노테이션을 사용하여 파라미터 일괄 전송</h3>
	
	<ul>
		<li>이름: ${si.name }</li>
		<li>나이: ${si.age }</li>
		<li>학년: ${si.gradeNum }</li>
		<li>학반: ${si.classNum }</li>
	</ul>
</div>
</body>
</html>