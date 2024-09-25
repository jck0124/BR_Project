<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/event.css">
</head>
<body>
	<%@ include file="../header.jsp" %>
	<!-- 페이지 이동 -->
	<div id="menu_location">
		<a href="">이벤트</a>
		<a href="">베라광장</a>
		<a href="">BR레시피</a>
		<a href="">마이플레이버 리스트</a>
	</div>
	
	<!-- 아이스크림 케이크 소개 -->
	<div id="event">
		<div>Event</div>
		<div>베스킨라빈스와 함께 해피포인트앱/오프라인 매장에서 진행하는</div>
		<div>다양한 이벤트를 확인해보세요</div>
	</div>
	
	<!-- 탭 -->
	<div id="promotion_box">
		<c:forEach var="event" items="${selectEvent}">
			<div class="fl promotion">
				<div class="fl">
					<img class="promotion_img" src="${event.img}"/>
				</div>
				<div class="fl promotion_letter">
					<div class="top_blue">${event.topLetter}</div>
					<div class="middle_black">${event.title}</div>
					<div class="bottom_tag">${event.period}</div>
				</div>
				<div style="clear:both;"></div>
			</div>
		</c:forEach>
		<div style="claer:both"></div>
	</div>
	
	<div id="pagination">
		<c:forEach var="i" begin="${startNum}" end="${endNum}">
			<c:choose>
				<c:when test="${i!=pageNum}">
					<a href="event?page=${i}">${i}</a> 
				</c:when>
				<c:otherwise>
					<strong>${i}</strong>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${endNum < lastPageNum}">
			<a id="next" href="evetn?page=${endNum+1}">&lt;></a>
		</c:if>
	</div>
	
	<div style="clear:both;"></div>
	<%@ include file="../footer.jsp" %>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
</html>