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
    			<div id="choose_option_box">
    				<div id="option_box_inner">
    					<div class="option_type">
    						<div class="option_title">매장타입</div>
    						<div class="option_content">
    							<label>
    								<input type="checkbox" id="store_type_br" style="margin-top: 0;">
    								<span>BR31</span>
    							</label>
    							<label>
	    							<input type="checkbox" id="store_type_flavor">
	    							<span>100flavor</span>
    							</label>
    						</div>
    					</div>
    					<!-- 여기 -->
    					<div id="option_type2" class="option_type">
    						<div class="option_title">제공 서비스</div>
    						<div class="option_content">
    							<label>
	    							<input type="checkbox" id="parking" style="margin-top: 0;">
	    							<span>주차</span> 
    							</label>
    							<label>
	    							<input type="checkbox" id="delivery"> 
	    							<span>배달</span> 
    							</label>
    							<label>
	    							<input type="checkbox" id="pickup"> 
	    							<span>픽업</span> 
    							</label>
    							<label>
	    							<input type="checkbox" id="here"> 
	    							<span>취식여부</span> 
    							</label>
    							<label>
	    							<input type="checkbox" id="happy_station">
	    							<span>해피스테이션</span> 
    							</label>
    							<label>
	    							<input type="checkbox" id="blind_box">
	    							<span>가챠머신</span> 
    							</label>
    						</div>
    					</div>
    				</div>
    			</div>
   				<div class="select_city_box">
   					<select id="sel1" name="sel1"></select>
   					<select id="sel2" name="sel2"></select>
   				</div>
   				<div id="search_store">
   					<input type="text" id="store_search" name="store_name" placeholder="매장명">
   				</div>
   				<button type="submit" id="btn_search" class="btn_search">검색</button>
    		</div>
    		</form>
    		
    		<!-- 검색버튼 아래 사이드바 -->
    		<div id="side_bar_list">
    			<div class="search_result">
    				검색결과 <span class="pink_text" id="storeCount">${storeList.size()}</span>
    			</div>
    			<div id="map_list_container">
    				<ul id="ul_map_container">
   					<!-- 필터링 전 forEach문 -->
    				<c:forEach var="store" items="${storeList}" varStatus="status">
    					<li>
    						<a href="#" class="map_list" data-lat="${store.latitude}" data-lng="${store.longitude}">
	    						<div class="map_list_left">
	    							<h3>${store.storeName}</h3>
		    						<p>${store.address}</p>
		    						<p>${store.phone}</p>
		    						<p>${store.businessHours}</p>
	    						</div>
   							</a>
    					</li>
   					</c:forEach>
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
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- <script src="${pageContext.request.contextPath }/resources/js/store_map.js"></script> --> 
<script>
const pathname = "/" + window.location.pathname.split("/")[1] + "/";
const origin = window.location.origin;
const contextPath = origin + pathname;
$(document).ready(function(){
	$("#btn_search").click(function(event){
		event.preventDefault(event);
		
	   let storeTypeBrChecked = $("#store_type_br").is(":checked");
	   let storeTypeFlavor = $("#store_type_flavor").is(":checked");
	   let parkingChecked = $("#parking").is(":checked");
	   let deliveryChecked = $("#delivery").is(":checked"); 
	   let pickupChecked = $("#pickup").is(":checked");
	   let hereChecked = $("#here").is(":checked");
	   let happyStationChecked = $("#happy_station").is(":checked");
	   let blindBoxChecked = $("#blind_box").is(":checked");
	   let sel1Selected = $("#sel1").val();
	   let sel2Selected = $("#sel2").val();
	   let storeSearched = $("#store_search").val();
	   
	   alert("BR31: " +storeTypeBrChecked
			   + " 100flavor: " +storeTypeFlavor
			   + " parking: " +parkingChecked
			   + " delivery: " +deliveryChecked
			   + " pickup: " +pickupChecked
			   + " here: " +hereChecked
			   + " happySation: " +happyStationChecked
			   + " blindBoxChecked: " +blindBoxChecked
			   + " sel1: " +sel1Selected
			   + " sel2: " +sel2Selected
			   + " storeName: " + storeSearched
	   );
	   let param = {
			   storeTypeBrChecked: storeTypeBrChecked,
		        storeTypeFlavor: storeTypeFlavor,
		        parkingChecked: parkingChecked,
		        deliveryChecked: deliveryChecked,
		        pickupChecked: pickupChecked,
		        hereChecked: hereChecked,
		        happyStationChecked: happyStationChecked,
		        blindBoxChecked: blindBoxChecked,
		        sel1Selected: sel1Selected,
		        sel2Selected: sel2Selected,
		        storeSearched: storeSearched
	   }
	   let paramData = JSON.stringify(param);
 	   $.ajax({
		   type: "POST",
		   url: contextPath + "/filter/store",
		   data: paramData,
		  	contentType:'application/json',
		  	success: function(response) {
		  		// 확인용
			   console.log("paramData: "+ paramData),
		  		console.log("ajax응답: "+ JSON.stringify(response));
		  		let storeContainer = $("#ul_map_container");
		  		storeContainer.empty();	// 기존 리스트 비우기
		  		let storeCountContainer = $("#storeCount");
		  		storeCountContainer.empty();
		  		console.log("필터링된 스토어 리스트:", response.filteredStoreList);
		  		response.filteredStoreList.forEach(filteredStore => {
		  		    let filter = 
		  		    	'<li>' +
		  		    		'<a href="#" class="map_list" data-lat="' + filteredStore.latitude +'" data-lng="' + filteredStore.longitude +'">' +
		  		    			'<div class="map_list_left">' +
		  		    				'<h3>'+ filteredStore.storeName +'</h3>' +
		  		    				'<p>'+ filteredStore.address +'</p>' +
		  		   			 		'<p>'+ filteredStore.phone +'</p>' +
		  		    				'<p>'+ filteredStore.businessHours +'</p>' +
		  		    			'</div>' +
		  		    		'</a>' +
		  		    	'</li>'
		  		    	;
		  		    	storeContainer.append(filter);
		  		});
		  		let filterCountStore = response.filteredStoreList.length; // 크기 가져오기
                $("#storeCount").html(filterCountStore); // 검색 결과 수 업데이트
		  	},
		  	error: function(xhr, status, error) {
		  		console.error("ajax 필터링 요청 실패", status, error);
		  	}
	   }); 
	});
});

