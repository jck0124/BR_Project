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
<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=022e6a3260371b2c8dc3e8b1437a10c1"></script>
<script type="text/javascript">
	//카카오맵 API
    document.addEventListener("DOMContentLoaded", function() {
    	var imgSrc = 'https://www.baskinrobbins.co.kr/assets/images/store/map/icon_map_marker_default.png';
    	var imgSize = new kakao.maps.Size(135, 106);	// 마커이미지의 크기.
    	var imgOption = {offset: new kakao.maps.Point(0, 0)}; // 마커이미지의 옵션.
    	var markerImage = new kakao.maps.MarkerImage(imgSrc, imgSize, imgOption);
    	
        var container = document.getElementById('store_map_field');
        var options = {
        	//지도의 중심 위치를 설정
            center: new kakao.maps.LatLng(37.5021082, 127.0259519),
            //지도 확대/축소 레벨을 설정
            level: 3
        };
		
        //container에 지도 요소가 삽입, options에 위에서 정의한 설정 전달
        var map = new kakao.maps.Map(container, options);
        
        var positions = [
        	{
		        title: 'SPC스퀘어', 
		        latlng: new kakao.maps.LatLng(37.4943316, 127.0298345)
		    },
		    {
		        title: '강남대로', 
		        latlng: new kakao.maps.LatLng(37.5021082, 127.0259519)
		    },
		    {
		        title: '강남신논현', 
		        latlng: new kakao.maps.LatLng(37.5018395, 127.0246454)
		    },
		    {
		        title: 'cafe31서초우성',
		        latlng: new kakao.maps.LatLng(37.4926223, 127.0296532)
		    }
        ]
        
 		/*        
 		var markers = positions.map(function(position) {  // 마커를 배열 단위로 묶음
            return new kakao.maps.Marker({
                position : new kakao.maps.LatLng(position.lat, position.lng),
                title : position.title,
                image : markerImage
            });
        });
        
        for (var i = 0; i < positions.length; i ++) {
 		   
		    var marker = new kakao.maps.Marker({  // 마커 생성
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng, // 마커를 표시할 위치
		        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시 됨
		    });
		} */
		
		// 마커를 배열 단위로 묶음 (위 주석처리한 부분 통합)
	    positions.forEach(function(position) {
	        var marker = new kakao.maps.Marker({
	            position: position.latlng,
	            title: position.title,
	            image: markerImage, // 변경된 이미지 사용
	            map: map // 마커가 지도 위에 표시되도록 설정
	        });
	    });
        
		/* var marker = new kakao.maps.Marker({  // 마커 생성
		    position: markerPosition
		});

		 */
		
		marker.setMap(map); // 마커가 지도 위에 표시되도록 설정

		// 지도 위의 마커를 제거하는 코드
		// marker.setMap(null);
    });
</script>
</html>