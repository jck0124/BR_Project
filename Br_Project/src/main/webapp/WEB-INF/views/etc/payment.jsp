<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/payment.css"/>
    <title>Document</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<!-- main_container -->
	<div id="main_container" class="center">
		<div id="payment_container_header">
			<!-- payment header -->
			<div class="page_header">
				<div class="page_header_inner center">
					<h2 class="header_title">결제</h2>
				</div>
			</div>
		</div>
		<div class="entire_container">
			<p class="header_content_txt">
				<img src="${pageContext.request.contextPath}/resources/img/logo_payment.png">
				<span>배스킨라빈스 이대역</span>
			</p>
			<div id="menu_container">
				<ul class="menu_box">
					<li>
						<div class="selected_menu fl">
							<div>[배달]파인트</div>
							<div class="taste">맛:
								<span>두바이스타일 초코통통,</span>
								<span>피치 Pang 망고 Pang,</span>
								<span>나주배 소르베,</span>
								<span>블루베리 파나코타</span>	
							</div>
						</div>
						<div class="option_info fr">
							<div class="count_box">
								주문수량 : <span class="order_num">1</span>개
							</div>
							<div class="menu_price">
								9,800<span>원</span>
							</div>
						</div>
					</li>
					<li>
						<div class="selected_menu fl">
							<div>[배달]파인트</div>
							<div class="taste">맛:
								<span>두바이스타일 초코통통,</span>
								<span>피치 Pang 망고 Pang,</span>
								<span>나주배 소르베,</span>
								<span>블루베리 파나코타</span>	
							</div>
						</div>
						<div class="option_info fr">
							<div class="count_box">
								주문수량 : <span class="order_num">1</span>개
							</div>
							<div class="menu_price">
								9,800<span>원</span>
							</div>
						</div>
					</li>
					<li>
						<div class="selected_menu fl">
							<div>바삭 민트초코 블라스트</div>
						</div>
						<div class="option_info fr">
							<div class="count_box">
								주문수량 : <span class="order_num">2</span>개
							</div>
							<div class="menu_price">
								5,800<span>원</span>
							</div>
						</div>
					</li>
					<li>
						<div class="selected_menu fl">
							<div>슬픔이의 기억구슬</div>
						</div>
						<div class="option_info fr">
							<div class="count_box">
								주문수량 : <span class="order_num">1</span>개
							</div>
							<div class="menu_price">
								30,000<span>원</span>
							</div>
						</div>
					</li>
				</ul>
		</div>
	</div>
		
	<!-- 결제 정보 -->
	<div id="payment_container">
		<button class="btn_pay">
			<img src="${pageContext.request.contextPath}/resources/img/payment_naver.svg">
		</button>
		<button class="btn_pay">
			<img src="${pageContext.request.contextPath}/resources/img/payment_kakao.png">
		</button>
		<button class="btn_pay">
			<img src="${pageContext.request.contextPath}/resources/img/payment_nicepay.png">
		</button>
		<button id="btn_cancel">취소</button>
	</div>
	</div>
	<%@ include file="../footer.jsp" %>

</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<!-- 처음 script 위치 설정 <script src="js/header.js"></script> -->
<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
</html>