//카카오맵 API
document.addEventListener("DOMContentLoaded", function() {
	var imgSrc = 'https://www.baskinrobbins.co.kr/assets/images/store/map/icon_map_marker_default.png';
	var imgSize = new kakao.maps.Size(135, 106);	// 마커이미지의 크기.
	var imgOption = {offset: new kakao.maps.Point(0, 0)}; // 마커이미지의 옵션.
	var markerImage = new kakao.maps.MarkerImage(imgSrc, imgSize, imgOption);
	let infowindow; //전역 변수로 인포윈도우 선언
	
    var container = document.getElementById('store_map_field');
    var options = {
    	//지도의 중심 위치를 설정
        center: new kakao.maps.LatLng(37.5021082, 127.0259519),
        //지도 확대/축소 레벨을 설정
        level: 3
    };
	
    //container에 지도 요소가 삽입, options에 위에서 정의한 설정 전달
    var map = new kakao.maps.Map(container, options);
    
    let positions = [];
    <c:forEach var="store" items="${selectStore}">
        positions.push({
            title: '${store.storeName}',
            latlng: new kakao.maps.LatLng(${store.latitude}, ${store.longitude}),
            address: '${store.address}',
            phone: '${store.phone}',
            businessHours: '${store.businessHours}',
            typeBr: '${store.typeBr}',
            parking: '${store.parking}',
            delivery: '${store.delivery}',
            pickup: '${store.pickup}',
            here: '${store.here}',
            happyStation: '${store.happyStation}',
            blindBox: '${store.blindBox}'
        });
    </c:forEach>
	
	// 마커를 배열 단위로 묶음 (위 주석처리한 부분 통합)
    positions.forEach(function(position) {
        var marker = new kakao.maps.Marker({
            position: position.latlng,
            clickable: true, // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
            title: position.title,
            image: markerImage, // 변경된 이미지 사용
            map: map // 마커가 지도 위에 표시되도록 설정
        });
        
    	kakao.maps.event.addListener(marker, 'click', function() {
 		 // 이전 인포윈도우가 열려있다면 닫기
         if (infowindow) {
             infowindow.close();
         }	
         // 클릭 시 표시할 인포윈도우 내용
         var iwContent = '<form action="order_list" class="store_info_box">' + 
						    '<div><div>' + (position.typeBr==='T' ? 'Br 31' : '100flavor') + '</div></div>' + 
						    '<div>' + position.title + '</div>' +
						    '<div><span>매장주소</span> ' + position.address + '</div>' +
						    '<div><span>전화번호</span> ' + position.phone + '</div>' +
						    '<div><span>운영시간</span> ' + position.businessHours + '</div>' +
						    '<div><span>매장 서비스</span> '  + 
						    (position.parking==='T' ? '주차,' : '') +
						    (position.delivery==='T' ? '배달,' : '') +
						    (position.pickup==='T' ? '픽업,' : '') +
						    (position.here==='T' ? '취식,' : '') +
						    (position.happyStation==='T' ? '해피스테이션' : '')  +
						    (position.blindBox==='T' ? '가챠머신' : '') + '</div>' +
						    '<div class="close"  style="cursor: pointer;" ></div>' +
						    '<button type="submit" class="submit_button"> 상품 리스트로 이동 </button>'+
						    '<input type="hidden" name="storeName" value="' + position.title + '"/>'
						    '</form>';
	
                //iwRemoveable = true; // x 버튼이 표시되는 옵션

            // 인포윈도우 생성
            infowindow = new kakao.maps.InfoWindow({
                content: iwContent,
                removable: true,
            });
	        // 인포윈도우를 마커 위에 표시
	        infowindow.open(map, marker);   
	        
	     // 닫기 버튼 클릭 시 인포윈도우 닫기
	        const closeButton = document.querySelector('.close');
	        closeButton.addEventListener('click', function() {
	            infowindow.close();
	        });
    });
    
	//marker.setMap(map); // 마커가 지도 위에 표시되도록 설정
    });
	
	let storeContainer2 = $("#ul_map_container");
    storeContainer2.on("click", ".map_list", function(event) {
        event.preventDefault();

        let lat = $(this).data("lat");
        let lng = $(this).data("lng");


        let options = {
            center: new kakao.maps.LatLng(lat, lng),
            level: 3
        };
        // 지도 인스턴스 업데이트 
        map.setCenter(options.center);
    });	
    
});

