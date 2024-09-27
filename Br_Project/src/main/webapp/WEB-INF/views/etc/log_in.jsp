<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
	<c:choose>
			<c:when test="${sessionId != null}">			
				<h2> 네이버 아이디 로그인 성공하셨습니다!! </h2>			
				<h3>'${sessionId}' 님 환영합니다! </h3>            
				<h3><a href="logout">로그아웃</a></h3>
			</c:when>
			<c:otherwise>
				<div id="social_login">
					<a id="btn_naver_login" href="${url}">
						<img class="login_logo" src="${pageContext.request.contextPath}/resources/img/naver_logo_login.png">
					</a>
					<a id="btn_kakao_login" href="">
						<img class="login_logo" src="${pageContext.request.contextPath}/resources/img/kakao_logo_login.png">
					</a>
					<a id="btn_google_login" href="">
						<img class="login_logo" src="${pageContext.request.contextPath}/resources/img/google_logo_login.png">
					</a>
				</div>
			</c:otherwise>
	</c:choose>
	<%@ include file="../footer.jsp" %>
</body>
</html>