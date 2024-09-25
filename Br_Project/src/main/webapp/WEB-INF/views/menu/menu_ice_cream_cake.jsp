<%@page import="java.util.ArrayList"%>
<%@page import="com.br.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu_ice_cream_cake.css">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script>
	$(function() {
		
		// 케이크 이미지 호버 
	    $('.cakeImg').hover(
	        function() {
	        	let backgroundColor = $(this).find('.backgroundColor').text();
	            //alert(backgroundColor);
	        	// 마우스를 올렸을 때 실행
	            $(this).css('background-color', backgroundColor);
	            $(this).find('img').animate({
	                top: '40px'  // img 태그를 20px 위로 이동
	            }, 500 );
	            $(this).find('.tag').css('display', 'block');
	        },
	        function() {
	            // 마우스를 뗐을 때 실행
	            $(this).css('background-color', '');
	            $(this).find('img').animate({
	                top: '0px'  
	            });;
	            $(this).find('.tag').css('display', 'none');
	        }
	    );
	});
	</script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<!-- 페이지 이동 -->
	<div id="menu_location">
		<a href="">이달의 맛</a>
		<a href="${pageContext.request.contextPath}/menu_icecream">아이스크림</a>
		<a href="${pageContext.request.contextPath}/menu_ice_cream_cake">아이스크림케이크</a>
		<a href="${pageContext.request.contextPath}/menu_drinks">음료</a>
	</div>
	
	<!-- 아이스크림 케이크 소개 -->
	<div id="iceCreamCake">
		<div>Ice Cream Cake</div>
		<div>축하하고 싶은 날에도, 위로가 필요한 날에도, 그 모든 순간 함께 할 아이스크림 케이크.</div>
		<div>달콤한 아이스크림 케이크로 당신의 특별한 날을 더욱더 특별하게 만들어드릴게요.</div>
	</div>
	
	<!-- 상품 -->
	<div id="product">
		<c:forEach var="cake" items="${cakesList}">
			<a href="ice_cream_cake_detail?korName=${cake.name}" class="iceCreamCakeProduct fl">
				<div class="cakeImg">
					<div class="tag">${cake.tag}</div>
					<img src="${cake.img}" alt="아이스크림 케이크"/>
					<div class="backgroundColor">${cake.backgroundColor}</div>
				</div>
				<div>${cake.name}</div>
			</a>
		</c:forEach>
		<div style="clear:both"></div>
	</div>
	
	<c:if test="${cakesList == null}">
    	<div>No cakes found.</div>
	</c:if>
	
	<c:set var="startNum" value="${startNum != null && startNum >= 0 ? startNum : 1}" />
	<c:set var="endNum" value="${endNum != null && endNum >= 0 ? endNum : 1}" />

	
	<div id="pagination">
		<c:forEach var="i" begin="${startNum}" end="${endNum}">
			<c:choose>
				<c:when test="${i != pageNum}">
                	<a href="menu_ice_cream_cake?page=${i}">${i}</a>
	            </c:when>
	            <c:otherwise>
	                <strong>${i}</strong> <!-- 현재 페이지는 강조 -->
	            </c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${endNum < lastPageNum}">
	        <a id="next" href="menu_ice_cream_cake?page=${endNum + 1}">&gt;</a>
	    </c:if>
	</div>
	
	<%@ include file="../footer.jsp" %>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
</html>