<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href="/css/member/update.css">
</head>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>

    <div id="container">
        <h3> 수정 페이지임 </h3>
        <div> 회원번호 <span class="mno"> </span></div>
        <div>아이디 : <sapn class="mid"> </sapn></div>
        <div>변경할 이름 : <input class="mname" /> </div>
        <div>변경할 번호 : <input class="mphone" /> </div>
    <button type="button" onclick="onUpdate()"> 수정하기 </button>
    </div>

    <script src="/js/member/update.js"></script>
</body>
</html>