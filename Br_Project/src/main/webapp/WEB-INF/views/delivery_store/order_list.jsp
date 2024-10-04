<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu_icecream.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu_ice_cream_cake.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu_drinks.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/order_list.css">
<title>Insert title here</title>
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
<script>
$(document).ready(function() {
    let selectedSize = '';  // 선택한 사이즈를 저장할 변수
    let selectedFlavors = [];  // 선택한 맛들을 저장할 배열
    let maxFlavors = 0;  // 선택 가능한 최대 맛 개수

    // 사이즈 선택 시 이벤트 처리
    $('#sizeSelect').change(function() {
        selectedSize = $(this).val();
        updateSelectedSizeDisplay();

        // 사이즈에 따른 최대 선택 가능 맛 수 설정
        if (selectedSize === 'pint') {
            maxFlavors = 3;
        } else if (selectedSize === 'quarter') {
            maxFlavors = 4;
        } else if (selectedSize === 'family') {
            maxFlavors = 5;
        } else if (selectedSize === 'gallon') {
            maxFlavors = 6;
        } else {
            maxFlavors = 0;
        }

        // 사이즈가 선택되면 맛 선택과 추가 버튼 활성화
        if (selectedSize) {
            $('#flavorSelect').prop('disabled', false);
            $('#addFlavorButton').prop('disabled', false);
        } else {
            $('#flavorSelect').prop('disabled', true);
            $('#addFlavorButton').prop('disabled', true);
        }
    });

    // 맛 추가 버튼 클릭 시 이벤트 처리
    $('#addFlavorButton').click(function() {
        const selectedFlavor = $('#flavorSelect').val();

        // 선택한 맛이 있고, 이미 선택되지 않았으며, 최대 개수 미만일 때만 추가
        if (selectedFlavor && !selectedFlavors.includes(selectedFlavor)) {
            if (selectedFlavors.length < maxFlavors) {
                selectedFlavors.push(selectedFlavor);
                updateSelectedFlavorsDisplay();
            } else {
                alert(`최대 ${maxFlavors}가지 맛을 선택할 수 있습니다.`);
            }
        } else if (selectedFlavor) {
            alert('이미 선택된 맛입니다.');
        }
    });

    // 선택된 사이즈 화면에 표시
    function updateSelectedSizeDisplay() {
        $('#selectedSize').text('선택된 사이즈: ' + (selectedSize || '없음'));
    }

    // 선택된 맛들을 화면에 표시하는 함수
    function updateSelectedFlavorsDisplay() {
        $('#selectedFlavors').text('선택된 맛: ' + (selectedFlavors.length > 0 ? selectedFlavors.join(', ') : '없음'));
    }
});
</script>
</head>
<body>
<%@ include file="../header.jsp" %>
	<form action="">
	<div id="store_info">
		<div>주문 페이지</div>
		<div>${storeName} 베스킨라빈스</div>
	</div>
	
	<div id="icecream_container_header" style="margin: 0 auto; margin-top: 100px;">
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
		
		<div id="icecream_check">
			<select name="size" id="sizeSelect">
				<option> 크기를 선택하세요 </option>
				<option value="pint" value2="9800">파인트 : 3가지맛 (9,800원)</option>
				<option value="quarter" value2="18500">쿼터 : 4가지맛 (18,500원)</option>
				<option value="family" value2="26000">패밀리 : 5가지맛 (26,000원)</option>
				<option value="gallon" value2="31500">하프갤론 : 6가지맛 (31,500원)</option>
			</select>
			<select name="flavor" id="flavorSelect" disabled multiple>
				<option>맛을 선택하세요</option>
				<c:forEach var="icecream" items="${products.icecreams}">
					<option value="${icecream.nameKor}">${icecream.nameKor}</option>
				</c:forEach>
			</select>
			
			 <button type="button" id="addFlavorButton" disabled>맛 추가</button>

		    <!-- 선택된 값들 표시 -->
		    <div id="selectedSize">선택된 사이즈: 없음</div>
		    <div id="selectedFlavors">선택된 맛: 없음</div>
		</div>
		
		<!-- iceCream body -->
		<div id="div_menu" class="center">
			<div class="menu_list center">
				<ul class="menu_list_inner">
				<!-- 여기 -->
				<c:forEach var="icecream" items="${products.icecreams}">
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
		
		<!-- 아이스크림 케이크 소개 -->
		<div id="iceCreamCake">
			<div>Ice Cream Cake</div>
			<div>축하하고 싶은 날에도, 위로가 필요한 날에도, 그 모든 순간 함께 할 아이스크림 케이크.</div>
			<div>달콤한 아이스크림 케이크로 당신의 특별한 날을 더욱더 특별하게 만들어드릴게요.</div>
		</div>
		
		<!-- 상품 -->
		<div id="product">
			<c:forEach var="cake" items="${products.iceCreamCakes}">
				<div class="product_box">
					<a href="ice_cream_cake_detail?korName=${cake.name}" class="iceCreamCakeProduct fl">
						<div class="cakeImg">
							<div class="tag">${cake.tag}</div>
							<img src="${cake.img}" alt="아이스크림 케이크"/>
							<div class="backgroundColor">${cake.backgroundColor}</div>
						</div>
						<div>${cake.name}</div>
					</a>
					<div class="count">
						<button type="button">-</button>
						<input type="text" value="0"/>
						<button type="button">+</button>
					</div>
				</div>
			</c:forEach>
			<div style="clear:both"></div>
		</div>
		
		<!-- 아이스크림 케이크 소개 -->
		<div id="iceCreamCake">
			<div>Beverage</div>
			<div>짜릿하게 시원한 블라스트부터 아이스크림을 듬뿍넣고 갈아만든 쉐이크까지!.</div>
			<div>배스킨라빈스만의 특별함을 음료로 만나보세요.</div>
		</div>
		
	
		<div id="product">
			<c:forEach var="drink" items="${products.drinks}">
				<div class="product_box">
					<a href="${pageContext.request.contextPath}/menu_drinks_detail?drinksIdx=${drink.drinksIdx}" class="iceCreamCakeProduct fl">
						<div class="cakeImg">
							<div class="tag" style="color: ${drink.fontColor}">${drink.tag}</div>
							<img src="${drink.img}" alt="음료"/>
							<div class="backgroundColor">${drink.backgroundColor}</div>
						</div>
						<div style="color: #999999">${drink.name}</div>
					</a>
					<div class="count">
						<button type="button">-</button>
						<input type="text" value="0"/>
						<button type="button">+</button>
					</div>
				</div>
			</c:forEach>
			<div style="clear:both"></div>
		</div>
		<button type="submit">제출</button>
		</form>
		
<%@ include file="../footer.jsp" %>		
</body>
</html>