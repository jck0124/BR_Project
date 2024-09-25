<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/br_plaza_detail.css">
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	
	<!-- 페이지 이동 -->
	<div id="menu_location">
		<a href="${pageContext.request.contextPath}/event">이벤트</a>
		<a href="${pageContext.request.contextPath}/br_plaza">배라광장</a>
		<a href="${pageContext.request.contextPath}/br_recipe">BR 레시피</a>
		<a href="">마이플레이버 리스트</a>
	</div>
	
	<div id="iceCreamCake">
		<div>아이스크림 맛 제안 요청</div>
	</div>
	

	<div class="plaza_detail">
	
		<div class="plaza_detail_title">
			<div class="plaza_detail_menu">제품 이름</div>
			<div class="plaza_detail_menu_name">쿠키앤크림치즈</div>
			<div class="plaza_detail_witer">이름</div>
			<div class="plaza_detail_witer_name">비공개</div>
		</div>
		
		<div class="plaza_detail_content">
           	쿠키앤크림치즈 2019년인가 20년에 첨 출시되었을 때 먿고 반해서 그 뒤로 그것만 엄청 먹다가 몇개월뒤에 사라져서 진짜 슬펐는데 언제부터 청다브라운이랑 삼성 파르나스몰 매장에 있길래 정말 행복했거든요ㅠㅠ♥
           	<br>
			근데 또 사라졌더라구요ㅠㅠㅠㅠ하프갤런에 그것만 다 담아서 사먹는 앤데 이제 안만드시나요?ㅜㅜㅜㅜ파르나스몰에라도 제발 그대로 해주세요ㅠ^ㅠ          
		</div>
	
		<div class="plaza_detail_btn">
			<div class="btn_left">
				<span>좋아요</span>
			</div>
			<a href="${pageContext.request.contextPath}/br_plaza">
				<div class="btn_right">
					<span>목록</span>
				</div>
			</a>
		</div>
		
	</div>
	
	
	<%@ include file="../footer.jsp" %>
</body>
<script src="${pageContext.request.contextPath }/resources/js/header.js"></script>
<script>
$(function() {
	
	$(".btn_left").click(function() {
		alert("좋아요 클릭");
	})
})
</script>
</html>