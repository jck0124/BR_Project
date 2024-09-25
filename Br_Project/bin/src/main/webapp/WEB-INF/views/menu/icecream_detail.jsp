<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/icecream_detail.css"/>
	<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
    
    <!-- main_container -->
    <c:forEach var="detail" items="${icecreamDetail}">
   	<div id="main_container" class="center">
   		<div class="main_container_inner">
   			<div class="view_top">
   				<div class="menu_detail center">
   					<div class="menu_left">
   						<img src="https://www.baskinrobbins.co.kr/assets/images/menu/img_cone.png" class="cone">
   						<img src="https://www.baskinrobbins.co.kr/upload/product/main/a0d870dcebd8f9f20c33ab29c5668a66.png" class="icecream">
   					</div>
   					<div class="menu_right">
   						<div class="menu_right_top">
   							<p class="menu_type">ICECREAM</p>
   							<h2>
   								<span class="menu_eng">Would U Like Bon Bon</span>
   								<span class="menu_kor">우주 라이크 봉봉</span>
   							</h2>
   							<p class="menu_information">인기 플레이버의 역대급 만남!</p>
   						</div>
   						<div class="menu_ingredient">
   							<ul>
   								<li class="li_ingredient">
   									<img src="https://www.baskinrobbins.co.kr/upload/product/composition/296c9720ee97258f8be76a9b191b0a66.png">
   									<span>밀크초콜릿</span>
   								</li>
   								<li class="li_ingredient">
   									<img src="https://www.baskinrobbins.co.kr/upload/product/composition/cc908825caba4b5c41e3fbfb4e301fbb.png">
   									<span>바닐라</span>
   								</li>
   								<li class="li_ingredient">
   									<img src="https://www.baskinrobbins.co.kr/upload/product/composition/fb389ddc573f9a8d8358a442c2b180f8.png">
   									<span>초코<br/>아몬드</span>
   								</li>
   								<li class="li_ingredient">
   									<img src="https://www.baskinrobbins.co.kr/upload/product/composition/0e7263ec56267ff1c8abc2b4576ed101.png">
   									<span>초코<br/>프레첼</span>
   								</li>
   							</ul>
   						</div>
   					</div>
   				</div>
   			</div>
   			
   			<!-- 영양정보부터 -->
   			<div id="menu_view_container" class="center">
   				<div id="menu_view_inner">
   					<div id="nutrition_box">
   						<h3 class="fl">영양정보</h3>
   						<div class="nutrition_detail">
   							<div class="nutrition">
   								<div class="nutrition_title">1회 제공량</div>
   								<div class="nutrition_num">115</div>
   							</div>
   							<div class="nutrition">
   								<div class="nutrition_title">열량(kcal)</div>
   								<div class="nutrition_num">292</div>
   							</div>
   							<div class="nutrition">
   								<div class="nutrition_title">당류(g)</div>
   								<div class="nutrition_num">24</div>
   							</div>
   							<div class="nutrition">
   								<div class="nutrition_title">단백질(g)</div>
   								<div class="nutrition_num">5</div>
   							</div>
   							<div class="nutrition">
   								<div class="nutrition_title">포화지방(g)</div>
   								<div class="nutrition_num">8</div>
   							</div>
   							<div class="nutrition">
   								<div class="nutrition_title">나트륨(mg)</div>
   								<div class="nutrition_num">105</div>
   							</div>
   							<div class="nutrition">
   								<div class="nutrition_title">알레르기 성분</div>
   								<div class="nutrition_num">우튜,대두,밀</div>
   							</div>
   						</div>
   					</div>
   				</div>
   				
   				<div class="menu_article">
   					<div class="menu_article_inner">
   						<img src="https://www.baskinrobbins.co.kr/upload/ckeditor/e31f43b864524a4093bd722b49195b95.png">
   					</div>
   				</div>
   				<div id="menu_size_container">
   					<h3>SELECT SIZE</h3>
   					<div class="size_container">
   						<div class="cone_cup">
   							<h4 class="size_title fl">CONE & CUP</h4>
   							<ul>
   								<li class="li_size">
   									<img src="https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_c_1.jpg" class="size_img">
   									<div class="size_info_box">
   										<span class="size_name">싱글레귤러</span>
   										<span class="weight">1가지 맛 (중량 115g)</span>
   										<div class="size_price">
	   										<span class="price">3,900</span>
	   										<span class="won">원</span>
   										</div>
   									</div>
   								</li>
   								<li class="li_size">
   									<img src="https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_c_2.jpg" class="size_img">
   									<div class="size_info_box">
   										<span class="size_name">싱글킹</span>
   										<span class="weight">1가지 맛 (중량 145g)</span>
   										<div class="size_price">
	   										<span class="price">4,700</span>
	   										<span class="won">원</span>
   										</div>
   									</div>
   								</li>
   							</ul>
   						</div>
   						
   						<div class="hand_pack">
   							<h4 class="size_title fl">HAND PACK</h4>
   							<ul>
   								<li class="li_size">
   									<img src="https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_hp_1.jpg" class="size_img">
   									<div class="size_info_box">
   										<span class="size_name">파인트</span>
   										<span class="weight">3가지맛(중량 320g)</span>
   										<div class="size_price">
	   										<span class="price">9,800</span>
	   										<span class="won">원</span>
   										</div>
   									</div>
   								</li>
   								<li class="li_size">
   									<img src="https://www.baskinrobbins.co.kr/assets/images/menu/icon_size_hp_1.jpg" class="size_img">
   									<div class="size_info_box">
   										<span class="size_name">쿼터</span>
   										<span class="weight">4가지맛(중량 620g)</span>
   										<div class="size_price">
	   										<span class="price">18,500</span>
	   										<span class="won">원</span>
   										</div>
   									</div>
   								</li>
   							</ul>
   						</div>
   						<p class="size_info">
   							* 일부 제품에 한해 가격이 상이할 수 있습니다.
   						</p>
   					</div>
   				</div>
   				
   				<div id="menu_recommend">
   					<div class="recommend_header">관련상품</div>
   					<div class="recommend_container">
   						<div class="recommend_menu">
   							<div class="menu_inner">
   								<a href="" class="">
   									<img src="">
   									
   								</a>
   							</div>
   						</div>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	</c:forEach>
   	
   	<%@ include file="../footer.jsp" %>
   	
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<!-- 처음 script 위치 설정 <script src="js/header.js"></script> -->
<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
</html>