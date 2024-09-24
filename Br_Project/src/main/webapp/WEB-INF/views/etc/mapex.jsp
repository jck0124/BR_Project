<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" crossorigin="anonymous"></script>
</head>
<body>
    <div id="map" style="width:500px; height:400px;"></div>
    하이
    
</body>
<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=022e6a3260371b2c8dc3e8b1437a10c1"></script>
<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function() {
        var container = document.getElementById('map');
        var options = {
            center: new kakao.maps.LatLng(33.450701, 126.570667),
            level: 3
        };

        var map = new kakao.maps.Map(container, options);
    });
</script>
</html>