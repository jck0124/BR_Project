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
			<div class="header_chat_small ">
				<button type="button">실시간 채팅 상담</button>
			</div>

			<!-- header_chat_hidden -->
			<div class="header_chat header_chat_hidden">
				<div class="header_chat_close_btn ">
					<img src="${pageContext.request.contextPath}/resources/img/icon_close_big.png"/>
				</div>
				<div class="header_chat_inner">
					
					<div class="header_chat_admin">
						<div>상담원</div>
						<div>상담원 채팅123</div>
					</div>
					
					<div class="header_chat_admin">
						<div>상담원</div>
						<div>상담원 채팅123</div>
					</div>
					
					<div class="header_chat_customer">
						<div>나</div>
						<div>고객 채팅123</div>
					</div>
					
					<div class="header_chat_customer">
						<div>나</div>
						<div>고객 채팅123</div>
					</div>
				
					 <div class="header_chat_admin">
						<div>상담원</div>
						<div>상담원 채팅123</div>
					</div>
					
					<div class="header_chat_customer">
						<div>나</div>
						<div>고객 채팅123</div>
					</div>
					
						<div class="header_chat_customer">
						<div>나</div>
						<div>고객 채팅123</div>
					</div>
					
					<div class="header_chat_customer">
						<div>나</div>
						<div>고객 채팅123</div>
					</div>
				
					 <div class="header_chat_admin">
						<div>상담원</div>
						<div>상담원 채팅123</div>
					</div>
					
					<div class="header_chat_customer">
						<div>나</div>
						<div>고객 채팅123</div>
					</div>
					
					 
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
    </header>

</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
</html>