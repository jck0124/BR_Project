<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/order_list.css">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
	$(function() {
	    function updateTotalPrice() {
	        let totalPrice = 0;
	        let addedItems = []; // 추가된 상품을 저장할 배열
	
	        $(".list").each(function() {
	            let num = Number($(this).find(".amount").val());
	            let price = Number($(this).find(".price").text().replace(/,/g,''));
	            let itemName = $(this).find(".fl").eq(1).text(); // 두 번째 플렉스 아이템이 이름
	
	            if (num > 0) { // 수량이 0보다 큰 경우
	                totalPrice += num * price; // 총액에 추가
	                addedItems.push(itemName + "/" + num + "/" + price); // 추가된 상품에 이름/수량/가격 추가
/* 	                addedItems.push(itemName + " (수량: " + num + ")" + " (가격: " + price + ")"); // 추가된 상품에 이름과 수량 추가 */
	            }
	        });
	
	        $("#totalPrice").val(totalPrice); // 계산된 총액을 totalPrice 입력 필드에 설정
	
	        // 추가된 상품 목록을 업데이트
	        $("#addedItems").html(addedItems.join("<br>")); // 추가된 상품 목록 표시
	
	        // 숨겨진 필드에 추가된 상품 목록 설정
	        $("#hiddenAddedItems").val(addedItems.join(", ")); // 숨겨진 필드에 추가된 상품 목록을 설정
	    }
	
	    $(".minus").click(function() {
	        let num = Number($(this).siblings(".amount").val());
	        if (num > 0) {
	            $(this).siblings(".amount").val(num - 1);
	            updateTotalPrice(); // 수량 변경 후 총액 업데이트
	        }
	    });
	
	    $(".plus").click(function() {
	        let num = Number($(this).siblings(".amount").val());
	        if(num < 10) { 
	            $(this).siblings(".amount").val(num + 1);
	        } else {
	            $(this).siblings(".amount").val(num);
	        }
	
	        updateTotalPrice(); // 수량 변경 후 총액 업데이트
	    });
	});
</script>

</head>
<body>
<%@ include file="../header.jsp" %>
	<form action="${pageContext.request.contextPath}/payment">
	<div id="store_info">
		<div>주문 페이지</div>
		<div>${storeName} 베스킨라빈스</div>
	</div>
	
	<div id="product_list">
		<div class="list">
			<img class="fl" src="https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_hp_1.jpg"/>
			<div class="fl">파인트</div>
			<div class="fl price"><fmt:formatNumber value="9800" type="number" pattern="#,###"/></div>
			<button class="fl minus" type="button">-</button>
			<input class="fl amount" type="text" value="0"/>
			<button class="fl plus" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		<div class="list">
			<img class="fl" src="https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_hp_1.jpg"/>
			<div class="fl">쿼터</div>
			<div class="fl price"><fmt:formatNumber value="18500" type="number" pattern="#,###"/></div>
			<button class="fl minus" type="button">-</button>
			<input class="fl amount" type="text" value="0"/>
			<button class="fl plus" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		<div class="list">
			<img class="fl" src="https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_hp_1.jpg"/>
			<div class="fl">패밀리</div>
			<div class="fl price"><fmt:formatNumber value="26000" type="number" pattern="#,###"/></div>
			<button class="fl minus" type="button">-</button>
			<input class="fl amount" type="text" value="0"/>
			<button class="fl plus" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		<div class="list">
			<img class="fl" src="https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_hp_1.jpg"/>
			<div class="fl">하프갤론</div>
			<div class="fl price"><fmt:formatNumber value="31500" type="number" pattern="#,###"/></div>
			<button class="fl minus" type="button">-</button>
			<input class="fl amount" type="text" value="0"/>
			<button class="fl plus" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		<c:forEach var="cakes" items="${products.iceCreamCakes}">
		<div class="list">
			<img class="fl" src="${cakes.img}"/>
			<div class="fl">${cakes.name}</div>
			<div class="fl price"><fmt:formatNumber value="${cakes.price}" type="number" pattern="#,###"/></div>
			<button class="fl minus" type="button">-</button>
			<input class="fl amount" type="text" value="0"/>
			<button class="fl plus" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		</c:forEach>
		<c:forEach var="drinks" items="${products.drinks}">
		<div class="list">
			<img class="fl" src="${drinks.img}"/>
			<div class="fl">${drinks.name}</div>
			<div class="fl price"><fmt:formatNumber value="${drinks.price}" type="number" pattern="#,###"/></div>
			<button class="fl minus" type="button">-</button>
			<input class="fl amount" type="text" value="0"/>
			<button class="fl plus" type="button">+</button>
			<div style="clear:both"></div>
		</div>
		</c:forEach>
	</div>
	
	<div id="total">
	    <div>총 액수</div>
	    <input type="text" name="totalPrice" id="totalPrice" value="0"/>
	    <div>추가된 상품</div>
	    <div id="addedItems"></div>
	    <input type="hidden" name="products" id="hiddenAddedItems"/> <!-- 추가된 상품 목록을 위한 숨겨진 필드 -->
	</div>
	<button id=order type="submit">주문</button>
	</form>
		
<%@ include file="../footer.jsp" %>		
</body>
</html>