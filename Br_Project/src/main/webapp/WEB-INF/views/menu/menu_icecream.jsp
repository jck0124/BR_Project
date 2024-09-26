<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu_icecream.css"/>
    <title>Document</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<!-- main_container -->
	<div id="main_container" class="center">
		<!-- 페이지 이동 -->
		<div id="menu_location">
			<a href="">이달의 맛</a>
			<a href="${pageContext.request.contextPath}/menu_icecream">아이스크림</a>
			<a href="${pageContext.request.contextPath}/menu_ice_cream_cake">아이스크림케이크</a>
			<a href="${pageContext.request.contextPath}/menu_drinks">음료</a>
		</div>
		<div id="icecream_container_header">
			<!-- iceCream header -->
			<div class="page_header">
				<div class="page_header_inner center">
					<h2 class="header_title">Ice Cream</h2>
					<div class="header_content">
						<p class="header_content_txt">
							한 입에 물면 달콤하게 사르르 녹는 아이스크림. <br/>
							당신이 어떤 기분이든 그 아이스크림을 따라 당신의 기분은 아마 달콤해졌을 거예요.
						</p>
					</div>
				</div>
			</div>
		</div>
		
		<!-- iceCream body -->
		<div id="div_menu" class="center">
			<div class="menu_list center">
				<ul class="menu_list_inner">
				<!-- 여기 -->
				<c:forEach var="icecream" items="${icecreamList}">
					<li class = "icecream">
						<div class="menu_list_inner_border" style="background-color: ${icecream.backgroundColor};"
						 data-background-color="${icecream.backgroundColor}">
							<a class="menu_btn" href="${pageContext.request.contextPath}/icecream_detail?icecreamIdx=${icecream.icecreamIdx}">
								<span class="menu_info" style="color: ${icecream.textColor};">${icecream.hashtag}</span>
								<img class="menu_img"src="${icecream.imgUrl}">
							</a>
						</div>
						<strong class="menu_name">${icecream.nameKor}</strong>
					</li>
				</c:forEach>
				
				</ul>
			</div>
		</div>
	</div>
	
	<%@ include file="../footer.jsp" %>

</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<!-- 처음 script 위치 설정 <script src="js/header.js"></script> -->
<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
<style>

</style>
<script>
$(function(){
	$(".menu_info").hide();
	$('.menu_list_inner_border').css('background-color', ''); 
	$(".menu_list_inner_border").hover(function() {
		/* mouse over */
		/* $(this).css('background-color', backgroundColor); */
        var backgroundColor = $(this).data('background-color');
        $(this).find(".menu_img").animate({ top: "90px" }, 100);
        $(this).css('background-color', backgroundColor);
        
        var menuInfo = $(this).find(".menu_info");
        menuInfo.css("top", "0px").show();  // 위치 초기화 후 표시
        menuInfo.animate({ top: "50px" }, 200);  // 애니메이션 실행
    }, function() {
    	/* mouse out */
    	/* $(this).css('background-color', ''); */
        $(this).find(".menu_img").animate({ top: "0" }, 100);
        $(this).find(".menu_info").hide();
        $(this).css('background-color', '');
    });
});
</script>
</html>