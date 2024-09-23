<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu_drinks.css">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="../header.jsp" %>
	
	<!-- 페이지 이동 -->
	<div id="menu_location">
		<a href="">이달의 맛</a>
		<a href="">아이스크림</a>
		<a href="">아이스크림케이크</a>
		<a href="${pageContext.request.contextPath}/menu_drinks">음료</a>
	</div>
	
	<!-- 아이스크림 케이크 소개 -->
	<div id="iceCreamCake">
		<div>Beverage</div>
		<div>짜릿하게 시원한 블라스트부터 아이스크림을 듬뿍넣고 갈아만든 쉐이크까지!.</div>
		<div>배스킨라빈스만의 특별함을 음료로 만나보세요.</div>
	</div>
	

	<div id="product">
		
		<c:forEach var="drink" items="${drinksList}">
			<a href="${pageContext.request.contextPath}/menu_drinks_detail?drinksIdx=${drink.drinksIdx}" class="iceCreamCakeProduct fl">
				<div class="cakeImg">
					<div class="tag" style="color: ${drink.fontColor}">${drink.tag}</div>
					<img src="${drink.img}" alt="음료"/>
					<div class="backgroundColor">${drink.backgroundColor}</div>
				</div>
				<div style="color: #999999">${drink.name}</div>
			</a>
		</c:forEach>
			
		<div style="clear:both"></div>
	</div>
	
	
	<%@ include file="../footer.jsp" %>
</body>
<script src="${pageContext.request.contextPath }/resources/js/menu_drinks.js"></script>
</html>