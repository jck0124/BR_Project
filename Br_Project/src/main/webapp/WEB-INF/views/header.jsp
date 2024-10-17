<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
<title>Insert title here</title>
</head>
<body>


	<!-- search_active- -->
    <header class="">

        <div class="header_inner">

            <div class="header_left">

                <div class="header_logo">
                    <a href="${pageContext.request.contextPath}/menu_icecream">
                        <img src="${pageContext.request.contextPath}/resources/img/h_logo_white.png" alt="">
                    </a>
                </div>

                <div class="header_menu_list">


                    <div class="header_menu header_menu1">
                        <a href="${pageContext.request.contextPath}/menu_icecream">Menu</a>

                        <div class="header_menu_hover">
                            <div class="header_menu_hover_inner">

                                <div class="header_menu1_hover">
                                    <div>
                                        <a href="">이달의 맛</a>
                                    </div>
                                    <div>
                                        <a href="${pageContext.request.contextPath}/menu_icecream">아이스크림</a>
                                    </div>
                                    <div>
                                        <a href="${pageContext.request.contextPath}/menu_ice_cream_cake">아이스크림케이크</a>
                                    </div>
                                    <div>
                                        <a href="${pageContext.request.contextPath}/menu_drinks">음료</a>
                                    </div>
                                </div>

                            </div>
                        </div>       

                    </div>

                    <div class="header_menu header_menu2">
                        <a href="${pageContext.request.contextPath}/event">BR Play</a>

                        <div class="header_menu_hover">
                            <div class="header_menu_hover_inner">

                                <div class="header_menu2_hover"> 
                                    <div class="header_menu2_hover_left"> 
                                        <div>
                                            <a href="${pageContext.request.contextPath}/event">이벤트</a>
                                        </div>
                                        <div>
                                            <div>
                                                <a href="${pageContext.request.contextPath}/event">프로모션</a>
                                            </div>
                                            <div>
                                                <a href="${pageContext.request.contextPath}/event">제휴혜택</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="header_menu2_hover_right">
                                        <div>
                                            <a href="${pageContext.request.contextPath}/br_plaza">BR Play</a>
                                        </div>
                                        <div>
                                            <div>
                                                <a href="${pageContext.request.contextPath}/br_plaza">배라광장</a>
                                            </div>
                                            <div>
                                                <a href="${pageContext.request.contextPath}/br_recipe">BR레시피</a>
                                            </div>
                                            <div>
                                                <a href="">마이플레이버리스트</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>  

                    </div>

                    <div class="header_menu header_menu3">
                        <a href="">BR Story</a>

                        <div class="header_menu_hover">
                            <div class="header_menu_hover_inner">
                                
                                <div class="header_menu3_hover"> 
                                    <div>
                                        <a href="">브랜드 스토리</a>
                                    </div>
                                    <div>
                                        <a href="">이달의 맛 히스토리</a>
                                    </div>
                                    <div>
                                        <a href="">Be Better</a>
                                    </div>
                                </div>

                            </div>
                        </div> 

                    </div>

                    <div class="header_menu header_menu4">
                        <a href="${pageContext.request.contextPath}/store_map">Delivery/Store</a>

                        <div class="header_menu_hover">
                            <div class="header_menu_hover_inner">
                                
                                <div class="header_menu4_hover">
                                    <div class="header_menu4_hover_left">
                                        <div>
                                            <a href="${pageContext.request.contextPath}/store_map">Store</a>
                                        </div>
                                        <div>
                                            <div>
                                                <a href="${pageContext.request.contextPath}/store_map">매장 찾기</a>
                                            </div>
                                            <div>
                                                <a href="">100flavor 플래그십스토어</a>
                                            </div>
                                            <div>
                                                <a href="">워크샵 by 배스킨라빈스</a>
                                            </div>
                                            <div>
                                                <a href="">점포개설문의</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="header_menu4_hover_right">
                                        <div>
                                            <a href="">Delivery</a>
                                        </div>
                                        <div>
                                            <div>
                                                <a href="">배달주문</a>
                                            </div>
                                            <div>
                                                <a href="">단체주문</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div> 

                    </div>

                </div>
            </div>

            <div class="header_right">
                <div class="header_search">
                    <img src="${pageContext.request.contextPath}/resources/img/btn_search_white.png" alt="">
                </div>
                <div class="header_login">
                    <img src="${pageContext.request.contextPath}/resources/img/btn_user_menu_white.png" alt="">
					
					<c:choose>
						<c:when test="${sessionScope.loginId != null}">
						 	<!-- 로그인 상태 -->
		                    <div class="header_login_menu">
		                        <a href="${pageContext.request.contextPath}/logout">
		                            <div class="header_login_list">Logout</div>
		                        </a>
		                        <a href="">
		                            <div class="header_login_list">My Page</div>
		                        </a>
		                        <a href="">
		                            <div class="header_login_list">CS CENTER</div>
		                        </a>
		                        <a href="${pageContext.request.contextPath}/manager" id="managerPage">
		                            <div class="header_login_list">Manager</div>
		                        </a>
		                    </div>
						</c:when>
						<c:otherwise>
							<!-- 로그아웃 상태 -->
		                    <div class="header_login_menu">
		                        <a href="${pageContext.request.contextPath}/loginPage">
		                            <div class="header_login_list">Login</div>
		                        </a>
		                        <a href="">
		                            <div class="header_login_list">Join</div>
		                        </a>
		                        <a href="">
		                            <div class="header_login_list">CS CENTER</div>
		                        </a>
		                    </div>
						</c:otherwise>
					</c:choose>
					
                </div>
            </div>
            

            <div class="header_search_tab">

                <div class="header_search_close">
                    close
                </div>
                <!-- <div style="clear: both;"></div> -->

                <div class="header_search_box">
                    <form action="">
                        <input type="text" name="search_keyword" placeholder="제품명을 입력하세요"/>
                    </form>
                    <div class="header_search_box_input_delete">
                        <img src="${pageContext.request.contextPath}/resources/img/icon_close_big.png" alt="">
                    </div>
                    <div class="header_search_box_submit">
                        <img src="${pageContext.request.contextPath}/resources/img/btn_search_big.png" alt="">
                    </div>
                </div>
            </div>

			
			
			<!-- 채팅 -->
			<!-- header_chat_hidden -->
			<div class="
				header_chat_small
				${sessionScope.chatSize == null ? '' : 'header_chat_hidden'}
			">
				<button type="button">실시간 채팅 상담</button>
			</div>

			<!-- header_chat_hidden -->
			<div class="
				header_chat
				${sessionScope.chatSize == null ? 'header_chat_hidden' : ''}
			">
				<div class="header_chat_close_btn ">
					<button type="button">채팅기록 삭제</button>
					<img src="${pageContext.request.contextPath}/resources/img/icon_close_big.png"/>
				</div>
				<div class="header_chat_inner">
				
					<!--  
					<div class="header_chat_admin">
						<div>상담원</div>
						<div>상담사 채팅 예시</div>
					</div>
					
					<div class="header_chat_customer">
						<div>고객</div>
						<div>고객 채팅 예시</div>
					</div>
					-->
					 
				</div>
				<!-- header_chat_inner -->
				
				<div class="header_chat_insert">
					<input type="text" name="header_chat" placeholder="내용입력"/>
					<input type="button" value="전송"/>										
					<input type="hidden" value="${sessionScope.loginId}"/>
				</div>
				<!-- header_chat_insert -->
				
			</div>
			<!-- header_chat -->

			
        </div>
        <!-- header_inner 종료 -->
        
        
        <input type="hidden" name="admin_check" value="${sessionScope.adminCheck}"/>
    </header>

