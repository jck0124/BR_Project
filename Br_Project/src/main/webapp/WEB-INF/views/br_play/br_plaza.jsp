<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/br_plaza.css">
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
		<div>배라광장</div>
		<div>배라에게 묻고 배라가 답해드려요,</div>
		<div>배라에게 다양한 의견을 전달해주세요</div>
	</div>
	

	<div class="plaza_container">
		<% 
			for(int i = 0; i < 7; i++) {
		%>
			<div class="plaza_item">
				<div class="plaza_item_header">
					<div class="plaza_item_header_new">NEW</div>
					<div class="plaza_item_header_text">
						<h4>쿠키앤크림치즈</h4>
					</div>
				</div>
				<div class="plaza_item_content">
					쿠키앤크림치즈 2019년인가 20년에 첨 출시되었을 때 먿고 반해서 그 뒤로 그것만 엄청 먹다가 몇개월뒤에 사라져서 진짜 슬펐는데 언제부터 청다브라운이랑 삼성 파르나스몰 매장에 있길래 정말 행복했거든요ㅠㅠ♥
					근데 또 사라졌더라구요ㅠㅠㅠㅠ하프갤런에 그것만 다 담아서 사먹는 앤데 이제 안만드시나요?ㅜㅜㅜㅜ파르나스몰에라도 제발 그대로 해주세요ㅠ^ㅠssssssssss
				</div>
				<div class="plaza_item_writer">pde****님</div>
				<div class="plaza_item_footer">
					<div class="plaza_item_footer_img"></div>
					<div class="plaza_item_footer_detail">
						<a href="${pageContext.request.contextPath}/br_plaza_detail">자세히 보기</a>
					</div>
				</div>
			</div>
		<% 
			}
		%>
	</div>
	
	
	<%@ include file="../footer.jsp" %>
</body>
<script src="${pageContext.request.contextPath }/resources/js/header.js"></script>
</html>