<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/payment.css"/>
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
    $(function() {
        // 아임포트 관리자의 가맹점 식별코드 설정
        IMP.init('imp31361047'); 

        // jQuery로 버튼 클릭 이벤트 등록
        $('#toss').on('click', function() {
            alert("하이");
            // IMP.request_pay 결제 모듈 호출
            IMP.request_pay({
                pg: 'tosspay', // PG사
                pay_method: 'card', // 결제수단
                name: '상품', // 상품명
                amount: ${totalPrice}, // 결제 금액
                buyer_name: '사용자'
            }, function(rsp) {
                if (rsp.success) {
                    // 결제 성공 시 서버로 결제 정보 전달
                	$.ajax({
                	    url: "https://jsonplaceholder.typicode.com/todos/1", // 간단한 JSON 응답
                	    type: 'GET',
                	    dataType: 'json',
                	    data : {
                	     }
                	    }
                	}).done(function(data) {
                	    console.log("AJAX 요청 성공:", data);
                	    window.location.href = "menu_icecream";
                	}).fail(function(jqXHR, textStatus, errorThrown) {
                	    console.log("AJAX 요청 실패:", textStatus, errorThrown);
                	});
                } else {
                    // 결제 실패 시
                    alert('결제에 실패하였습니다. 에러내용: ' + rsp.error_msg);
                }
            });
        });
    });
</script>
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
				<c:if test="${not empty menuInfoList}">
					<c:forEach var="menu" items="${menuInfoList}">
						<li>
							<div class="selected_menu fl">
								<div>${menu.name}</div>
							<!-- 	<div class="taste">맛
									<span>두바이스타일 초코통통,</span>
									<span>피치 Pang 망고 Pang,</span>
									<span>나주배 소르베,</span>
									<span>블루베리 파나코타</span>	
								</div> -->
							</div>
							<div class="option_info fr">
								<div class="count_box">
									주문수량 : <span class="order_num">${menu.count}</span>개
								</div>
								<div class="menu_price">
									<fmt:formatNumber value="${menu.price}" type="number" pattern="#,###"/>
									<span>원</span>
								</div>
							</div>
						</li>		
					</c:forEach>
				</c:if>
				<c:if test="${empty menuInfoList}">
   			 		<li>주문한 메뉴가 없습니다.</li>
				</c:if>
					<li>
						<div class="selected_menu fl">
							<div>무슨 맛이야?</div>
						<!-- 	<div class="taste">맛
								<span>두바이스타일 초코통통,</span>
								<span>피치 Pang 망고 Pang,</span>
								<span>나주배 소르베,</span>
								<span>블루베리 파나코타</span>	
							</div> -->
						</div>
						<div class="option_info fr">
							<div class="count_box">
								주문수량 : <span class="order_num">100</span>개
							</div>
							<div class="menu_price">
								<fmt:formatNumber value="500000" type="number" pattern="#,###"/>
								<span>원</span>
							</div>
						</div>
					</li>		
				</ul>
			</div>
			<div class="title_txt">결제금액</div>
				<div id="total_price"><fmt:formatNumber value="${totalPrice}" type="number" pattern="#,###"/></div>
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
								    <input type="text" id="postcode" placeholder="우편번호" readonly>
									<input type="button" onclick="daumPost()" value="우편번호 찾기">
								</td>
							</tr>
							<tr>
								<th>도로명주소</th>
								<td>
									<input type="text" id="address_txt" placeholder="주소" readonly><br>
								</td>
							</tr>
							<tr>
								<th>상세주소</th>
								<td>
									<input type="text" id="detail_address" placeholder="상세주소">
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="title_txt">요청사항</div>
			<div id="requirement_container">
				<textarea id="requirement"></textarea>
			</div>
		</div>
		
		<!-- 결제 정보 -->
		<div id="payment_container">
		
			<!-- 토스 페이 -->
			<button id="toss" class="btn_pay">
				<img src="${pageContext.request.contextPath}/resources/img/Toss_Logo_Primary.png">
			</button>
			<!-- 카카오 페이 -->
			<button id="kakao" class="btn_pay">
				<img src="${pageContext.request.contextPath}/resources/img/payment_kakao.png">
			</button>
			<!-- 나이스 페이 -->
			<button id="" class="btn_pay">
				<img src="${pageContext.request.contextPath}/resources/img/payment_nicepay.jpeg">
			</button>
			<button id="btn_cancel">취소</button>
			
		</div>
	</div>
	<%@ include file="../footer.jsp" %>

</body>
<!-- 처음 script 위치 설정 <script src="js/header.js"></script> -->
<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function daumPost() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기
                var addr = ''; // 주소 변수
                 //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져옴.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                } 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("postcode").value = data.zonecode;
                document.getElementById("address_txt").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detail_address").focus();
            }
        }).open();
    }
		
	$(function(){

		// 카카오페이 결제 팝업창 연결
		$("#kakao").click(function(){
			const pathname = "/" + window.location.pathname.split("/")[1] + "/";
			const origin = window.location.origin;
			const contextPath = origin + pathname;
			// 모든 ,를 찾아 삭제
			let totalPriceString = $("#total_price").text().replace(/,/g,'');
			let totalPrice = Number(totalPriceString);
			alert("totalPrice: "+totalPrice);
			// 결제 버튼 클릭 시 
			// 이름/ 배송지... 필수 정보 입력(유효성 검사)
			
			// @data 화면에서 입력받을 수 있는 기본 결제 정보만 넘겨주기 (나머지는 뒤에서 처리)
			// return 카카오톡 결제요청 페이지
			
			// 아래 데이터 외에도 필요한 데이터 원하는 대로 담고, Controller에서 @RequestBody로 받으면 됨.
			let data = {
					name: "상품명",	// 카카오페이에 보낼 대표 상품명
					totalPrice: totalPrice	// 총 결제금액
			};
			
			$.ajax({
				type: "POST",
				url: contextPath + "/api/payReady",
				data: JSON.stringify(data),
                contentType: 'application/json', 
                success: function(response) {
	            	console.log("컨트롤러로 요청 완료");
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