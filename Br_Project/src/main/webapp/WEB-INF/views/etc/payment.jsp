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
			<div class="title_txt">주문내역</div>
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
			<div class="title_txt">결제금액</div>
			<div class="title_txt">주소</div>
			<div>
				<form name="form" id="form" method="post">
					<table id="address">
						<colgroup>
							<col style="width:20%"><col>
						</colgroup>
						<tbody>
							<tr>
								<th>우편번호</th>
								<td>
								    <input type="hidden" id="confmKey" name="confmKey" value=""  >
									<input type="text" id="zipNo" name="zipNo" readonly style="width:100px">
									<input type="button"  value="주소검색" onclick="goPopup();">
								</td>
							</tr>
							<tr>
								<th>도로명주소</th>
								<td><input type="text" id="roadAddrPart1" style="width:85%"></td>
							</tr>
							<tr>
								<th>상세주소</th>
								<td>
									<input type="text" id="addrDetail" style="width:40%" value="">
									<input type="text" id="roadAddrPart2"  style="width:40%" value="">
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
		
		<!-- 결제 정보 -->
		<div id="payment_container">
		
			<!-- 네이버 페이 -->
			<button id="" class="btn_pay">
				<img src="${pageContext.request.contextPath}/resources/img/payment_naver.svg">
			</button>
			<!-- 카카오 페이 -->
			<button id="kakao" class="btn_pay">
				<img src="${pageContext.request.contextPath}/resources/img/payment_kakao.png">
			</button>
			<!-- 나이스 페이 -->
			<button id="" class="btn_pay">
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
<script>
	$(function(){
		// 카카오페이 결제 팝업창 연결
		$("#kakao").click(function(){
			const pathname = "/" + window.location.pathname.split("/")[1] + "/";
			const origin = window.location.origin;
			const contextPath = origin + pathname;
			// 결제 버튼 클릭 시 
			// 이름/ 배송지... 필수 정보 입력(유효성 검사)
			
			// @data 화면에서 입력받을 수 있는 기본 결제 정보만 넘겨주기 (나머지는 뒤에서 처리)
			// return 카카오톡 결제요청 페이지
			
			alert("Kakao alert");
			console.log("kakao alert까지 왔음");
			
			// 아래 데이터 외에도 필요한 데이터 원하는 대로 담고, Controller에서 @RequestBody로 받으면 됨.
			let data = {
					name: "상품명",	// 카카오페이에 보낼 대표 상품명
					totalPrice: 5000	// 총 결제금액
			};
			
			$.ajax({
				type: "POST",
				url: contextPath + "/pay/ready",
			/* 	data: {
					/* item_name : "menu",
					quantity : "1",
					total_amount : "5000",
					tax_free_amount : "0" }, */
				data: JSON.stringify(data),
                contentType: 'application/json', 
                success: function(response) {
	            	console.log("성공적으로 컨트롤러로 요청 완료되었습니다.");
                	location.href = response.next_redirect_pc_url;
                },
	            error:function(xhr, status, error) {
	            	console.error("AJAX 요청 실패:", status, error);
	            }
			});
			 console.log("ajax 완료!");
		});
	});
</script>
</html>