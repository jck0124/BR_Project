<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/manager.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<!-- 아이스크림 케이크 소개 -->
	<div id="manager">
		<div>관리자 페이지</div>
		<div>이벤트, BR 레시피 정보를 업데이트하세요!</div>
		<div>주문 정보를 확인하세요</div>
	</div>
	
	<!-- 정보 넣기 -->
	<div id="insert">
		<!-- 이벤트 정보 넣기 -->
		<form class="insert_info" action="" enctype="multipart/form-data">
			이벤트 업로드
			<br/>
			종류 : <input type="text" name="type"/>
			<br/>
			제목 :  <input type="text" name="title"/>
			<br/>
			기간 : <input type="text" name="period"/>
			<br/>
			이미지 : <input type="file" name="img"/>
			<br/>
			<button type="submit">이벤트 작성하기</button>
		</form>
		
		<!-- br레시피 정보 넣기 -->
		<form class="insert_info" action="" enctype="multipart/form-data">
			BR Recipe 업로드 
			<br/>
			종류 : <input type="text" name="type"/>
			<br/>
			제목 :  <input type="text" name="title"/>
			<br/>
			부제목 : <input type="text" name="subtitle"/>
			<br/>
			이미지 : <input type="file" name="img"/>
			<br/>
			<button type="submit">BR 레시피 작성하기</button>
		</form>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
</html>