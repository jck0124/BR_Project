<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ice_cream_cake_detail.css">
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<!-- 콘텐츠 -->
	<div id="content">
	
		<!-- 제품 이미지, 정보 -->
		<div class="product_name">
			<div class="half_round fl">
				<img src="${cakeDetail.cakeImg}"/>
			</div>
			<div id="letter" class="fl">
				<div class="pink_color">${cakeDetail.pinkLetter}</div>
				<div class="eng_bold">${cakeDetail.engName}</div>
				<div class="kor_bold">${cakeDetail.korName}</div>
				<div class="kor_thin">${cakeDetail.subtitle}</div>
				<div><fmt:formatNumber value="${cakeDetail.price}" type="number" pattern="#,###"/>원</div>
			</div>
			<div style="clear:both;"></div>
		</div>
		
		<!-- 영양정보 -->
		<div id="nutrition">
			<div class="nutrition_black">영양정보</div>
			<div>
				<div class="nutrition_black">1회 제공량</div>
				<div class="nutrition_pink">${cakeDetail.oneTime}ml</div>
			</div>
			<div>
				<div class="nutrition_black">열량(kcal)</div>
				<div class="nutrition_pink">${cakeDetail.kcal}kcal</div>
			</div>
			<div>
				<div class="nutrition_black">당류(g)</div>
				<div class="nutrition_pink">${cakeDetail.sugar}g</div>
			</div>
			<div>
				<div class="nutrition_black">단백질(g)</div>
				<div class="nutrition_pink">${cakeDetail.protein}g</div>
			</div>
			<div>
				<div class="nutrition_black">포화지방(g)</div>
				<div class="nutrition_pink" class="nutrition_pink">${cakeDetail.fat}g</div>
			</div>
			<div>
				<div class="nutrition_black">나트륨(mg)</div>
				<div class="nutrition_pink">${cakeDetail.sodium}mg</div>
			</div>
			<div>
				<div class="nutrition_black">알레르기 성분</div>
				<div class="nutrition_pink">${cakeDetail.allergy}</div>
			</div>
		</div>
		
		<div>
			<img src="${cakeDetail.infoImg}" />
		</div>
	</div>
	
	<%@ include file="../footer.jsp" %>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
</html>