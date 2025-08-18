<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="/css/yeonsu/map.css" rel="stylesheet">

</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="ser"> 검색하기 : <input id="serch" placeholder="위치찾기" type="text"/> <!-- gpt 참고 -->
    <button type="button" onclick="serc()"> 찾기 </button> </div>
    <div id="container">
        <div id="map" style="width: 70%; height: 500px;"> </div>
        <div id="sidebar"> </div>
    </div>
    

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1ac4a57d8a5927d34020a891fcdbbcbd&libraries=clusterer"></script>
    <script src="/js/yeonsu/map.js"></script>

</body>
</html>