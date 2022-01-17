<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="/springlegacy/static/bootstrap-5.1.3/css/bootstrap.css" />
<script src="/springlegacy/resources/jquery/jquery-3.6.0.js"></script>
</head>
<body>
<div class="container">
	<h2>Spring Framework 시작하기</h2>
	
	<!-- 
	Spring MVC에서는 이미지와 같은 정적 리소스를 사용하기 위해 별도의 
	resources 폴더를 제공한다. 해당 폴더의 매핑은 servlet-context.xml에서
	변경하거나 추가할 수 있다.
	 -->
	<h3>resources 폴더 사용하기</h3>
	<!-- views 폴더 하위에 있는 해당 이미지는 출력되지 않는다. 
	views 폴더에는 View 파일, 즉 jsp만 위치할 수 있다. -->
	<img src="./img_avartar1.png" alt="부트스트랩 아바타1" />
	
	<!-- 원래의 폴더명은 resources이나 아래와 같이 개발자가 별도로 별칭을
	부여하여 매핑할 수 있다. -->
	<img src="./resources/images/img_avatar2.png" alt="아바타2" width="200"/>
	<img src="./static/images/1.png" alt="스퐁지밥" width="200"/>
	
	<!-- 1.컨트롤러 제작을 위해 제일 먼저 요청명을 결정한다. -->
	<h3>첫번째 컨트롤러 만들기</h3>
	<li>
		<a href="./home/helloSpring" target="_blank">첫번째 컨트롤러</a>
	</li>
	
	<!-- 컨트롤러: FormController.java -->
	<h3>form값 처리하기</h3>
	<li>
		<a href="./form/servletRequest?id=kosmo&pw=1234" target="_blank">
			HttpServletRequest로 폼값 받기
		</a>
	</li>
	<li>
		<a href="./form/requestParam.do?id=kosmo&pw=1234
			&name=홍길동&email=hong@gildong.com" target="_blank">
			@requestParam 어노테이션으로 폼값 받기
		</a>
	</li>
	<li>
		<a href="./form/commandObjGet.do?id=kosmo&pw=1234
			&name=홍길동&email=hong@gildong.com" target="_blank">
			커맨드(Command) 객체로 한 번에 폼값 받기
		</a>
	</li>
	<li>
		<a href="./form/gildong99/코스모" target="_blank">
			pathVariable 어노테이션으로 폼값 받기
		</a>
	</li>
	
	<!-- 컨트롤러: RequesstMappingController.java -->
	<h3>@RequestMapping 어노테이션 활용</h3>
	<li>
		<a href="./requestMapping/index.do" target="_blank">
			requestMapping 시작페이지 바로가기
		</a>
	</li>
	
</div>
</body>
</html>
