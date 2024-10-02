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
		
		<div class="plaza_write">글쓰기</div>
		<div class="plaza_order">
			<span class="plaza_order_like">
				<a href="${pageContext.request.contextPath}/br_plaza?orderType=likes">추천순</a>
			</span>
			<span class="plaza_order_latest">
				<a href="${pageContext.request.contextPath}/br_plaza">최신순</a>
			</span>
		</div>
		
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
					</div>
					<input type="hidden" name="board_idx" value="${board.boardIdx}"/>
				</div>
			</div>
		</c:forEach>		
		
		<input type="hidden" name="order_type" value="${orderType}" />
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
		let orderType = $("input[name='order_type']").val();
		
		if(	checkScrollPosition() ) { // 스크롤 위치가 페이지의 상단 30% 아래
			
			if(delta < 0) { // delta < 0 : 마우스휠 내릴 때 
				
				if(pageNum < totalPageNum) {
					
					$.ajax({
						type: "GET",
						async: true,
						url: contextPath + "/api/plaza",
						data: {
							orderType : orderType,
							pageNum: pageNum + 1
						},
						dataType: "json",
						success: function(response) {
							console.log("추가 페이지 불러오기 success");
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
							console.log("추가 페이지 불러오기 error");
						}, complete: function(response) {
							console.log("추가 페이지 불러오기 complete");
						}
					}) // ajax
					
					$("input[name='page_num']").val(++pageNum);
					
				} // if문 - pageNum < totalPageNum
				
			}  // if문 - delta < 0
			
		} // checkScrollHalf
		
	}) // 휠 이벤트
	
	
	
	// 스크롤 위치
	function checkScrollPosition() {
		// 현재 스크롤 위치
	    const scrollTop = $(window).scrollTop();
	    
	    // 전체 문서의 높이
	    const documentHeight = $(document).height();
	    
	    // 현재 창의 높이
	    const windowHeight = $(window).height();
	    
	    // 스크롤이 페이지의 50%를 넘어섰는지 확인
	    if (scrollTop > (documentHeight - windowHeight) * 0.3) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	
	
	// 로그인 체크
	function loginCheck() {
		return new Promise(function(resolve, reject) {
			$.get(contextPath + "/api/loginCheck", function(response) {
				// 응답받으면 resolve
				resolve(response);
			})
			.fail(function() {
				// 요청이 실패한 경우
				reject("로그인 체크 실패");
			})
		})
	}
	
	// 추천수 올리기
	function increaseLikes(boardIdx) {
		return new Promise(function(resolve, reject) {
			$.get(
					contextPath + "/api/increaseLikes", 
					{boardIdx: boardIdx}, 
					function(response) {
						resolve(response);
			}) 
			.fail(function() {
				reject("추천수 올리기 실패");
			})
		})
	}
	
	
	
	
	// 글쓰기 버튼
	$(".plaza_write").click(async function() {
		
	    try {
	        let loginCheckResponse = await loginCheck();
	        if (loginCheckResponse) {
	            window.location.href = contextPath + "/br_plaza_write";
	        } else {
	            alert("로그인 후 이용가능합니다.");
	            window.location.href = contextPath + "/loginPage";
	        }
	        
	    } catch(error) {
	        console.log(error);
	    }
	    
	})
	
	
	// 추천 버튼
	$(".plaza_container").on("click", ".plaza_item_footer_img", async function(event) {
	    
	    // 클릭된 요소에 대한 참조
	    let $clickedElement = $(event.target);
	    
	    // 형제 input[name='board_idx'] 요소의 값을 가져옴
	    let boardIdx = $clickedElement.closest(".plaza_item_footer").find("input[name='board_idx']").val();
	    
	    try {
	        let loginCheckResponse = await loginCheck();
	        if (loginCheckResponse) {
	            let increaseLikesResponse = await increaseLikes(boardIdx);
	            alert("게시물을 추천했습니다!");
	        } else {
	            alert("로그인 후 이용가능합니다.");
	            window.location.href = contextPath + "/loginPage";
	        }
	        
	    } catch (error) {
	        console.log(error);
	    }
	});
	
	
})
</script>
</html>