$(function() {

    // header 검색창 열기
    $(".header_search").click(function() {
            $("header").addClass("search_active");
    });

    // header 검색버튼 닫기
    $(".header_search_close").click(function() {
            $("header").removeClass("search_active");
    })

    // header 검색창 검색어 삭제
    $(".header_search_box_input_delete").click(function() {
        $("input[name='search_keyword']").val("");
    })

    // header 검색창 submit
    $(".header_search_box_submit").click(function() {
        $(this).siblings("form").submit();
    })

    // 로그인 텝메뉴 켜기
    $(".header_login").click(function(e) {
        e.stopPropagation();
        $(".header_login_menu").css("display", "block");
    });

    // 로그인 탭메뉴 끄기
    $("body").click(function() {
        $(".header_login_menu").css("display", "none");
    });

    // 로그인 탭메뉴 이벤트 전파 막기
    $(".header_login_menu > a").click(function(e) {
        e.stopPropagation();
    });





}) 