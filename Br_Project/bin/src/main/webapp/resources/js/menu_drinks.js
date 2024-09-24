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