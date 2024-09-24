<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/log_in.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<!-- 아이스크림 케이크 소개 -->
	<div id="info">
		<div>로그인</div>
		<div>아이디로 간편하게 로그인 하세요</div>
	</div>
	
	<form id="write_login" action="">
		<input type="text" placeholder="아이디" name="id"/><br/>
		<input type="text" placeholder="비밀번호" name="pw" /><br/>
		<input type="submit" value="제출하기"/>
	</form>
	
	<div id="find">
		<a>아이디 찾기 | </a>
		<a>비밀번호 재발급</a>
	</div>
	
	<div>
		<a>회원가입</a>
	</div>
	
	
	<%@ include file="../footer.jsp" %>
</body>
</html>