<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.login_form {
		border: 1px solid black;
		width: 500px;
		height: 100px;
		margin-top: 200px;
	}

</style>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	
	
	<div class="login_form">
		<a href="${pageContext.request.contextPath}/google_login">
			<button>구글로 로그인</button>
		</a>
	</div>
	
	
	
	
	<%@ include file="../footer.jsp" %>
</body>
</html>