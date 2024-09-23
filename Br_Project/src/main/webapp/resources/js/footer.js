$(function() {
	
	// FAMILY SITE 클릭시 화살표 회전
	let family = 0;
	$("#family_site_box").hide();
	
	$("#btn_family_site").click(function(){
		family += 1;
		if(family%2 == 1){
			$(".arrow_icon").css("transform" ,"rotate(180deg)");
			$("#family_site_box").slideDown(300);
		} else {
			$(".arrow_icon").css("transform" ,"rotate(0deg)");
			$("#family_site_box").slideUp(300);
		}
	});
	
	// FAMILY SITE 클릭시 나오는 ul
	
});