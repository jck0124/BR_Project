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
			<div class="plaza_detail_menu_name">${pDto.title}</div>
			<div class="plaza_detail_witer">이름</div>
			<div class="plaza_detail_witer_name">${pDto.writerName}</div>
		</div>
		
		<div class="plaza_detail_content">
			${pDto.content}          
		</div>
	
		<div class="plaza_detail_btn">
			<div class="btn_left">
				<span>좋아요</span>
				<input type="hidden" name="board_idx" value="${pDto.boardIdx}"/>
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
	
	const pathname = "/" + window.location.pathname.split("/")[1] + "/";
	const origin = window.location.origin;
	const contextPath = origin + pathname;
	
	// 추천 버튼 누르기	
	$(".btn_left").click(async function() {
		let boardIdx = $("input[name='board_idx']").val();
		
		try{
			let loginCheckResponse = await loginCheck();
			if(loginCheckResponse) {
				let increaseLikesResponse = await increaseLikes(boardIdx);
				alert("게시물을 추천했습니다!");
			} else {
				alert("로그인 후 이용가능합니다.");
				window.location.href = contextPath + "loginPage";
			}
		} catch(error) {
			console.log(error);
		}
		
	})
	
	
	// 로그인 여부 체크
	function loginCheck() {
		return new Promise(function(resolve, reject) {
			$.get(contextPath + "api/checkLoginStatus", function(response) {
				resolve(response);
			})
			.fail(function() {
				reject("로그인 체크 실패");
			})
		})
	}
	
	// 추천수 올리기
	function increaseLikes(boardIdx){
		return new Promise(function(resolve, reject) {
			$.get(
				contextPath + "api/increaseLikes",
				{boardIdx: boardIdx},
				function(response){
					resolve(response);
				}
			)
			.fail(function() {
				reject("추천수 올리기 실패");
			})
		})
	}
	
	
	
	
	
	
	
	
	
})
</script>
</html>