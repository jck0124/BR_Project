<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/store_map.css"/>
</head>
<body>
	<%@ include file="../header.jsp" %>
    
    <!-- main_container -->
    <div id="main_container" class="center">
    	<div id="delivery_store">
    		<a href="">매장 찾기</a>
    		<a href="">100 flavor</a>
    		<a href="">Workshop</a>
    		<a href="">배달주문</a>
    		<a href="">단체주문</a>
    	</div>
    	<div id="delivery_store_header" class="center">
    		<div class="page_header">
				<div class="page_header_inner center">
					<h2 class="header_title center">Store</h2>
				</div>
			</div>
    	</div>
    </div>
    
    <!-- side bar -->
    <div id="map_container">
    	<div id="side_bar">
    		<form action="">
    		<div id="option_box">
    			<div id="choose_option">
    				<button type="button" class="btn_option">
    					옵션 선택
    				</button>
    			</div>
   				<div class="select_city_box">
   					<select id="sido" name="sido">
   						<option value="도/시 선택">도/시 선택</option>
   						<option value="강원특별자치도">강원특별자치도</option>
   						<option value="경기">경기</option>
   						<option value="경남">경남</option>
   						<option value="경북">경북</option>
   						<option value="광주">광주</option>
   						<option value="대구">대구</option>
   						<option value="대전">대전</option>
   						<option value="부산">부산</option>
   						<option value="서울">서울</option>
   						<option value="세종특별자치시">세종특별자치시</option>
   						<option value="울산">울산</option>
   						<option value="인천">인천</option>
   						<option value="전남">전남</option>
   						<option value="전북">전북</option>
   						<option value="제주특별자치도">제주특별자치도</option>
   						<option value="충남">충남</option>
   						<option value="충북">충북</option>
   					</select>
   					
   					<select id="gugoon" name="gugoon">
   					
   					</select>
   				</div>
   				<div id="search_store">
   					<input type="text" name="store_name" placeholder="매장명">
   				</div>
   				<button type="submit" class="btn_search">검색</button>
    		</div>
    		</form>
    		
    		<!-- 검색버튼 아래 사이드바 -->
    		<div id="side_bar_list">
    			<div class="search_result">
    				검색결과 <span class="pink_text">100</span>개
    			</div>
    			<div id="map_list_container">
    				<ul>
    				<c:forEach var="store" items="${storeList}">
    					<li>
    						<a href="" class="map_list">
	    						<div class="map_list_left">
	    							<h3>${store.storeName}</h3>
		    						<p>${store.address}</p>
		    						<p>${store.phone}</p>
		    						<p>${store.businessHours}</p>
	    						</div>
   							</a>
    					</li>
   					</c:forEach>
    					<li>
    						<a href="" class="map_list">
	    						<div class="map_list_left">
	    							<h3>강남대로</h3>
		    						<p>서울특별시 강남구 강남대로 442(역삼동)</p>
		    						<p>02-762-3917</p>
		    						<p>AM 10~PM 11</p>
	    						</div>
   							</a>
    					</li>
    					<li>
    						<a href="" class="map_list">
	    						<div class="map_list_left">
	    							<h3>강남신논현</h3>
		    						<p>서울특별시 서초구 강남대로 69길 8(서초동)</p>
		    						<p>02-532-0091</p>
		    						<p>AM 10~PM 11</p>
	    						</div>
   							</a>
    					</li>
    					<li>
    						<a href="" class="map_list">
	    						<div class="map_list_left">
	    							<h3>강남신논현</h3>
		    						<p>서울특별시 서초구 강남대로 69길 8(서초동)</p>
		    						<p>02-532-0091</p>
		    						<p>AM 10~PM 11</p>
	    						</div>
   							</a>
    					</li>
    				</ul>
    			</div>
    		</div>
    	</div>
   	
   		<div id="store_map_field"></div>
    </div>
    
	<%@ include file="../footer.jsp" %>
    
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</html>