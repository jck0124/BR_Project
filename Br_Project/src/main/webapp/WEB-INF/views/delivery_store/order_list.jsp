<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/order_list.css">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="../header.jsp" %>
	<form action="">
	<div id="store_info">
		<div>주문 페이지</div>
		<div>${storeName} 베스킨라빈스</div>
	</div>
	
	<div id="product_list">
		<div class="list">
			<img class="fl" src="	https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_hp_1.jpg"/>
			<div class="fl">파인트</div>
			<div class="fl">9800</div>
			<button class="fl" type="button">-</button>
			<input class="fl" type="text" value="0"/>
			<button class="fl" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		<div class="list">
			<img class="fl" src="	https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_hp_1.jpg"/>
			<div class="fl">쿼터</div>
			<div class="fl">18500</div>
			<button class="fl" type="button">-</button>
			<input class="fl" type="text" value="0"/>
			<button class="fl" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		<div class="list">
			<img class="fl" src="	https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_hp_1.jpg"/>
			<div class="fl">패밀리</div>
			<div class="fl">26000</div>
			<button class="fl" type="button">-</button>
			<input class="fl" type="text" value="0"/>
			<button class="fl" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		<div class="list">
			<img class="fl" src="	https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_hp_1.jpg"/>
			<div class="fl">하프갤론</div>
			<div class="fl">31500</div>
			<button class="fl" type="button">-</button>
			<input class="fl" type="text" value="0"/>
			<button class="fl" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		<c:forEach var="cakes" items="${products.iceCreamCakes}">
		<div class="list">
			<img class="fl" src="${cakes.img}"/>
			<div class="fl">${cakes.name}</div>
			<div class="fl">${cakes.price}</div>
			<button class="fl" type="button">-</button>
			<input class="fl" type="text" value="0"/>
			<button class="fl" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		</c:forEach>
		<c:forEach var="drinks" items="${products.drinks}">
		<div class="list">
			<img class="fl" src="${drinks.img}"/>
			<div class="fl">${drinks.name}</div>
			<div class="fl">${drinks.price}</div>
			<button class="fl" type="button">-</button>
			<input class="fl" type="text" value="0"/>
			<button class="fl" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		</c:forEach>
	</div>
	
	<button id=order type="submit">주문</button>
	</form>
		
<%@ include file="../footer.jsp" %>		
</body>
</html>