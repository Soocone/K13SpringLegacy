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
	<h1>로또 결과</h1>
	<hr />
	<ul>
		<li>사용자: ${lottoVO.userLottoNum }</li>
		<li>시스템: ${lottoVO.randomLottoNum }</li>
	</ul>
	<h2>${lottoVO.result }</h2>
	<hr />
	<a href="../resources/lottoForm.html">재시도</a>
</div>
</body>
</html>