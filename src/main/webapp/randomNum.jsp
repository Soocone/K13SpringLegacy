<%@page import="common.LottoCreater"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
	<h2>RandomNum</h2>
	<%
	//스크립트렛 내에서 코드 작성이 가능하다.
	Random random = new Random();
	out.println("난수:"+ random.nextInt(100));
	%>
	
	<h2>Lotto6/45</h2>
	<%
	//클래스도 동일하게 사용할 수 있다.
	LottoCreater lottoCreater = new LottoCreater();
	int[] lottoNum = lottoCreater.lotto();
	for(int lo : lottoNum){
		out.println(lo);
	}
	%>
</div>
</body>
</html>