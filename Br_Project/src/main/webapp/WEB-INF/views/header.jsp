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
		                        <c:if test="${sessionScope.adminCheck}">
			                        <a href="${pageContext.request.contextPath}/manager" id="managerPage">
			                            <div class="header_login_list">Manager</div>
			                        </a>
		                        </c:if>
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
			<!-- header_chat_hidden header_new_chat -->
			<div class="
				header_chat_small
				${sessionScope.chatSize == null ? '' : 'header_chat_hidden'}
			">
				<button type="button">실시간 채팅 상담</button>
			</div>

			<!-- header_chat_hidden header_new_chat -->
			<div class="
				header_chat
				${sessionScope.chatSize == null ? 'header_chat_hidden' : ''}
			">	
				
				<div class="header_chat_close_btn ">
					<button type="button" class="delete_chat_histroy">채팅삭제</button>
					<c:if test="${sessionScope.adminCheck}">
						<button type="button" class="return_to_chat_list">채팅목록</button>
					</c:if>
					<img src="${pageContext.request.contextPath}/resources/img/icon_close_big.png"/>
				</div>
					
				
				<c:if test="${sessionScope.adminCheck}">
					<!-- 채팅목록 -->
					<div>새로운 채팅</div>
					<div class="header_chat_list_container">
					
						
					</div>
				</c:if>
				
				
				<div class="
					header_chat_selected
					<c:if test="${sessionScope.adminCheck}">
						header_chat_selected_hidden
					</c:if>
				">
					<!-- 채팅내용 -->	
					<div class="header_chat_inner">
						
					</div>
					
					<div class="header_chat_insert">
						<input type="text" name="header_chat" placeholder="내용입력"/>
						<input type="hidden" name="login_id" value="${sessionScope.loginId}"/>
						<input type="button" value="전송"/>										
					</div>
				</div>
				
				
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
	
	let loginId = $("input[name='login_id']").val();

	// localStorage가 채팅기록이 있으면 표시
	if(localStorage.getItem("chatHistory")) {
		$(".header_chat_inner").html(localStorage.getItem("chatHistory"));
	}	
	
	
	// 관리자 - 채팅목록 있으면 표시
	if(localStorage.getItem("chatListContainer")) {
		$(".header_chat_list_container").html(localStorage.getItem("chatListContainer"));
	}
	
	// 채팅 스크롤 맨 아래로
	function chatScroll() {
		$('.header_chat_inner ').scrollTop($('.header_chat_inner')[0].scrollHeight);
	}
	chatScroll();
	
	// 채팅기록 삭제
	$(".header_chat_close_btn > .delete_chat_histroy").click(function() {
		$(".header_chat_inner").html("");
		localStorage.clear();
	})
	
	// 관리자 - 1:1채팅에서 채팅목록으로 돌아가기
	$(".header_chat_close_btn > .return_to_chat_list").click(function() {
		$(".header_chat_list_container").removeClass("header_chat_list_hidden");
		$(".header_chat_selected").addClass("header_chat_selected_hidden");
	})
	
	// 관리자 - 1:1 채팅 선택
	$(".header_chat_list").on("click", function() {
		$(".header_chat_list_container").addClass("header_chat_list_hidden");
		$(".header_chat_selected").removeClass("header_chat_selected_hidden");
		$(this).removeClass("header_chat_list_new_chat");
		
		let chatListContainer = $(".header_chat_list_container").html();
		localStorage.setItem("chatListContainer", chatListContainer);
	})
	
	
	// 채팅창 열기
	$(".header_chat_small > button").click(function() {
		$(".header_chat_small").addClass("header_chat_hidden");
		$(".header_chat").removeClass("header_chat_hidden");
		
		$(".header_chat").removeClass("header_new_chat");
		$(".header_chat_small").removeClass("header_new_chat");
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

	// 채팅창에 마우스가 들어올시 new 알림 사라짐
	$(".header_chat").mouseenter(function() {
		$(".header_chat").removeClass("header_new_chat");
		$(".header_chat_small").removeClass("header_new_chat");
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
	
	// 채팅 전송
	$("input[type='button']").click(function() {
		
		if(loginId === null || loginId === "") {
			alert("로그인 후 이용가능합니다.");
		} else {
		
			let msg = $("input[name='header_chat']").val();
			
			let sender = loginId;
			let receiver = (sender != 'admin') ? 'admin' : '보낼고객아이디';
			
			$(".header_chat_inner").append(
				'<div class="header_chat_self">' +
					'<div>나</div>' +
					'<div>' + msg + '</div>' +
				'</div>'  
			);
			
			let chatHistory = $(".header_chat_inner").html().trim();
				
			
			
			let sendContents = JSON.stringify({
				sender: sender,
				receiver: receiver,
				msg: msg,
				chatHistory: chatHistory
			});
			
			webSocket.send(sendContents);
			
			// localStorage에 채팅기록 저장
			localStorage.setItem("chatHistory", chatHistory);
			
			$("input[name='header_chat']").val('');
			chatScroll();
		}
	})
	
	
	// 채팅 도착
	function onMessage(e) {
		
		let msgContent = JSON.parse(e.data);
		let sender = msgContent.sender;
		let receiver = msgContent.receiver;
		
		// 관리자 - 새로운 채팅표시
		if(adminCheckFunc) {
			let str = 
				"<div class='header_chat_list header_chat_list_new_chat'>" +
					"<div>" + sender + "</div>" +
				"</div>";
			$(".header_chat_list_container").append(str);
			
			let chatListContainer = $(".header_chat_list_container").html();
			localStorage.setItem("chatListContainer", chatListContainer);
		}
		
		if(receiver === loginId) {
			$(".header_chat_inner").append(
					'<div class="header_chat_other">' +
						'<div>' + msgContent.sender + '</div>' +
						'<div>' + msgContent.msg + '</div>' +
					'</div>'
			);
			
			let chatHistory = $(".header_chat_inner").html();
			
			// localStorage에 채팅기록 저장
			localStorage.setItem("chatHistory", chatHistory);
			
			$(".header_chat").addClass("header_new_chat");
			$(".header_chat_small").addClass("header_new_chat");		
		}
	}
	
	
	
	
	// 채팅 시작
	function onOpen() {
		/*
		$(".header_chat_inner").append(
				'<div class="header_chat_other" style="color: #f986bd">' +
					'<div>실시간 채팅 상담 시작</div>' +
				'</div>'
		);
		*/
	}
	
	// 채팅 에러
	function onError() {
		alert("error");
	}
	
	
})
</script>
</html>