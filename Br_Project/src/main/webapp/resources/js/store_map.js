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