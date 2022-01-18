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
    <h2>Validator 인터페이스를 구현한 폼값 검증</h2>

	<!-- Validator를 통해 폼값 검증후 에러가 있는 경우 출력 -->
    <span style="color:red; font-size:1.5em;">${formError }</span>
    
    <script type="text/javascript">
    function registCheck(){
   	 
    }
    </script>
    <form action="./registProc.do" method="post" name="registFrm"
   	 onsubmit="return registCheck();">
    <table class="table table-bordered" style="width:500px;">
   	 <tr>
   		 <td>아이디</td>
   		 <td><input type="text" name="id" value="${mInfo.id }" /></td>
   	 </tr>
   	 <tr>
   		 <td>패스워드</td>
   		 <td><input type="password" name="pw" value="${mInfo.pw }" /></td>
   	 </tr>
   	 <tr>
   		 <td>이름</td>
   		 <td><input type="text" name="name" value="${mInfo.name }" /></td>
   	 </tr>
   	 <tr>
   		 <td class="text-center" colspan="2">
   			 <button type="submit">회원가입하기</button>
   		 </td>
   	 </tr>
    </table>
    </form>    
</div>
</body>

</body>
</html>