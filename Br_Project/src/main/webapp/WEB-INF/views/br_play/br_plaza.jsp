<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		<c:forEach var="board" items="${boardList}">	
			<div class="plaza_item">
				<div class="plaza_item_header">
					<c:if test="${board.newMark}">
						<div class="plaza_item_header_new">NEW</div>
					</c:if>
					<div class="plaza_item_header_text">
						<h4>${board.title}</h4>
					</div>
				</div>
				<div class="plaza_item_content">
					${board.content}
				</div>
				<div class="plaza_item_writer">${board.writerId}님</div>
				<div class="plaza_item_footer">
					<div class="plaza_item_footer_img"></div>
					<div class="plaza_item_footer_detail">
						<a href="${pageContext.request.contextPath}/br_plaza_detail">자세히 보기</a>
						<form action="">
							<input type="hidden" name="board_idx" value="${board.boardIdx}"/>
						</form>
					</div>
				</div>
			</div>
		</c:forEach>		
		
		<input type="hidden" name="page_num" value="${pageNum}" />
		<input type="hidden" name="total_page_num" value="${totalPageNum}" />
		
	</div>
	
	
	<%@ include file="../footer.jsp" %>
</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.mousewheel.min.js"></script>
<script>
$(function() {
	
	const pathname = "/" + window.location.pathname.split("/")[1] + "/";
	const origin = window.location.origin;
	const contextPath = origin + pathname;
	
	let totalPageNum = parseInt( $("input[name='total_page_num']").val() );
	
	$(window).on("mousewheel", function(e, delta) {
		
		let pageNum = parseInt( $("input[name='page_num']").val() );
		
		// delta < 0 : 마우스휠 내릴 때 
		if(delta < 0) {
			
			if(pageNum <= totalPageNum) {
				alert("이벤트");
				$.ajax({
					type: "GET",
					async: true,
					url: contextPath + "/api/plaza",
					data: {
						pageNum: pageNum
					},
					dataType: "json",
					success: function(response) {
						console.log("success");
						response.forEach(board => {
							
							let newMark = board.newMark ? '<div class="plaza_item_header_new">NEW</div>' : '';
									
							let plazaBoard = 
								'<div class="plaza_item">' +
									'<div class="plaza_item_header">' +
										newMark +
										'<div class="plaza_item_header_text">' +
											'<h4>' + board.title + '</h4>' +
										'</div>' +
									'</div>'+
									'<div class="plaza_item_content">' +
										board.content +
									'</div>' +
									'<div class="plaza_item_writer">' + board.writerId + '님</div>' +
									'<div class="plaza_item_footer">' +
										'<div class="plaza_item_footer_img"></div>' +
										'<div class="plaza_item_footer_detail">' +
											'<a href="' + contextPath + '/br_plaza_detail">자세히 보기</a>' +
											'<form action="">' +
												'<input type="hidden" name="board_idx" value="' + board.boardIdx + '"/>' +
											'</form>' +
										'</div>'+
									'</div>' +
								'</div>' 
							;
								
							$(".plaza_container").append(plazaBoard);
							
						})
						
					}, error: function(response) {
						console.log("error");
					}, complete: function(response) {
						console.log("complete");
					}
				}) // ajax
				
				
			}// if문 - pageNum < totalPageNum
			
		}  // if문 - delta
		$("input[name='page_num']").val(++pageNum);
	}) // 휠 이벤트
	
	
	
	
})
</script>
</html>