</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
<script>
$(function() {

	const pathname = "/" + window.location.pathname.split("/")[1] + "/";
	const origin = window.location.origin;
	const contextPath = origin + pathname;
	

	// localStorage가 채팅기록이 있으면 표시
	if(localStorage.getItem("chatHistory")) {
		$(".header_chat_inner").html(localStorage.getItem("chatHistory"));
	}	
	
	// 채팅 스크롤 맨 아래로
	function chatScroll() {
		$('.header_chat_inner ').scrollTop($('.header_chat_inner')[0].scrollHeight);
	}
	chatScroll();
	
	// 채팅기록 삭제
	$(".header_chat_close_btn > button").click(function() {
		$(".header_chat_inner").html("");
		localStorage.clear();
	})
	
	// 채팅창 열기
	$(".header_chat_small > button").click(function() {
		$(".header_chat_small").addClass("header_chat_hidden");
		$(".header_chat").removeClass("header_chat_hidden");
		
		$.ajax({
			type: "GET",
			async: true,
			url: contextPath + "api/chatSize",
			data: {
				chatSize: "big"
			},
			dataType: "json",
			success: function(response) {
				console.log("chat big success");
			}, error: function() {
				console.log("chat big error");
			}, complete: function() {
				console.log("chat big complete");
			}
		})
		
	}) 
	
	// 채팅창 닫기
	$(".header_chat_close_btn > img").click(function() {
		$(".header_chat").addClass("header_chat_hidden");
		$(".header_chat_small").removeClass("header_chat_hidden");
		
		$.ajax({
			type: "GET",
			async: true,
			url: contextPath + "api/chatSize",
			data: {
				chatSize: "small"
			},
			dataType: "json",
			success: function(response) {
				console.log("chat small success");
			}, error: function() {
				console.log("chat small error");
			}, complete: function() {
				console.log("chat small complete");
			}
		})
		
	}) 

	
	
	// 로그인한 사용자 관리자 여부 true, false
	let adminCheckValue = $("input[name='admin_check']").val();

	// 로그인한 사용자 관리자 여부 체크
	function adminCheckFunc() {
		if(adminCheckValue == "true") {
			return true;
		} else {
			return false;
		}
	}
	
	
	// 채팅 웹소켓
	let webSocket = new WebSocket("ws://localhost:9090/www/chat");
	webSocket.onmessage = onMessage;
	webSocket.onopen = onOpen;
	webSocket.onerror = onError;
	
	// 채팅 도착
	function onMessage(e) {
		
		let msgContent = JSON.parse(e.data);
		let userAppend = (msgContent.user === "상담원") ? "상담원" : "고객";
		
		$(".header_chat_inner").append(
			'<div class="header_chat_customer">' +
				'<div>' + userAppend + '</div>' +
				'<div>' + msgContent.content + '</div>' +
			'</div>'
		);
		
		let chatHistory = $(".header_chat_inner").html();
		
		// localStorage에 채팅기록 저장
		localStorage.setItem("chatHistory", chatHistory);
	}
	
	// 채팅 시작
	function onOpen() {
		/*
		$(".header_chat_inner").append(
				'<div class="header_chat_customer" style="color: #f986bd">' +
					'<div>실시간 채팅 상담 시작</div>' +
				'</div>'
		);
		*/
	}
	
	// 채팅 에러
	function onError() {
		alert("error");
	}
	
	// 채팅 전송 클릭
	$("input[type='button']").click(function() {
		let loginId = $("input[type='hidden']").val();
		let msg = $("input[name='header_chat']").val();
		let user = adminCheckFunc() ? "상담원" : "고객";
		
		let sendContents = JSON.stringify({
			content: msg,
			user: user
		});
		
		webSocket.send(sendContents);
		
		$(".header_chat_inner").append(
			'<div class="header_chat_admin">' +
				'<div>나</div>' +
				'<div>' + msg + '</div>' +
			'</div>'
		);
		
		let chatHistory = $(".header_chat_inner").html();
		
		// localStorage에 채팅기록 저장
		localStorage.setItem("chatHistory", chatHistory);
		
		$("input[name='header_chat']").val('');
		chatScroll();
	})
	
	/////////////////////////////////////////////
	
	
	// 수빈 manager 작업
	let loginId = "${sessionScope.loginId}"; // JSP에서 세션 값을 JavaScript로 전달
	
	$("#managerPage").click(function(e) {
		if(loginId!="admin") {
			alert("관리자만 접근 가능한 페이지 입니다!");
			e.preventDefault();
		}
	});
	
	<c:if test="${pageContext.request.requestURI.contains('manager.jsp') || pageContext.request.requestURI.contains('payment.jsp')}">
	// 알림 채팅
	let name = "${sessionScope.loginId}";
	let ws;
	const url = "ws://localhost:9090/www/alarm";
	
	
	function connect(name) {
		
		// 서버와 연결하기 > 소켓 생성
		ws = new WebSocket(url);
		
		ws.onopen = function(evt){
			
			let message = {
					code: '1',
					sender : name,
					receiver : '',
					content : '',
					regdate : new Date().toLocaleString()
			};
			
			// json 문자열로 변환후 전송 
			ws.send(JSON.stringify(message));
			print('', '대화방에 참여했습니다', 'me', 'state', message.regdate);
			
			$('#msg').focus();
		};
		
		// 서버에서 클라이언트에게 전달한 메시지 
		ws.onmessage = function(evt) {
			let message = JSON.parse(evt.data);
			
			if(message.code == '1') {
				print('', '[' + message.sender + ']님이 들어왔습니다.', 'other', 'state', message.regdate);
			} else if (message.code == '2') {
				print('', '[' + message.sender + ']님이 나갔습니다.', 'other', 'state', message.regdate);
			} else if (message.code == '3') {
				print(message.sender, message.content, 'other', 'msg', message.regdate);
			}
		};
		
		// 대화창 출력 메소드 
		function print(name, msg, side, state, time) {
			let temp =  
				"<div class='item " + state + " " + side + "'>"
				  + "<div>"
				  + "<div>" + name + "</div>"
				  + "<div>" + msg + "</div>"
				  + "</div>"
				  + "<div>" + time + "</div>"
				  + "<div>";

				
				$("#list").append(temp);
				
				// 새로운 내용이 추가되면 스크롤을 바닥으로 내린다 
				scrollList();
		}
		
		$(window).on('beforeunload', function() {
			disconnect();
		});
		
		function disconnect() {
			let message = {
					code : '2',
					sender : name,
					receiver : '',
					content : '',
					regdate : new Date().toLocaleString()
			};
			
			ws.send(JSON.stringify(message));
		}
		
		// 대화 스크롤 이벤트
		function scrollList() {
			$('#list').scrollTop($('#list').outerHeight() + 300);
		}
		
		$("#msg").keydown(function(evt) {
			// 엔터를 눌러서 대화 내용을 서버로 전달
			if(evt.keyCode == 13) { // 엔터
				let message = {
						code : '3',
						sender : name,
						receiver : '',
						content : $("#msg").val(),
						regdate : new Date().toLocaleString()
				};
				
				ws.send(JSON.stringify(message));
				
				$("#msg").val('').focus();
				
				print(name, message.content, 'me', 'msg', message.regdate);
			}
		});
		

		
	}
	
	connect(name);
	</c:if>
	
	
	
	
	
})
</script>
</html>