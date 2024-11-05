<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/br_recipe.css"/>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
    <!-- main_container -->
    <div id="main_container" class="center">
    	<div id="br_play">
    		<a href="${pageContext.request.contextPath}/event">이벤트</a>
    		<a href="${pageContext.request.contextPath}/br_plaza">배라광장</a>
    		<a href="${pageContext.request.contextPath}/br_recipe">BR 레시피</a>
    		<a href="">마이플레이버 리스트</a>
    	</div>
    	<div id="br_recipe_header" class="center">
			<!-- iceCream header -->
			<div class="page_header">
				<div class="page_header_inner center">
					<h2 class="header_title">BR Recipe</h2>
					<div class="header_content">
						<p class="header_content_txt">
							다양한 전문가들이 제안하는 배라 행복레시피
						</p>
					</div>
				</div>
			</div>
		</div>
		
		<div id="recipe_container" class="center">
			<div class="tab center">
			  <button class="tablinks" onclick="openCity(event, 'entire')" id="defaultOpen">전체</button>
			  <button class="tablinks" onclick="openCity(event, 'chef_pastry')">셰프 & 파티시에</button>
			  <button class="tablinks" onclick="openCity(event, 'barista')">바리스타 & 바텐더</button>
			  <button class="tablinks" onclick="openCity(event, 'artist')">아티스트</button>
			  <button class="tablinks" onclick="openCity(event, 'influencer')">인플루언서</button>
			</div>
		
			<div id="entire" class="tabcontent center">
				<ul class="card_list">
					<c:forEach var="recipe" items="${recipeList}">
					<li>
						<a href="#">
						   <c:choose>
				                <c:when test="${fn:startsWith(recipe.imgUrl, 'https')}">
				                    <img src="${recipe.imgUrl}">
				                </c:when>
				                <c:otherwise>
				                    <img src="${pageContext.request.contextPath}/br_recipe/img?recipeIdx=${recipe.recipeIdx}">
				                </c:otherwise>
            				</c:choose>
							<div class="card_container">
								<div class="card_title">
									${recipe.categoryName}
								</div>
								<div class="card_list_eng">
									${recipe.titleEng}
								</div>
								<div class="card_list_kor">
									${recipe.titleKor}
								</div>
							</div>
						</a>
					</li>
					</c:forEach>
			</div>
			<div id="chef_pastry" class="tabcontent center">
				<ul class="card_list">
					<c:forEach var="recipe" items="${recipeList}">
						<c:if test="${recipe.categoryIdx == 1}">
						<li>
							<a href="#">
								<c:choose>
					                <c:when test="${fn:startsWith(recipe.imgUrl, 'https')}">
					                    <img src="${recipe.imgUrl}">
					                </c:when>
					                <c:otherwise>
					                    <img src="${pageContext.request.contextPath}/br_recipe/img?recipeIdx=${recipe.recipeIdx}">
					                </c:otherwise>
            					</c:choose>
								<div class="card_container">
									<div class="card_title">
										${recipe.categoryName}
									</div>
									<div class="card_list_eng">
										${recipe.titleEng}
									</div>
									<div class="card_list_kor">
										${recipe.titleKor}
									</div>
								</div>
							</a>
						</li>
					</c:if>
					</c:forEach>
				</ul>
				
				<!-- pagination -->
				<nav class="pagination">
					<div class="pagination_inner">
						<span class="pagination_num">1</span>
					</div>
				</nav>
			</div>
			<div id="barista" class="tabcontent center">
				<ul class="card_list">
				<c:forEach var="recipe" items="${recipeList}">
					<c:if test="${recipe.categoryIdx == 2}">
					<li>
						<a href="#">
							<c:choose>
				                <c:when test="${fn:startsWith(recipe.imgUrl, 'https')}">
				                    <img src="${recipe.imgUrl}">
				                </c:when>
				                <c:otherwise>
				                    <img src="${pageContext.request.contextPath}/br_recipe/img?recipeIdx=${recipe.recipeIdx}">
				                </c:otherwise>
            				</c:choose>
							<div class="card_container">
								<div class="card_title">
									${recipe.categoryName}
								</div>
								<div class="card_list_eng">
									${recipe.titleEng}
								</div>
								<div class="card_list_kor">
									${recipe.titleKor}
								</div>
							</div>
						</a>
					</li>
					</c:if>					
				</c:forEach>
				</ul>
				
				<!-- pagination -->
				<nav class="pagination">
					<div class="pagination_inner">
						<span class="pagination_num">1</span>
					</div>
				</nav>
			</div>
			<div id="artist" class="tabcontent center">
				<ul class="card_list">
				<c:forEach var="recipe" items="${recipeList}">
					<c:if test="${recipe.categoryIdx == 3}">
					<li>
						<a href="#">
							<c:choose>
				                <c:when test="${fn:startsWith(recipe.imgUrl, 'https')}">
				                    <img src="${recipe.imgUrl}">
				                </c:when>
				                <c:otherwise>
				                    <img src="${pageContext.request.contextPath}/br_recipe/img?recipeIdx=${recipe.recipeIdx}">
				                </c:otherwise>
            				</c:choose>
							<div class="card_container">
								<div class="card_title">
									${recipe.categoryName}
								</div>
								<div class="card_list_eng">
									${recipe.titleEng}
								</div>
								<div class="card_list_kor">
									${recipe.titleKor}
								</div>
							</div>
						</a>
					</li>
					</c:if>					
				</c:forEach>
				</ul>
				
				<!-- pagination -->
				<nav class="pagination">
					<div class="pagination_inner">
						<span class="pagination_num">1</span>
					</div>
				</nav>
			</div>
			<div id="influencer" class="tabcontent center">
				<ul class="card_list">
				<c:forEach var="recipe" items="${recipeList}">
					<c:if test="${recipe.categoryIdx == 4}">
					<li>
						<a href="#">
							 <c:choose>
				                <c:when test="${fn:startsWith(recipe.imgUrl, 'https')}">
				                    <img src="${recipe.imgUrl}">
				                </c:when>
				                <c:otherwise>
				                    <img src="${pageContext.request.contextPath}/br_recipe/img?recipeIdx=${recipe.recipeIdx}">
				                </c:otherwise>
            				</c:choose>
							<div class="card_container">
								<div class="card_title">
									${recipe.categoryName}
								</div>
								<div class="card_list_eng">
									${recipe.titleEng}
								</div>
								<div class="card_list_kor">
									${recipe.titleKor}
								</div>
							</div>
						</a>
					</li>
					</c:if>					
				</c:forEach>
				</ul>
				
				<!-- pagination -->
				<nav class="pagination">
					<div class="pagination_inner">
						<span class="pagination_num">1</span>
					</div>
				</nav>
			</div>
		</div>
    </div>
    
    <%@ include file="../footer.jsp" %>
</body>
<script>
	function openCity(evt, cityName) {
	  var i, tabcontent, tablinks;
	  tabcontent = document.getElementsByClassName("tabcontent");
	  for (i = 0; i < tabcontent.length; i++) {
	    tabcontent[i].style.display = "none";
	  }
	  tablinks = document.getElementsByClassName("tablinks");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }
	  document.getElementById(cityName).style.display = "block";
	  evt.currentTarget.className += " active";
	}
	
	// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();
</script>
</html>