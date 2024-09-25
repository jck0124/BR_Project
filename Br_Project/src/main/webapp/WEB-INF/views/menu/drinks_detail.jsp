<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/drinks_detail.css">
</head>
<body>
<%@ include file="../header.jsp" %>
	
	<!-- 콘텐츠 -->
	<div id="content">
	
		<!-- 제품 이미지, 정보 -->
		<div class="product_name">
			<div class="half_round fl" style="background-color: ${drinkDto.backgroundColor}">
				<img src="${drinkDto.img}"/>
			</div>
			<div id="letter" class="fl">
				<div class="pink_color">Drink</div>
				<div class="eng_bold">${drinkDto.nameEng}</div>
				<div class="kor_bold">${drinkDto.name}</div>
				<div class="kor_thin" style="width: 400px">${drinkDto.description}</div>
			</div>
			<div style="clear:both;"></div>
		</div>
		
		<!-- 영양정보 -->
		<div class="nutrition_title border_top">
			<h3>영양정보</h3>
		</div>
		
		<c:forEach var="drinkDetailMenu" items="${drinkDetailMenuList}">
			<div class="nutrition_menu_name">
				<h4>${drinkDetailMenu.name}</h4>
			</div>
			<div id="nutrition">
				<div class="">
					<div class="nutrition_black">1회 제공량</div>
					<div class="nutrition_pink">${drinkDetailMenu.servingSize}</div>
				</div>
				<div class="">
					<div class="nutrition_black">열량(kcal)</div>
					<div class="nutrition_pink">${drinkDetailMenu.calories}</div>
				</div>
				<div class="">
					<div class="nutrition_black">당류(g)</div>
					<div class="nutrition_pink" style="font-weight: 600">${drinkDetailMenu.sugars}</div>
				</div>
				<div class="">
					<div class="nutrition_black">단백질(g)</div>
					<div class="nutrition_pink">${drinkDetailMenu.protein}</div>
				</div>
				<div class="">
					<div class="nutrition_black">포화지방(g)</div>
					<div class="nutrition_pink" class="nutrition_pink">${drinkDetailMenu.saturatedFat}</div>
				</div>
				<div class="">
					<div class="nutrition_black">나트륨(mg)</div>
					<div class="nutrition_pink">${drinkDetailMenu.sodium}</div>
				</div>
				<div class="">
					<div class="nutrition_black">카페인(mg)</div>
					<div class="nutrition_pink">${drinkDetailMenu.caffeine}</div>
				</div>
				<div class="">
					<div class="nutrition_black">알레르기 성분</div>
					<div class="nutrition_pink">${drinkDetailMenu.allergens}</div>
				</div>
				<div class="">
					<div class="nutrition_black">가격</div>
					<div class="nutrition_pink">
						<fmt:formatNumber value="${drinkDetailMenu.price}" type="number" pattern="#,##0"/>원
					</div>
				</div>
			</div>
		</c:forEach>
		
	</div>
	
	<%@ include file="../footer.jsp" %>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</html>