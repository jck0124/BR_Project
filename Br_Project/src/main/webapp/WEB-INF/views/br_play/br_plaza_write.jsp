<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/br_plaza_write.css">
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	
	
	<!-- 페이지 이동 -->
	<div id="menu_location">
		<a href="${pageContext.request.contextPath}/event">이벤트</a>
		<a href="${pageContext.request.contextPath}/br_plaza">배라광장</a>
		<a href="${pageContext.request.contextPath}/br_recipe">BR 레시피</a>
		<a href="">마이플레이버 리스트</a>
	</div>
	
	<div id="iceCreamCake">
		<div>배라광장</div>
		<div>배라에게 묻고 배라가 답해드려요,</div>
		<div>배라에게 다양한 의견을 전달해주세요</div>
	</div>
	

	
	<table>
		<form action="${pageContext.request.contextPath}/br_plaza_write">
			<input type="hidden" name="writer_id" value="${sessionScope.loginId}"/>
			<tbody>
				<tr>
					<td>작성자</td>
					<td class="text_align_left">
						<input type="text" name="writer_name"/>
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td class="text_align_left">
						<input type="text" name="title"/>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>	
						<textarea rows="3" name="content" placeholder="내용을 입력하세요."></textarea>
					</td>
				</tr>
				<tr>
					<td>작성자 공개</td>
					<td class="text_align_left">	
						동의합니다. <input type="radio" name="agreement" value="agree"/>
						동의하지않습니다.<input type="radio" name="agreement" value="disagree" checked="checked"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="작성완료"/>
						<button type="button">
							<a href="${pageContext.request.contextPath}/br_plaza">목록으로</a>
						</button>
					</td>
				</tr>
			</tbody>
		</form>
	</table>
		
	
	<%@ include file="../footer.jsp" %>
</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.mousewheel.min.js"></script>
<script>
$(function() {
	
	const pathname = "/" + window.location.pathname.split("/")[1] + "/";
	const origin = window.location.origin;
	const contextPath = origin + pathname;
	
	// 게시글 작성 빈칸 확인
	function formCheck() {
		let writer = $("input[name='writer_name']"); 
		let title = $("input[name='title']");
		let content = $("textarea[name='content']");
		
		if(writer.val().trim() == "") {
			alert("작성자를 입력해주세요.");
			writer.focus();
			return false;
		} else if(title.val().trim() == "") {
			alert("제목을 입력해주세요.");
			title.focus();
			return false;
		} else if(content.val().trim() == "") {
			alert("내용을 입력해주세요.");
			content.focus();
			return false;
		} else {
			return true;
		}
	}
	
	
	$("input[type='submit']").click(function(e) {
		
		if( formCheck() ) {
			alert("게시글 작성이 완료되었습니다.");
		} else {
			e.preventDefault();
		}
	})
	
	
	
})
</script>
</html>