//로그인 체크
$(document).ready(function() {
	// 동적으로 생성되는 .submit_button 요소에 대해 이벤트 위임 사용
	$(document).on('click', '.submit_button', function() {
		$.ajax({
			url: "http://localhost:9090/www/api/checkLoginStatus",
			dataType: "json",
			type: "GET",
			success: function(isLoggedIn) {
				console.log(isLoggedIn); // 값 확인
				if (isLoggedIn) {
					alert("로그인 상태입니다.");
				} else {
					alert("로그인이 필요합니다.");
					window.location.href = "loginPage";
				}
			},
			error: function() {
				alert("로그인 상태 확인 중 오류 발생.");
			}
		});
	});
});

$(function(){
	var option = 1;
	$("#choose_option_box").hide();
	$("#choose_option").click(function(){
		option += 1;
		if(option%2 == 0) {
			$("#choose_option_box").slideDown();
		} else {
			$("#choose_option_box").slideUp();
		}
	});
});

$( document ).ready(function(){
	   
	//테스트용 데이터
	var sel1 = {
    	" ":"도/시 선택",
    	"강원특별자치도" : "강원특별자치도",
        "경기" : "경기",
        "경남" : "경남", 
        "경북" : "경북", 
        "광주" : "광주", 
        "대구" : "대구", 
        "대전" : "대전", 
        "부산" : "부산", 
        "서울" : "서울", 
        "세종특별자치시" : "세종특별자치시", 
        "울산" : "울산", 
        "인천" : "인천", 
        "전남" : "전남", 
        "전북" : "전북", 
        "제주특별자치도" : "제주특별자치도", 
        "충남" : "충남", 
        "충북" : "충북"
    };
    
    //sel1이 강원도일경우
    var sel2_1 = {
   		" ":"구/군 선택",
       	"강릉시": "강릉시",
       	"고성군": "고성군",
       	"동해시": "동해시",
       	"삼척시": "삼척시",
       	"속초시": "속초시",
       	"양구군": "양구군",
       	"양양군": "양양군",
       	"영월군": "영월군",
       	"원주시": "원주시",
       	"인제군": "인제군",
       	"정선군": "정선군",
       	"철원군": "철원군",
       	"춘천시": "춘천시",
       	"태백시": "태백",
       	"평창군": "평창군",
       	"홍천군": "홍천군",
       	"화천군": "화천군",
       	"횡성군": "횡성군"
    };
    
    //sel1이 경기도일경우
    var sel2_2 = {
    	" ":"구/군 선택",
    	"가평군": "가평군",
    	"고양시" : "고양시", 
    	"과천시" : "과천시", 
    	"광명시" : "광명시", 
    	"광주시" : "광주시", 
    	"구리시" : "구리시", 
    	"군포시" : "군포시", 
    	"김포시" : "김포시", 
    	"남양주시" : "남양주시", 
    	"동두천시" : "동두천시", 
    	"부천시" : "부천시", 
    	"성남시" : "성남시", 
    	"수원시" : "수원시", 
    	"시흥시" : "시흥시", 
    	"안산시" : "안산시", 
    	"안성시" : "안성시", 
    	"안양시" : "안양시", 
    	"양주시" : "양주시", 
    	"양평군" : "양평군", 
    	"여주시" : "여주시", 
    	"연천군" : "연천군", 
    	"오산시" : "오산시", 
    	"용인시" : "용인시", 
    	"의왕시" : "의왕시", 
    	"의정부시" : "의정부시", 
    	"이천시" : "이천시", 
    	"파주시" : "파주시", 
    	"평택시" : "평택시", 
    	"포천시" : "포천시", 
    	"하남시" : "하남시", 
    	"화성시" : "화성시" 
    };
    
  //sel1이 경남일경우
   	var sel2_3 = {
  		" ":"구/군 선택",
       	"거제시": "거제시",	
       	"거창군": "거창군",	
       	"고성군": "고성군",	
       	"김해시": "김해시",	
       	"남해군": "남해군",	
       	"밀양시": "밀양시",	
       	"사천시": "사천시",	
       	"산청군": "산청군",	
       	"양산시": "양산시",	
       	"의령군": "의령군",	
       	"진주시": "진주시",	
       	"창녕군": "창녕군",	
       	"통영시": "통영시",	
       	"하동군": "하동군",	
       	"함안군": "함안군",	
       	"함양군": "함양군",	
       	"합천군": "합천군"
   	}
   	// sel1이 경북일 경우
   	var sel2_4 = {
  		" ":"구/군 선택",
       	"경산시": "경산시",	
       	"경주시": "경주시",	
       	"고령군": "고령군",	
       	"구미시": "구미시",	
       	"군위군": "군위군",	
       	"김천시": "김천시",	
       	"문경시": "문경시",	
       	"봉화군": "봉화군",	
       	"상주시": "상주시",	
       	"성주군": "성주군",	
       	"안동시": "안동시",	
       	"영덕군": "영덕군",	
       	"영양군": "영양군",	
       	"영주시": "영주시",	
       	"영천시": "영천시",	
       	"예천군": "예천군",	
       	"울릉군": "울릉군",	
       	"울진군": "울진군",	
       	"의성군": "의성군",	
       	"청도군": "청도군",	
       	"청송군": "청송군",	
       	"칠곡군": "칠곡군",	
       	"포항시": "포항시"
   	}
    // sel1이 광주일 경우
    var sel2_5 = {
  		" ":"구/군 선택",
       	"광산구": "광산구",	
       	"남구": "남구",	
       	"동구": "동구",	
       	"북구": "북구",	
       	"서구": "서구"	
   	}
    // sel1이 대구일 경우
    var sel2_6 = {
  		" ":"구/군 선택",
       	"남구": "",	
       	"달서구": "",	
       	"달성군": "",	
       	"동구": "",	
       	"북구": "",	
       	"서구": "",	
       	"수성구": "",	
       	"중구": ""	
   	}
    // sel1이 대전일 경우
    var sel2_7 = {
  		" ":"구/군 선택",
       	"대덕구": "대덕구",	
       	"동구": "동구",	
       	"서구": "서구",	
       	"유성구": "유성구",	
       	"중구": "중구"	
   	}
    // sel1이 부산일 경우
    var sel2_8 = {
  		" ":"구/군 선택",
       	"강서구": "강서구",	
       	"금정구": "금정구",	
       	"기장군": "기장군",	
       	"남구": "남구",	
       	"동구": "동구",	
       	"동래구": "동래구",	
       	"부산진구": "부산진구",	
       	"북구": "북구",	
       	"사상구": "사상구",	
       	"사하구": "사하구",	
       	"서구": "서구",	
       	"수영구": "수영구",	
       	"연제구": "연제구",	
       	"영도구": "영도구",	
       	"중구": "중구",	
       	"해운대구": "해운대구"
   	}
    // sel1이 서울일 경우
    var sel2_9 = {
  		" ":"구/군 선택",
       	"강남구": "강남구",	
       	"강동구": "강동구",	
       	"강북구": "강북구",	
       	"강서구": "강서구",	
       	"관악구": "관악구",	
       	"광진구": "광진구",	
       	"구로구": "구로구",	
       	"금천구": "금천구",	
       	"노원구": "노원구",	
       	"도봉구": "도봉구",	
       	"동대문구": "동대문구",	
       	"동작구": "동작구",	
       	"마포구": "마포구",	
       	"서대문구": "서대문구",	
       	"서초구": "서초구",	
       	"성동구": "성동구",	
       	"성북구": "성북구",	
       	"송파구": "송파구",	
       	"양천구": "양천구",	
       	"영등포구": "영등포구",	
       	"용산구": "용산구",	
       	"은평구": "은평구",	
       	"종로구": "종로구",	
       	"중구": "중구",	
       	"중랑구": "중랑구"
   	}
    // sel1이 세종특별자치시일 경우
    var sel2_10 = {
  		" ":"구/군 선택"	
   	}
    // sel1이 울산일 경우
    var sel2_11 = {
			" ":"구/군 선택",
       	"남구": "남구",	
       	"동구": "동구",	
       	"북구": "북구",	
       	"울주군": "울주군",	
       	"중구": "중구"
   	}
    // sel1이 인천일 경우
    var sel2_12 = {
  		" ":"구/군 선택",
       	"강화군": "강화군",	
       	"계양구": "계양구",	
       	"남동구": "남동구",	
       	"동구": "동구",	
       	"미추홀구": "미추홀구",	
       	"부평구": "부평구",	
       	"서구": "서구",	
       	"연수구": "연수구",	
       	"옹진군": "옹진군",	
       	"중구": "중구"
   	}
    // sel1이 전남일 경우
    var sel2_13 = {
  		" ":"구/군 선택",
       	"강진군": "강진군",	
       	"고흥군": "고흥군",	
       	"곡성군": "곡성군",	
       	"광양시": "광양시",	
       	"구례군": "구례군",	
       	"나주시": "나주시",	
       	"담양군": "담양군",	
       	"목포시": "목포시",	
       	"무안군": "무안군",	
       	"보성군": "보성군",	
       	"순천시": "순천시",	
       	"신안군": "신안군",	
       	"여수시": "여수시",	
       	"영광군": "영광군",	
       	"영암군": "영암군",	
       	"완도군": "완도군",	
       	"장성군": "장성군",	
       	"장흥군": "장흥군",	
       	"진도군": "진도군",	
       	"함평군": "함평군",	
       	"해남군": "해남군",	
       	"화순군": "화순군"
   	}
    // sel1이 전북일 경우
    var sel2_14 = {
  		" ":"구/군 선택",
       	"고창군": "고창군",	
       	"군산시": "군산시",	
       	"김제시": "김제시",	
       	"남원시": "남원시",	
       	"무주군": "무주군",	
       	"부안군": "부안군",	
       	"순창군": "순창군",	
       	"완주군": "완주군",	
       	"익산시": "익산시",	
       	"임실군": "임실군",	
       	"장수군": "장수군",	
       	"전주시": "전주시",	
       	"정읍시": "정읍시",	
       	"진안군": "진안군"
   	}
    // sel1이 제주특별자치도일 경우
    var sel2_15 = {
  		" ":"구/군 선택",
       	"서귀포시": "서귀포시",	
       	"제주시": "제주시"
   	}
    // sel1이 충남일 경우
    var sel2_16 = {
  		" ":"구/군 선택",
       	"계룡시": "계룡시",	
       	"공주시": "공주시",	
       	"금산군": "금산군",	
       	"논산시": "논산시",	
       	"당진시": "당진시",	
       	"보령시": "보령시",	
       	"부여군": "부여군",	
       	"서산시": "서산시",	
       	"서천군": "서천군",	
       	"아산시": "아산시",	
       	"예산군": "예산군",	
       	"천안시": "천안시",	
       	"청양군": "청양군",	
       	"태안군": "태안군",	
       	"홍성군": "홍성군"
   	}
    // sel1이 충북일 경우
    var sel2_17 = {
  		" ":"구/군 선택",
       	"괴산군": "괴산군",	
       	"단양군": "단양군",	
       	"보은군": "보은군",	
       	"영동군": "영동군",	
       	"옥천군": "옥천군",	
       	"음성군": "음성군",	
       	"제천시": "제천시",	
       	"증평군": "증평군",	
       	"진천군": "진천군",	
       	"청주시": "청주시",	
       	"충주시": "충주시"
   	}
    
   //sel1에 서버에서 받아온 값을 넣기위해..
   // map배열과 select 태그 id를 넘겨주면 option 태그를 붙여줌.
   // map[키이름] = 그 키에 해당하는 value를 반환한다.
   //retOption(데이터맵, select함수 id)
   function retOption(mapArr, select){
    	var html = '';
    	var keys = Object.keys(mapArr);
    	for (var i in keys) {
    	    html += "<option value=" + "'" + keys[i] + "'>" + mapArr[keys[i]] + "</option>";
    	}
        
        $("select[id='" + select +"']").html(html);
   }
   
   $("select[id='sel1']").on("change", function(){
    	var option = $("#sel1 option:selected").val();
        var subSelName = '';
    	if(option == "강원특별자치도") {
        	subSelName = "sel2_1";
        } else if(option == "경기"){
        	subSelName = "sel2_2";
        } else if(option == "경남"){
        	subSelName = "sel2_3";
        } else if(option == "경북"){
        	subSelName = "sel2_4";
        } else if(option == "광주"){
        	subSelName = "sel2_5";
        } else if(option == "대구"){
        	subSelName = "sel2_6";
        } else if(option == "대전"){
        	subSelName = "sel2_7";
        } else if(option == "부산"){
        	subSelName = "sel2_8";
        } else if(option == "서울"){
        	subSelName = "sel2_9";
        } else if(option == "세종특별자치시"){
        	subSelName = "sel2_10";
        } else if(option == "울산"){
        	subSelName = "sel2_11";
        } else if(option == "인천"){
        	subSelName = "sel2_12";
        } else if(option == "전남"){
        	subSelName = "sel2_13";
        } else if(option == "전북"){
        	subSelName = "sel2_14";
        } else if(option == "제주특별자치도"){
        	subSelName = "sel2_15";
        } else if(option == "충남"){
        	subSelName = "sel2_16";
        } else if(option == "충북"){
        	subSelName = "sel2_17";
        } else{
        	$("#sel2").hide();
        	return;
        }
        $("#sel2").show();
        retOption(eval(subSelName), "sel2");
    })
   retOption(sel1, "sel1");
	
});
</script>
</html>